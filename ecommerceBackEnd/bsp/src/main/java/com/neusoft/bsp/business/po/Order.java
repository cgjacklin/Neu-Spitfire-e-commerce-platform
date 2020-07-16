package com.neusoft.bsp.business.po;

import com.neusoft.bsp.common.base.BaseEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Order implements BaseEntity<Integer> {
    int or_id;
    int str_id;
    int man_id;
    int pro_id;
    int dsr_id;
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
    Timestamp order_created_time;
    Timestamp paid_time;
    Timestamp ship_time;
    Timestamp completed_time;
    Timestamp cancelled_time;

    public Order(){}

    public Order(int or_id, String tracking_company){
        this.or_id = or_id;
        this.tracking_company = tracking_company;
    }

    public Order(int or_id, int str_id, int man_id, int pro_id, int dsr_id, String order_id, BigDecimal sales_price, int qty, String sku_no, String receive_name, String receive_address, String receive_phone, String tracking_number, String tracking_company, String sts_cd, Timestamp order_created_time, Timestamp paid_time, Timestamp ship_time, Timestamp completed_time, Timestamp cancelled_time) {
        this.or_id = or_id;
        this.str_id = str_id;
        this.man_id = man_id;
        this.pro_id = pro_id;
        this.dsr_id = dsr_id;
        this.order_id = order_id;
        this.sales_price = sales_price;
        this.qty = qty;
        this.sku_no = sku_no;
        this.receive_name = receive_name;
        this.receive_address = receive_address;
        this.receive_phone = receive_phone;
        this.tracking_number = tracking_number;
        this.tracking_company = tracking_company;
        this.sts_cd = sts_cd;
        this.order_created_time = order_created_time;
        this.paid_time = paid_time;
        this.ship_time = ship_time;
        this.completed_time = completed_time;
        this.cancelled_time = cancelled_time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "or_id=" + or_id +
                ", str_id=" + str_id +
                ", man_id=" + man_id +
                ", pro_id=" + pro_id +
                ", dsr_id=" + dsr_id +
                ", order_id='" + order_id + '\'' +
                ", sales_price=" + sales_price +
                ", qty=" + qty +
                ", sku_no='" + sku_no + '\'' +
                ", receive_name='" + receive_name + '\'' +
                ", receive_address='" + receive_address + '\'' +
                ", receive_phone='" + receive_phone + '\'' +
                ", tracking_number='" + tracking_number + '\'' +
                ", tracking_company='" + tracking_company + '\'' +
                ", sts_cd='" + sts_cd + '\'' +
                ", order_created_time=" + order_created_time +
                ", paid_time=" + paid_time +
                ", ship_time=" + ship_time +
                ", completed_time=" + completed_time +
                ", cancelled_time=" + cancelled_time +
                '}';
    }

    public int getDsr_id() {
        return dsr_id;
    }

    public void setDsr_id(int dsr_id) {
        this.dsr_id = dsr_id;
    }

    public String getTracking_company() {
        return tracking_company;
    }

    public void setTracking_company(String tracking_company) {
        this.tracking_company = tracking_company;
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

    public String getSts_cd() {
        return sts_cd;
    }

    public void setSts_cd(String sts_cd) {
        this.sts_cd = sts_cd;
    }

    public Timestamp getOrder_created_time() {
        return order_created_time;
    }

    public void setOrder_created_time(Timestamp order_created_time) {
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
}
