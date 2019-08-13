package com.example.es.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.es.commom.ResultTo;
import com.example.es.commom.utils.JsonUtils;
import com.example.es.dto.EsTo;
import com.example.es.model.PayStrategyData;
import com.example.es.repository.PayStrategyDataRepository;
import com.example.es.service.ElasticSearchService;
import org.assertj.core.util.Maps;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zhw
 * @Date 16:41 2019/6/27
 * @Description Es 测试controller
 */
@RestController
@RequestMapping("/test")
public class EsController {

    private static final Logger logger = LoggerFactory.getLogger(EsController.class);

    @Autowired
    private ElasticSearchService elasticSearchService;

    @Autowired
    private PayStrategyDataRepository payStrategyDataRepository;

    @GetMapping("/get/{custId}")
    public ResultTo get(@PathVariable String custId, @RequestParam String compId) {
        ResultTo build = ResultTo.builder().build();
        build.setResult(payStrategyDataRepository.getShopInfo(custId, compId));
        return build;
    }

    @PutMapping("/move/{indexName}")
    public ResultTo move(@PathVariable String indexName, @RequestParam String custId, @RequestParam String compId) {
        List<PayStrategyData> shopInfos = payStrategyDataRepository.getShopInfo(custId, compId);
        Map<String, List<PayStrategyData>> map = Maps.newHashMap(custId + "--" + compId, shopInfos);
        IndexResponse indexResponse = elasticSearchService.documentInsert(indexName, map);
        ResultTo build = ResultTo.builder().build();
        build.setResult(indexResponse);
        return build;
    }

    @DeleteMapping("/delete/{indexName}")
    public ResultTo delete(@PathVariable String indexName, @RequestParam String documentId) {
        boolean b = elasticSearchService.deleteIndex(indexName, documentId);
        ResultTo build = ResultTo.builder().build();
        build.setResult(b);
        return build;
    }
}
