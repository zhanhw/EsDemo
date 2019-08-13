package com.example.es.config;

import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * mongodb 配置
 *
 * @author zhw
 * @date 13:46 2019/8/13
 */
@Configuration
@EnableMongoRepositories(basePackages = {"com.example.es.repository"}, mongoTemplateRef = "shopMongo")
public class MongoConfig {

    @Value("${spring.data.mongodb.order.uri}")
    private String uri;

    private MongoDbFactory mongoDbFactory() {
        MongoClientURI mongoClientUri = new MongoClientURI(this.uri);
        return new SimpleMongoDbFactory(mongoClientUri);
    }

    @Bean(name="shopMongo")
    public MongoTemplate getMongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }

}


