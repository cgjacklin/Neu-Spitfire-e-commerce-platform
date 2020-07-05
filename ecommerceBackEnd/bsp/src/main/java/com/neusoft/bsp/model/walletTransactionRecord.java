package com.neusoft.bsp.model;

import java.math.BigDecimal;
import java.util.Date;

public class walletTransactionRecord {
    private Integer transactionId;

    private Integer buyerId;

    private Integer bankCardId;

    private String transactionNumber;

    private Byte transactionType;

    private String accountName;

    private BigDecimal transactionMoney;

    private BigDecimal commission;

    private BigDecimal discountCommission;

    private Byte transactionMethod;

    private Date completeTime;

    private Byte status;

    private BigDecimal actualMoney;

    private BigDecimal actualCommission;

    private BigDecimal actualDiscountCommission;

    private BigDecimal balance;

    private Integer businessId;

    private Byte financeType;

    private String note;

    private String operatorName;

    private String operatorIp;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private String bankReceiptUrl;

    private BigDecimal exchangeRate;

    private String transactionDesc;

    private BigDecimal foreignExchangeFee;

    private BigDecimal withdrawFee;

    public walletTransactionRecord(Integer transactionId, Integer buyerId, Integer bankCardId, String transactionNumber, Byte transactionType, String accountName, BigDecimal transactionMoney, BigDecimal commission, BigDecimal discountCommission, Byte transactionMethod, Date completeTime, Byte status, BigDecimal actualMoney, BigDecimal actualCommission, BigDecimal actualDiscountCommission, BigDecimal balance, Integer businessId, Byte financeType, String note, String operatorName, String operatorIp, String createBy, Date createTime, String lastUpdateBy, Date lastUpdateTime, String bankReceiptUrl, BigDecimal exchangeRate, String transactionDesc, BigDecimal foreignExchangeFee, BigDecimal withdrawFee) {
        this.transactionId = transactionId;
        this.buyerId = buyerId;
        this.bankCardId = bankCardId;
        this.transactionNumber = transactionNumber;
        this.transactionType = transactionType;
        this.accountName = accountName;
        this.transactionMoney = transactionMoney;
        this.commission = commission;
        this.discountCommission = discountCommission;
        this.transactionMethod = transactionMethod;
        this.completeTime = completeTime;
        this.status = status;
        this.actualMoney = actualMoney;
        this.actualCommission = actualCommission;
        this.actualDiscountCommission = actualDiscountCommission;
        this.balance = balance;
        this.businessId = businessId;
        this.financeType = financeType;
        this.note = note;
        this.operatorName = operatorName;
        this.operatorIp = operatorIp;
        this.createBy = createBy;
        this.createTime = createTime;
        this.lastUpdateBy = lastUpdateBy;
        this.lastUpdateTime = lastUpdateTime;
        this.bankReceiptUrl = bankReceiptUrl;
        this.exchangeRate = exchangeRate;
        this.transactionDesc = transactionDesc;
        this.foreignExchangeFee = foreignExchangeFee;
        this.withdrawFee = withdrawFee;
    }

    public walletTransactionRecord() {
        super();
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getBankCardId() {
        return bankCardId;
    }

    public void setBankCardId(Integer bankCardId) {
        this.bankCardId = bankCardId;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber == null ? null : transactionNumber.trim();
    }

    public Byte getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Byte transactionType) {
        this.transactionType = transactionType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public BigDecimal getTransactionMoney() {
        return transactionMoney;
    }

    public void setTransactionMoney(BigDecimal transactionMoney) {
        this.transactionMoney = transactionMoney;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getDiscountCommission() {
        return discountCommission;
    }

    public void setDiscountCommission(BigDecimal discountCommission) {
        this.discountCommission = discountCommission;
    }

    public Byte getTransactionMethod() {
        return transactionMethod;
    }

    public void setTransactionMethod(Byte transactionMethod) {
        this.transactionMethod = transactionMethod;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public BigDecimal getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(BigDecimal actualMoney) {
        this.actualMoney = actualMoney;
    }

    public BigDecimal getActualCommission() {
        return actualCommission;
    }

    public void setActualCommission(BigDecimal actualCommission) {
        this.actualCommission = actualCommission;
    }

    public BigDecimal getActualDiscountCommission() {
        return actualDiscountCommission;
    }

    public void setActualDiscountCommission(BigDecimal actualDiscountCommission) {
        this.actualDiscountCommission = actualDiscountCommission;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public Byte getFinanceType() {
        return financeType;
    }

    public void setFinanceType(Byte financeType) {
        this.financeType = financeType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public String getOperatorIp() {
        return operatorIp;
    }

    public void setOperatorIp(String operatorIp) {
        this.operatorIp = operatorIp == null ? null : operatorIp.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getBankReceiptUrl() {
        return bankReceiptUrl;
    }

    public void setBankReceiptUrl(String bankReceiptUrl) {
        this.bankReceiptUrl = bankReceiptUrl == null ? null : bankReceiptUrl.trim();
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getTransactionDesc() {
        return transactionDesc;
    }

    public void setTransactionDesc(String transactionDesc) {
        this.transactionDesc = transactionDesc == null ? null : transactionDesc.trim();
    }

    public BigDecimal getForeignExchangeFee() {
        return foreignExchangeFee;
    }

    public void setForeignExchangeFee(BigDecimal foreignExchangeFee) {
        this.foreignExchangeFee = foreignExchangeFee;
    }

    public BigDecimal getWithdrawFee() {
        return withdrawFee;
    }

    public void setWithdrawFee(BigDecimal withdrawFee) {
        this.withdrawFee = withdrawFee;
    }
}