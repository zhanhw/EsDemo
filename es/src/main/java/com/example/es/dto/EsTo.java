package com.example.es.dto;

/**
 * @Author zhw
 * @Date 17:46 2019/6/27
 * @Description es查询对象
 */
public class EsTo {

    private String name;

    private String address;

    public EsTo(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
