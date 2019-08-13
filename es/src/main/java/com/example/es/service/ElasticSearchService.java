package com.example.es.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.es.commom.utils.JsonUtils;
import com.example.es.dto.EsTo;
import com.example.es.model.PayStrategyData;
import org.assertj.core.util.Lists;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhw
 * @Date 16:46 2019/6/27
 * @Description 使用es查询服务
 */
@Service
public class ElasticSearchService {

    private static final Logger logger = LoggerFactory.getLogger(ElasticSearchService.class);

    @Autowired
    private RestHighLevelClient rhlClient;

    /**
     * 创建index 为什么了
     * <p>
     * 暂时不行
     *
     * @return
     */
    public String indexCreate() {
        try {
            CreateIndexRequest index = new CreateIndexRequest("index_name");
            Map<String, Object> properties = new HashMap<>();
            Map<String, Object> propertie = new HashMap<>();
            propertie.put("type", "text");
            propertie.put("index", true);
            propertie.put("analyzer", "ik_max_word");
            properties.put("field_name", propertie);
            XContentBuilder builder = JsonXContent.contentBuilder();
            builder.startObject().startObject("mappings").startObject("index_name").field("properties", properties).endObject().endObject().startObject("settings").field("number_of_shards", 3).field("number_of_replicas", 1).endObject().endObject();
            index.source(builder);
            CreateIndexResponse createIndexResponse = rhlClient.indices().create(index, RequestOptions.DEFAULT);
            return createIndexResponse.index();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 判断index是否存在
     *
     * @param indexName
     * @return
     */
    public boolean indexExists(String indexName) {
        GetIndexRequest request = new GetIndexRequest(indexName);
        try {
            return rhlClient.indices().exists(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 精确删除文档
     *
     * @param indexName
     * @return
     */
    public boolean deleteIndex(String indexName, String documentId) {
        DeleteRequest document = new DeleteRequest(indexName, indexName, documentId);
        try {
            rhlClient.delete(document, RequestOptions.DEFAULT);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 添加
     *
     * @param indexName
     * @param data
     * @return
     */
    public IndexResponse documentInsert(String indexName, Map<String, List<PayStrategyData>> data) {
        IndexRequest indexRequest = new IndexRequest(indexName, indexName);
        indexRequest.source(JsonUtils.toJsonString(data), XContentType.JSON);
        try {
            return rhlClient.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查询
     *
     * @param indexName
     * @param query
     * @return
     */
    public List<Map<String, Object>> documentQuery(String indexName, Map<String, EsTo> query) {
        List<Map<String, Object>> result = Lists.newArrayList();
        SearchRequest searchRequest = new SearchRequest(indexName);
        searchRequest.types(indexName);
        queryBuilder(null, null, query, searchRequest);
        try {
            SearchResponse response = rhlClient.search(searchRequest, RequestOptions.DEFAULT);
            for (SearchHit hit : response.getHits().getHits()) {
                Map<String, Object> map = hit.getSourceAsMap();
                map.put("id", hit.getId());
                result.add(map);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void queryBuilder(Integer pageIndex, Integer pageSize, Map<String, EsTo> query, SearchRequest searchRequest) {
        if (query != null && !query.keySet().isEmpty()) {
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            if (pageIndex != null && pageSize != null) {
                searchSourceBuilder.size(pageSize);
                if (pageIndex <= 0) {
                    pageIndex = 0;
                }
                searchSourceBuilder.from((pageIndex - 1) * pageSize);
            }
            BoolQueryBuilder boolBuilder = QueryBuilders.boolQuery();
            query.keySet().forEach(key ->
                    boolBuilder.must(QueryBuilders.matchQuery(key, query.get(key)))
            );
            searchSourceBuilder.query(boolBuilder);
            searchRequest.source(searchSourceBuilder);
        }
    }


}
