package com.example.config;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.Node;
import org.elasticsearch.client.NodeSelector;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * es 配置
 *
 * @author zhw
 * @date 16:47 2019/8/6
 */
@Configuration
public class RestConfig {

    private static final Logger logger = LoggerFactory.getLogger(RestConfig.class);

    @Bean
    public RestClient getClient() {
        // 如果有多个从节点可以持续在内部new多个HttpHost，参数1是ip,参数2是HTTP端口，参数3是通信协议
        RestClientBuilder clientBuilder = RestClient.builder(new HttpHost("localhost", 9200, "http"));

        // 添加其他配置，返回来的还是RestClientBuilder对象，这些配置都是可选的
        // 设置请求头，每个请求都会带上这个请求头
        Header[] defaultHeaders = {new BasicHeader("header", "value")};
        clientBuilder.setDefaultHeaders(defaultHeaders);

        // 设置监听器，每次节点失败都可以监听到，可以作额外处理
        clientBuilder.setFailureListener(new RestClient.FailureListener() {
            @Override
            public void onFailure(Node node) {
                super.onFailure(node);
                logger.warn("{} ==节点失败了", node.getName());
            }
        });

        /**
         * 配置节点选择器，客户端以循环方式将每个请求发送到每一个配置的节点上，
         * 发送请求的节点，用于过滤客户端，将请求发送到这些客户端节点，默认向每个配置节点发送，
         * 这个配置通常是用户在启用嗅探时向专用主节点发送请求（即只有专用的主节点应该被HTTP请求命中）
         */
        clientBuilder.setNodeSelector(NodeSelector.SKIP_DEDICATED_MASTERS);

        // 最后配置好的clientBuilder再build一下即可得到真正的Client
        return clientBuilder.build();
    }

}
