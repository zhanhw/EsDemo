package com.example.es.commom;

import lombok.*;

/**
 * 返回对象
 *
 * @author zhw
 * @date 14:04 2019/8/13
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultTo<T> {

    private int code = 200;
    private boolean success = true;
    private String message;
    private T result;
    private PageTo page;


    public void authException(String message) {
        this.code = 403;
        this.message = message;
        this.success = false;
    }

    public void commonException(String message) {
        this.code = 400;
        this.message = message;
        this.success = false;
    }

    public void serverException(String message) {
        this.code = 500;
        this.message = message;
        this.success = false;
    }

}
