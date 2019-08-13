package com.example.es.repository;

import com.example.es.model.PayStrategyData;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * es mongodb
 *
 * @author zhw
 * @date 13:51 2019/8/13
 */
public interface PayStrategyDataRepository extends MongoRepository<PayStrategyData, String>, PayStrategyDataRepositoryAdvance {
}
