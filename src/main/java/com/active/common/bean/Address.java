package com.active.common.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by chenqi on 2016/10/20.
 */
public class Address extends BaseEntity {

    /**
     * 国家
     */
    private String country;

    /**
     * 国家代码
     */
    @JSONField(name = "country_id")
    @JsonProperty("country_id")
    private String countryId;//CN

    /**
     * 区域
     */
    private String area;

    /**
     * 区域代码
     */
    @JSONField(name = "area_id")
    @JsonProperty("area_id")
    private Integer areaId;

    /**
     * 省份
     */
    private String region;

    /**
     * 省份代码
     */
    @JSONField(name = "region_id")
    @JsonProperty("region_id")
    private Integer regionId;

    /**
     * 城市
     */
    private String city;

    /**
     * 城市代码
     */
    @JSONField(name = "city_id")
    @JsonProperty("city_id")
    private Integer cityId;

    private String county;

    @JSONField(name = "county_id")
    @JsonProperty("county_id")
    private Integer countyId;

    private String isp;

    @JSONField(name = "isp_id")
    @JsonProperty("isp_id")
    private Integer ispId;

    /**
     * ip
     */
    private String ip;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public Integer getIspId() {
        return ispId;
    }

    public void setIspId(Integer ispId) {
        this.ispId = ispId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddress(){
        StringBuffer sb = new StringBuffer();
        if(this.country != null){
            sb.append(this.country);
        }
        if(this.region != null){
            sb.append(this.region);
        }
        if(this.city != null){
            sb.append(this.city);
        }
        return sb.toString();
    }

}
