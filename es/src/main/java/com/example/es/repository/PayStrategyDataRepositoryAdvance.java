package com.example.es.repository;

import com.example.es.model.PayStrategyData;

import java.util.List;

/**
 * es mongodb
 *
 * @author zhw
 * @date 13:52 2019/8/13
 */
public interface PayStrategyDataRepositoryAdvance {

    /**
     * 门店信息
     *
     * @return
     */
    List<PayStrategyData> findShopInfo();


    /**
     * 根据连锁获取门店信息
     *
     * @param custId
     * @param compId
     * @return
     */
    List<PayStrategyData> getShopInfo(String custId, String compId);

}
