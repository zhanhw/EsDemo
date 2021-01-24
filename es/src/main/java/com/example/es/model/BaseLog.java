package com.example.Es.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * 对象
 *
 * @author 阿伟
 * @date 2021/1/24 22:15
 */

@Data
@Builder
@Document(indexName = "base_log")
public class BaseLog {

    @Id
    private String logId;

    private String content;

    @Field(type = FieldType.Date, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

}
