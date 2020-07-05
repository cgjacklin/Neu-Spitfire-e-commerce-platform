package com.neusoft.bsp.model;

import java.math.BigDecimal;
import java.util.Date;

public class salesrder {
    private Integer saoId;

    private String createdBy;

    private Date creationDate;

    private String lastUpdateBy;

    private Date lastUpdateDate;

    private Integer callCnt;

    private String remark;

    private String stsCd;

    private Integer manId;

    private Integer warId;

    private Date syncDate;

    private Date paymentDate;

    private Date pushDate;

    private Date trackNoDate;

    private Date fulfillmentDate;

    private Date settlementDate;

    private BigDecimal productAmount;

    private BigDecimal freightCost;

    private BigDecimal handlingFee;

    private String customerRemark;

    private String orderNo;

    private String orderSts;

    private String refundSts;

    private String deliverySts;

    private Integer stoId;

    private BigDecimal lastFreightCost;

    private Date cancleTime;

    private String autoPayStatus;

    private String autoPayTime;

    private String buyerCheckoutMessage;

    public salesrder(Integer saoId, String createdBy, Date creationDate, String lastUpdateBy, Date lastUpdateDate, Integer callCnt, String remark, String stsCd, Integer manId, Integer warId, Date syncDate, Date paymentDate, Date pushDate, Date trackNoDate, Date fulfillmentDate, Date settlementDate, BigDecimal productAmount, BigDecimal freightCost, BigDecimal handlingFee, String customerRemark, String orderNo, String orderSts, String refundSts, String deliverySts, Integer stoId, BigDecimal lastFreightCost, Date cancleTime, String autoPayStatus, String autoPayTime, String buyerCheckoutMessage) {
        this.saoId = saoId;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateDate = lastUpdateDate;
        this.callCnt = callCnt;
        this.remark = remark;
        this.stsCd = stsCd;
        this.manId = manId;
        this.warId = warId;
        this.syncDate = syncDate;
        this.paymentDate = paymentDate;
        this.pushDate = pushDate;
        this.trackNoDate = trackNoDate;
        this.fulfillmentDate = fulfillmentDate;
        this.settlementDate = settlementDate;
        this.productAmount = productAmount;
        this.freightCost = freightCost;
        this.handlingFee = handlingFee;
        this.customerRemark = customerRemark;
        this.orderNo = orderNo;
        this.orderSts = orderSts;
        this.refundSts = refundSts;
        this.deliverySts = deliverySts;
        this.stoId = stoId;
        this.lastFreightCost = lastFreightCost;
        this.cancleTime = cancleTime;
        this.autoPayStatus = autoPayStatus;
        this.autoPayTime = autoPayTime;
        this.buyerCheckoutMessage = buyerCheckoutMessage;
    }

    public salesrder() {
        super();
    }

    public Integer getSaoId() {
        return saoId;
    }

    public void setSaoId(Integer saoId) {
        this.saoId = saoId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getCallCnt() {
        return callCnt;
    }

    public void setCallCnt(Integer callCnt) {
        this.callCnt = callCnt;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStsCd() {
        return stsCd;
    }

    public void setStsCd(String stsCd) {
        this.stsCd = stsCd == null ? null : stsCd.trim();
    }

    public Integer getManId() {
        return manId;
    }

    public void setManId(Integer manId) {
        this.manId = manId;
    }

    public Integer getWarId() {
        return warId;
    }

    public void setWarId(Integer warId) {
        this.warId = warId;
    }

    public Date getSyncDate() {
        return syncDate;
    }

    public void setSyncDate(Date syncDate) {
        this.syncDate = syncDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Date getPushDate() {
        return pushDate;
    }

    public void setPushDate(Date pushDate) {
        this.pushDate = pushDate;
    }

    public Date getTrackNoDate() {
        return trackNoDate;
    }

    public void setTrackNoDate(Date trackNoDate) {
        this.trackNoDate = trackNoDate;
    }

    public Date getFulfillmentDate() {
        return fulfillmentDate;
    }

    public void setFulfillmentDate(Date fulfillmentDate) {
        this.fulfillmentDate = fulfillmentDate;
    }

    public Date getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(Date settlementDate) {
        this.settlementDate = settlementDate;
    }

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    public BigDecimal getFreightCost() {
        return freightCost;
    }

    public void setFreightCost(BigDecimal freightCost) {
        this.freightCost = freightCost;
    }

    public BigDecimal getHandlingFee() {
        return handlingFee;
    }

    public void setHandlingFee(BigDecimal handlingFee) {
        this.handlingFee = handlingFee;
    }

    public String getCustomerRemark() {
        return customerRemark;
    }

    public void setCustomerRemark(String customerRemark) {
        this.customerRemark = customerRemark == null ? null : customerRemark.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getOrderSts() {
        return orderSts;
    }

    public void setOrderSts(String orderSts) {
        this.orderSts = orderSts == null ? null : orderSts.trim();
    }

    public String getRefundSts() {
        return refundSts;
    }

    public void setRefundSts(String refundSts) {
        this.refundSts = refundSts == null ? null : refundSts.trim();
    }

    public String getDeliverySts() {
        return deliverySts;
    }

    public void setDeliverySts(String deliverySts) {
        this.deliverySts = deliverySts == null ? null : deliverySts.trim();
    }

    public Integer getStoId() {
        return stoId;
    }

    public void setStoId(Integer stoId) {
        this.stoId = stoId;
    }

    public BigDecimal getLastFreightCost() {
        return lastFreightCost;
    }

    public void setLastFreightCost(BigDecimal lastFreightCost) {
        this.lastFreightCost = lastFreightCost;
    }

    public Date getCancleTime() {
        return cancleTime;
    }

    public void setCancleTime(Date cancleTime) {
        this.cancleTime = cancleTime;
    }

    public String getAutoPayStatus() {
        return autoPayStatus;
    }

    public void setAutoPayStatus(String autoPayStatus) {
        this.autoPayStatus = autoPayStatus == null ? null : autoPayStatus.trim();
    }

    public String getAutoPayTime() {
        return autoPayTime;
    }

    public void setAutoPayTime(String autoPayTime) {
        this.autoPayTime = autoPayTime == null ? null : autoPayTime.trim();
    }

    public String getBuyerCheckoutMessage() {
        return buyerCheckoutMessage;
    }

    public void setBuyerCheckoutMessage(String buyerCheckoutMessage) {
        this.buyerCheckoutMessage = buyerCheckoutMessage == null ? null : buyerCheckoutMessage.trim();
    }
}