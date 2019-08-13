package com.example.es.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.*;

/**
 * 门店信息
 *
 * @author zhw
 * @date 13:53 2019/8/13
 */
@Document(collection = "pay_strategy_data")
public class PayStrategyData {

    @Id
    private String id;

    /**
     * 门店ID
     */
    private String shopId;
    /**
     * 博卡连锁代码
     */
    private String custId;
    /**
     * 博卡公司代码
     */
    private String compId;
    /**
     * 支付类型
     * <p>
     * alipay 支付宝
     * wechat 微信
     * unionPay 云闪付
     */
    private String payType;
    /**
     * 支付渠道类型
     * <p>
     * MCB 上海银行
     * CUM 银联
     * CHAN 畅捷
     * FUIOU 富友
     * OFFICIAL 官方
     * WS 网商
     */
    private String payChannelType;
    /**
     * 商户号
     */
    private String mchId;
    /**
     * 商户密钥
     */
    private String key;
    /**
     * 微信appId
     */
    private String appId;
    /**
     * 微信小程序子商户号ID
     */
    private String minAppMchId;
    /**
     * 小程序APPID 用于第三方渠道判定是否开通小程序支付的条件
     */
    private String minAppId;
    /**
     * 支付宝商户账号 口碑使用
     */
    private String aliUserId;
    /**
     * 支付宝门店审核状态
     */
    private String aliAuditStatus;
    /**
     * 银联渠道key
     */
    private String cumKey = "e8a47e80c23a482691b1433bdb385373";
    /**
     * 银联渠道appId
     */
    private String cumAppId = "469381426074af4b016078028bca00d1";
    /**
     * 银联渠道
     */
    private String cumTerminal;
    /**
     * 畅捷商户号
     */
    private String chanMchId;
    /**
     * 畅捷秘钥
     */
    private String chanKey;
    /**
     * 富友商户号
     */
    private String fuIouMchId;
    /**
     * 富友秘钥
     */
    private String fuIouKey;
    /**
     * 网商商户号
     */
    private String wsMchId;
    /**
     * 新增支付宝官方渠道号:默认为userId 用来区分是否是口碑的 有值表示口碑
     */
    private String officialMchId;
    /**
     * 是否启用 1 启用 0 关闭
     */
    private Integer status;
    /**
     * 优先级 数字越小 优先级越高  0 最高
     */
    private Integer priority;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 开店成功时间
     */
    private Date successDate;
    /**
     * 开店时间
     */
    private Date openDate;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Date getSuccessDate() {
        return successDate;
    }

    public void setSuccessDate(Date successDate) {
        this.successDate = successDate;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCompId() {
        return compId;
    }

    public void setCompId(String compId) {
        this.compId = compId;
    }

    public String getPayChannelType() {
        return payChannelType;
    }

    public void setPayChannelType(String payChannelType) {
        this.payChannelType = payChannelType;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMinAppMchId() {
        return minAppMchId;
    }

    public void setMinAppMchId(String minAppMchId) {
        this.minAppMchId = minAppMchId;
    }

    public String getMinAppId() {
        return minAppId;
    }

    public void setMinAppId(String minAppId) {
        this.minAppId = minAppId;
    }

    public String getAliUserId() {
        return aliUserId;
    }

    public void setAliUserId(String aliUserId) {
        this.aliUserId = aliUserId;
    }

    public String getAliAuditStatus() {
        return aliAuditStatus;
    }

    public void setAliAuditStatus(String aliAuditStatus) {
        this.aliAuditStatus = aliAuditStatus;
    }

    public String getCumKey() {
        return cumKey;
    }

    public void setCumKey(String cumKey) {
        this.cumKey = cumKey;
    }

    public String getCumAppId() {
        return cumAppId;
    }

    public void setCumAppId(String cumAppId) {
        this.cumAppId = cumAppId;
    }

    public String getCumTerminal() {
        return cumTerminal;
    }

    public void setCumTerminal(String cumTerminal) {
        this.cumTerminal = cumTerminal;
    }

    public String getChanMchId() {
        return chanMchId;
    }

    public void setChanMchId(String chanMchId) {
        this.chanMchId = chanMchId;
    }

    public String getChanKey() {
        return chanKey;
    }

    public void setChanKey(String chanKey) {
        this.chanKey = chanKey;
    }

    public String getFuIouMchId() {
        return fuIouMchId;
    }

    public void setFuIouMchId(String fuIouMchId) {
        this.fuIouMchId = fuIouMchId;
    }

    public String getFuIouKey() {
        return fuIouKey;
    }

    public void setFuIouKey(String fuIouKey) {
        this.fuIouKey = fuIouKey;
    }

    public String getWsMchId() {
        return wsMchId;
    }

    public void setWsMchId(String wsMchId) {
        this.wsMchId = wsMchId;
    }

    public String getOfficialMchId() {
        return officialMchId;
    }

    public void setOfficialMchId(String officialMchId) {
        this.officialMchId = officialMchId;
    }
}
