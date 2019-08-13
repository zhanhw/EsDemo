package com.example.es.repository.impl;

import com.example.es.model.PayStrategyData;
import com.example.es.repository.PayStrategyDataRepositoryAdvance;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import javax.annotation.Resource;
import java.util.List;

/**
 * 门店信息
 *
 * @author zhw
 * @date 13:56 2019/8/13
 */
public class PayStrategyDataRepositoryImpl implements PayStrategyDataRepositoryAdvance {


    @Resource(name = "shopMongo")
    private MongoTemplate template;

    @Override
    public List<PayStrategyData> findShopInfo() {
        return template.findAll(PayStrategyData.class);
    }

    @Override
    public List<PayStrategyData> getShopInfo(String custId, String compId) {
        Criteria criteria = Criteria.where("custId").is(custId)
                .and("compId").is(compId);
        return template.find(Query.query(criteria), PayStrategyData.class);
    }
}
