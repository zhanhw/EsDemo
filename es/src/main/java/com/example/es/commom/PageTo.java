package com.example.es.commom;

import lombok.*;

/**
 * 分页参数
 *
 * @author zhw
 * @date 14:05 2019/8/13
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageTo {

    private int total;
    private int totalPage;
    private int currentPage;
    private int pageSize;
}
