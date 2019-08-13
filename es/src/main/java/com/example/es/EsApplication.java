package com.example.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

/**
 * @Author zhw
 * @Date 16:41 2019/6/27
 * @Description Es 主controller
 */
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class EsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsApplication.class, args);
	}

}
