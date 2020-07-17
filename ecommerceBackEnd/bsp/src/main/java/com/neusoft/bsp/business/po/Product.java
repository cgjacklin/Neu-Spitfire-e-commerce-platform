package com.neusoft.bsp.business.po;

import com.neusoft.bsp.business.vo.ProductVO;
import com.neusoft.bsp.common.base.BaseEntity;

import java.math.BigDecimal;
import java.sql.Date;

public class Product implements BaseEntity<Integer> {
    int pro_id;
    String sku_cd;
    int brd_id;
    int man_id;
    String title;
    String upc;
    String ean;
    String model;
    String warranty_day;
    BigDecimal retail_price;
    String created_by;
    Date creation_date;
    String last_update_by;
    Date last_update_date;
    String remark;
    String sts_cd;
    BigDecimal mininum_retail_price;
    int replenishment_period;
    String key_words;
    String warranty;
    String time_unit;
    int stockseting;
    int call_cnt;

//    @Override
//    public Integer getId() {
//        return null;
//    }


    @Override
    public String toString() {
        return "Product{" +
                "pro_id=" + pro_id +
                ", sku_cd='" + sku_cd + '\'' +
                ", brd_id=" + brd_id +
                ", man_id=" + man_id +
                ", title='" + title + '\'' +
                ", upc='" + upc + '\'' +
                ", ean='" + ean + '\'' +
                ", model='" + model + '\'' +
                ", warranty_day='" + warranty_day + '\'' +
                ", retail_price=" + retail_price +
                ", created_by='" + created_by + '\'' +
                ", creation_date=" + creation_date +
                ", last_update_by='" + last_update_by + '\'' +
                ", last_update_date=" + last_update_date +
                ", remark='" + remark + '\'' +
                ", sts_cd='" + sts_cd + '\'' +
                ", mininum_retail_price=" + mininum_retail_price +
                ", replenishment_period=" + replenishment_period +
                ", key_words='" + key_words + '\'' +
                ", warranty='" + warranty + '\'' +
                ", time_unit='" + time_unit + '\'' +
                ", stockseting=" + stockseting +
                ", call_cnt=" + call_cnt +
                '}';
    }

    public Product(){

    }

    public Product(int pro_id, String sku_cd, int brd_id, int man_id, String title, String upc, String ean, String model, String warranty_day, BigDecimal retail_price, String created_by, Date creation_date, String last_update_by, Date last_update_date, String remark, String sts_cd, BigDecimal mininum_retail_price, int replenishment_period, String key_words, String warranty, String time_unit, int stockseting, int call_cnt) {
        this.pro_id = pro_id;
        this.sku_cd = sku_cd;
        this.brd_id = brd_id;
        this.man_id = man_id;
        this.title = title;
        this.upc = upc;
        this.ean = ean;
        this.model = model;
        this.warranty_day = warranty_day;
        this.retail_price = retail_price;
        this.created_by = created_by;
        this.creation_date = creation_date;
        this.last_update_by = last_update_by;
        this.last_update_date = last_update_date;
        this.remark = remark;
        this.sts_cd = sts_cd;
        this.mininum_retail_price = mininum_retail_price;
        this.replenishment_period = replenishment_period;
        this.key_words = key_words;
        this.warranty = warranty;
        this.time_unit = time_unit;
        this.stockseting = stockseting;
        this.call_cnt = call_cnt;
    }

    public Product(ProductVO productVO) {
        this.title = productVO.getTitle();
        this.pro_id = productVO.getPro_id();
        this.sku_cd = productVO.getSku_cd();
        this.brd_id = productVO.getBrd_id();
        this.man_id = productVO.getMan_id();
        this.title = productVO.getTitle();
        this.upc = productVO.getUpc();
        this.ean = productVO.getEan();
        this.model = productVO.getModel();
        this.warranty_day = productVO.getWarranty_day();
        this.retail_price = productVO.getRetail_price();
        this.created_by = productVO.getCreated_by();
        this.creation_date = productVO.getCreation_date();
        this.last_update_by = productVO.getLast_update_by();
        this.last_update_date = productVO.getLast_update_date();
        this.remark = productVO.getRemark();
        this.sts_cd = productVO.getSts_cd();
        this.mininum_retail_price = productVO.getMininum_retail_price();
        this.replenishment_period = productVO.getReplenishment_period();
        this.key_words = productVO.getKey_words();
        this.warranty = productVO.getWarranty();
        this.time_unit = productVO.getTime_unit();
        this.stockseting = productVO.getStockseting();
        this.call_cnt = productVO.getCall_cnt();
    }

    public int getCall_cnt() {
        return call_cnt;
    }

    public void setCall_cnt(int call_cnt) {
        this.call_cnt = call_cnt;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getSku_cd() {
        return sku_cd;
    }

    public void setSku_cd(String sku_cd) {
        this.sku_cd = sku_cd;
    }

    public int getBrd_id() {
        return brd_id;
    }

    public void setBrd_id(int brd_id) {
        this.brd_id = brd_id;
    }

    public int getMan_id() {
        return man_id;
    }

    public void setMan_id(int man_id) {
        this.man_id = man_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getWarranty_day() {
        return warranty_day;
    }

    public void setWarranty_day(String warranty_day) {
        this.warranty_day = warranty_day;
    }



    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public String getLast_update_by() {
        return last_update_by;
    }

    public void setLast_update_by(String last_update_by) {
        this.last_update_by = last_update_by;
    }

    public Date getLast_update_date() {
        return last_update_date;
    }

    public void setLast_update_date(Date last_update_date) {
        this.last_update_date = last_update_date;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSts_cd() {
        return sts_cd;
    }

    public void setSts_cd(String sts_cd) {
        this.sts_cd = sts_cd;
    }

    public BigDecimal getRetail_price() {
        return retail_price;
    }

    public void setRetail_price(BigDecimal retail_price) {
        this.retail_price = retail_price;
    }

    public BigDecimal getMininum_retail_price() {
        return mininum_retail_price;
    }

    public void setMininum_retail_price(BigDecimal mininum_retail_price) {
        this.mininum_retail_price = mininum_retail_price;
    }

    public int getReplenishment_period() {
        return replenishment_period;
    }

    public void setReplenishment_period(int replenishment_period) {
        this.replenishment_period = replenishment_period;
    }

    public String getKey_words() {
        return key_words;
    }

    public void setKey_words(String key_words) {
        this.key_words = key_words;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getTime_unit() {
        return time_unit;
    }

    public void setTime_unit(String time_unit) {
        this.time_unit = time_unit;
    }

    public int getStockseting() {
        return stockseting;
    }

    public void setStockseting(int stockseting) {
        this.stockseting = stockseting;
    }
}
