package com.example.es.service;

import com.example.es.mapper.BaseLogRepository;
import com.example.es.model.BaseLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * @author 阿伟
 * @date 2021/1/24 22:37
 */
@Slf4j
@Service
public class BaseLogService {

    @Autowired
    private BaseLogRepository baseLogRepository;

    public void save(String log) {
        BaseLog save = baseLogRepository.save(BaseLog.builder().logId(UUID.randomUUID().toString()).content(log).time(new Date()).build());
        System.out.println(save.toString());
    }

    public BaseLog get(String logId) {
        return baseLogRepository.findById(logId).orElse(BaseLog.builder().build());
    }

}
