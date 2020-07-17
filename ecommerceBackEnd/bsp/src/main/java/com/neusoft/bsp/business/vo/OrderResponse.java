package com.neusoft.bsp.business.vo;

import com.neusoft.bsp.business.po.Order;
import com.neusoft.bsp.common.base.BaseEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class OrderResponse implements BaseEntity<Integer> {
    String title;
    int or_id;
    int str_id;
    int man_id;
    int pro_id;
    int dsr_id;
    String remark;
    String order_id;
    BigDecimal sales_price;
    int qty;
    String sku_no;
    String receive_name;
    String receive_address;
    String receive_phone;
    String tracking_number;
    String tracking_company;
    String sts_cd;
    String order_created_time;
    Timestamp paid_time;
    Timestamp ship_time;
    Timestamp completed_time;
    Timestamp cancelled_time;
    BigDecimal total;


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getOr_id() {
        return or_id;
    }

    public void setOr_id(int or_id) {
        this.or_id = or_id;
    }

    public int getStr_id() {
        return str_id;
    }

    public void setStr_id(int str_id) {
        this.str_id = str_id;
    }

    public int getMan_id() {
        return man_id;
    }

    public void setMan_id(int man_id) {
        this.man_id = man_id;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public int getDsr_id() {
        return dsr_id;
    }

    public void setDsr_id(int dsr_id) {
        this.dsr_id = dsr_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public BigDecimal getSales_price() {
        return sales_price;
    }

    public void setSales_price(BigDecimal sales_price) {
        this.sales_price = sales_price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getSku_no() {
        return sku_no;
    }

    public void setSku_no(String sku_no) {
        this.sku_no = sku_no;
    }

    public String getReceive_name() {
        return receive_name;
    }

    public void setReceive_name(String receive_name) {
        this.receive_name = receive_name;
    }

    public String getReceive_address() {
        return receive_address;
    }

    public void setReceive_address(String receive_address) {
        this.receive_address = receive_address;
    }

    public String getReceive_phone() {
        return receive_phone;
    }

    public void setReceive_phone(String receive_phone) {
        this.receive_phone = receive_phone;
    }

    public String getTracking_number() {
        return tracking_number;
    }

    public void setTracking_number(String tracking_number) {
        this.tracking_number = tracking_number;
    }

    public String getTracking_company() {
        return tracking_company;
    }

    public void setTracking_company(String tracking_company) {
        this.tracking_company = tracking_company;
    }

    public String getSts_cd() {
        return sts_cd;
    }

    public void setSts_cd(String sts_cd) {
        this.sts_cd = sts_cd;
    }

    public String getOrder_created_time() {
        return order_created_time;
    }

    public void setOrder_created_time(String order_created_time) {
        this.order_created_time = order_created_time;
    }

    public Timestamp getPaid_time() {
        return paid_time;
    }

    public void setPaid_time(Timestamp paid_time) {
        this.paid_time = paid_time;
    }

    public Timestamp getShip_time() {
        return ship_time;
    }

    public void setShip_time(Timestamp ship_time) {
        this.ship_time = ship_time;
    }

    public Timestamp getCompleted_time() {
        return completed_time;
    }

    public void setCompleted_time(Timestamp completed_time) {
        this.completed_time = completed_time;
    }

    public Timestamp getCancelled_time() {
        return cancelled_time;
    }

    public void setCancelled_time(Timestamp cancelled_time) {
        this.cancelled_time = cancelled_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public OrderResponse(Order order, String title){
        this.title = title;
        this.or_id = order.getOr_id();
        this.str_id = order.getStr_id();
        this.man_id = order.getDsr_id();
        this.pro_id = order.getPro_id();
        this.dsr_id = order.getDsr_id();
        this.order_id = order.getOrder_id();
        this.sales_price = order.getSales_price();
        this.qty = order.getQty();
        this.sku_no = order.getSku_no();
        this.receive_name = order.getReceive_name();
        this.receive_address = order.getReceive_address();
        this.receive_phone = order.getReceive_phone();
        this.tracking_number = order.getTracking_number();
        this.tracking_company = order.getTracking_company();
        this.sts_cd = order.getSts_cd();
        this.order_created_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(order.getOrder_created_time());
        this.paid_time = order.getPaid_time();
        this.ship_time = order.getShip_time();
        this.completed_time = order.getCompleted_time();
        this.cancelled_time = order.getCancelled_time();
        this.total = order.getSales_price().multiply(new BigDecimal(order.getQty()));
    }


}
