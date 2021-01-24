package com.example.Es.mapper;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义查询
 *
 * @author 阿伟
 * @date 2021/1/24 22:28
 */
public class BaseLogRepositoryImpl implements BaseLogRepositoryAdvance {

    @Autowired
    private RestHighLevelClient restHighLevelClient;


}
