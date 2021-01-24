package com.example.Es.mapper;

import com.example.Es.model.BaseLog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * es dao
 *
 * @author 阿伟
 * @date 2021/1/24 22:20
 */
public interface BaseLogRepository extends ElasticsearchRepository<BaseLog, String>, BaseLogRepositoryAdvance {
    

}
