package com.example.es;

import com.example.es.service.BaseLogService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class esApplicationTests {

    @Autowired
    private BaseLogService baseLogService;

    @Test
    void save() {
        baseLogService.save("hello es+kibana");
    }

    @Test
    void get() {
        log.info(baseLogService.get("1c0b14d2-51ba-4941-a3ae-63dae277d261").toString());
    }

}
