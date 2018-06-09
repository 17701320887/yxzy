package com.active.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by zb on 2017/7/28.
 */
@Component
@ConfigurationProperties(prefix = "system")
public class SystemConfig {

    private String env;

    /**
     * 论坛前台域名
     */
    private String staticDomain;

    /**
     * 本站点域名
     */
    private String ownerDomain;

    /**
     * 单点登录地址
     */
    private String ssoDomain;

    /**
     * 前端公共部分域名
     */
    private String commonDomain;

    /**
     * 官网接口地址
     */
    private String defaultDomain;

    /**
     * 云信key
     */
    private String smsKey;

    /**
     * 云信秘钥
     */
    private String smsSecret;


    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getSsoDomain() {
        return ssoDomain;
    }

    public void setSsoDomain(String ssoDomain) {
        this.ssoDomain = ssoDomain;
    }

    public String getStaticDomain() {
        return staticDomain;
    }

    public void setStaticDomain(String staticDomain) {
        this.staticDomain = staticDomain;
    }

    public String getOwnerDomain() {
        return ownerDomain;
    }

    public void setOwnerDomain(String ownerDomain) {
        this.ownerDomain = ownerDomain;
    }

    public String getCommonDomain() {
        return commonDomain;
    }

    public void setCommonDomain(String commonDomain) {
        this.commonDomain = commonDomain;
    }

    public String getDefaultDomain() {
        return defaultDomain;
    }

    public void setDefaultDomain(String defaultDomain) {
        this.defaultDomain = defaultDomain;
    }

    public String getSmsKey() {
        return smsKey;
    }

    public void setSmsKey(String smsKey) {
        this.smsKey = smsKey;
    }

    public String getSmsSecret() {
        return smsSecret;
    }

    public void setSmsSecret(String smsSecret) {
        this.smsSecret = smsSecret;
    }
}
