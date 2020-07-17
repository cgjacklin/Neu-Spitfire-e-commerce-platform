package com.neusoft.bsp.business.vo;

import com.neusoft.bsp.business.po.Product;
import com.neusoft.bsp.common.base.BaseEntity;

import java.math.BigDecimal;
import java.sql.Date;

public class ProductVO implements BaseEntity<Integer> {
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
    //额外参数
    int user_id;
    //体积体重表
    BigDecimal width;
    BigDecimal height;
    BigDecimal length;
    BigDecimal weight;
    //商品描述表
    String description;
    //商品分类表
    String platform_type;
    //前端参数
    String ebay_description;
    String amazon_description;
    //品牌表
    String name_en;
    int star;


//    @Override
//    public Integer getId() {
//        return null;
//    }
    public ProductVO(){}


    public ProductVO(int pro_id, String sku_cd, int brd_id, int man_id, String title, String upc, String ean, String model, String warranty_day, BigDecimal retail_price, String created_by, Date creation_date, String last_update_by, Date last_update_date, String remark, String sts_cd, BigDecimal mininum_retail_price, int replenishment_period, String key_words, String warranty, String time_unit, int stockseting, int call_cnt, int user_id, BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal weight, String description, String platform_type, String ebay_description, String amazon_description, String name_en, int star) {
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
        this.user_id = user_id;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.description = description;
        this.platform_type = platform_type;
        this.ebay_description = ebay_description;
        this.amazon_description = amazon_description;
        this.name_en = name_en;
        this.star = star;
    }

    public ProductVO(int pro_id, String sku_cd, int brd_id, int man_id, String title, String upc, String ean, String model, String warranty_day, BigDecimal retail_price, String created_by, Date creation_date, String last_update_by, Date last_update_date, String remark, String sts_cd, BigDecimal mininum_retail_price, int replenishment_period, String key_words, String warranty, String time_unit, int stockseting, int call_cnt, int user_id, BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal weight, String description, String platform_type, String ebay_description, String amazon_description, String name_en) {
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
        this.user_id = user_id;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.description = description;
        this.platform_type = platform_type;
        this.ebay_description = ebay_description;
        this.amazon_description = amazon_description;
        this.name_en = name_en;
    }

    public ProductVO(Product product){
        this.pro_id = product.getPro_id();
        this.sku_cd = product.getSku_cd();
        this.brd_id = product.getBrd_id();
        this.man_id = product.getMan_id();
        this.title = product.getTitle();
        this.upc = product.getUpc();
        this.ean = product.getEan();
        this.model = product.getModel();
        this.warranty_day = product.getWarranty_day();
        this.retail_price = product.getRetail_price();
        this.created_by = product.getCreated_by();
        this.creation_date = product.getCreation_date();
        this.last_update_by = product.getLast_update_by();
        this.last_update_date = product.getLast_update_date();
        this.remark = product.getRemark();
        this.sts_cd = product.getSts_cd();
        this.mininum_retail_price = product.getMininum_retail_price();
        this.replenishment_period = product.getReplenishment_period();
        this.key_words = product.getKey_words();
        this.warranty = product.getWarranty();
        this.time_unit = product.getTime_unit();
        this.stockseting = product.getStockseting();
        this.call_cnt = product.getCall_cnt();
    }

    @Override
    public String toString() {
        return "ProductVO{" +
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
                ", user_id=" + user_id +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                ", weight=" + weight +
                ", description='" + description + '\'' +
                ", platform_type='" + platform_type + '\'' +
                ", ebay_description='" + ebay_description + '\'' +
                ", amazon_description='" + amazon_description + '\'' +
                ", name_en='" + name_en + '\'' +
                ", star=" + star +
                '}';
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getName_en() {
        return name_en;
    }

    public void setName_en(String name_en) {
        this.name_en = name_en;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlatform_type() {
        return platform_type;
    }

    public void setPlatform_type(String platform_type) {
        this.platform_type = platform_type;
    }

    public String getEbay_description() {
        return ebay_description;
    }

    public void setEbay_description(String ebay_description) {
        this.ebay_description = ebay_description;
    }

    public String getAmazon_description() {
        return amazon_description;
    }

    public void setAmazon_description(String amazon_description) {
        this.amazon_description = amazon_description;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
