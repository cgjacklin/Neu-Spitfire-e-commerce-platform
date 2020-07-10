package com.neusoft.bsp.admin.wallet.po;

import com.neusoft.bsp.common.base.BaseEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class WalletTransactionRecord implements BaseEntity<Integer> {

    int transaction_id;
    int buyer_id;
    int bank_card_id;
    String transaction_number;
    int transaction_type;
    String account_name;
    BigDecimal transaction_money ;
    BigDecimal commission;
    BigDecimal discount_commission;
    int transaction_method;
    Timestamp complete_time;
    int status;
    BigDecimal actual_money;
    BigDecimal actual_commission;
    BigDecimal actual_discount_commission;
    BigDecimal balance;
    int business_id;
    int finance_type;
    String note;
    String operator_name;
    String operator_ip;
    String create_by;
    Timestamp create_time;
    String last_update_by;
    Timestamp last_update_time;
    String bank_receipt_url;
    BigDecimal exchange_rate;
    String transaction_desc;
    BigDecimal foreign_exchange_fee;
    BigDecimal withdraw_fee;

    public WalletTransactionRecord() {

    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public int getBank_card_id() {
        return bank_card_id;
    }

    public void setBank_card_id(int bank_card_id) {
        this.bank_card_id = bank_card_id;
    }

    public String getTransaction_number() {
        return transaction_number;
    }

    public void setTransaction_number(String transaction_number) {
        this.transaction_number = transaction_number;
    }

    public int getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(int transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public BigDecimal getTransaction_money() {
        return transaction_money;
    }

    public void setTransaction_money(BigDecimal transaction_money) {
        this.transaction_money = transaction_money;
    }

    public BigDecimal getCommission() {
        return commission;
    }

    public void setCommission(BigDecimal commission) {
        this.commission = commission;
    }

    public BigDecimal getDiscount_commission() {
        return discount_commission;
    }

    public void setDiscount_commission(BigDecimal discount_commission) {
        this.discount_commission = discount_commission;
    }

    public int getTransaction_method() {
        return transaction_method;
    }

    public void setTransaction_method(int transaction_method) {
        this.transaction_method = transaction_method;
    }

    public Timestamp getComplete_time() {
        return complete_time;
    }

    public void setComplete_time(Timestamp complete_time) {
        this.complete_time = complete_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getActual_money() {
        return actual_money;
    }

    public void setActual_money(BigDecimal actual_money) {
        this.actual_money = actual_money;
    }

    public BigDecimal getActual_commission() {
        return actual_commission;
    }

    public void setActual_commission(BigDecimal actual_commission) {
        this.actual_commission = actual_commission;
    }

    public BigDecimal getActual_discount_commission() {
        return actual_discount_commission;
    }

    public void setActual_discount_commission(BigDecimal actual_discount_commission) {
        this.actual_discount_commission = actual_discount_commission;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }

    public int getFinance_type() {
        return finance_type;
    }

    public void setFinance_type(int finance_type) {
        this.finance_type = finance_type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getOperator_name() {
        return operator_name;
    }

    public void setOperator_name(String operator_name) {
        this.operator_name = operator_name;
    }

    public String getOperator_ip() {
        return operator_ip;
    }

    public void setOperator_ip(String operator_ip) {
        this.operator_ip = operator_ip;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public String getLast_update_by() {
        return last_update_by;
    }

    public void setLast_update_by(String last_update_by) {
        this.last_update_by = last_update_by;
    }

    public Timestamp getLast_update_time() {
        return last_update_time;
    }

    public void setLast_update_time(Timestamp last_update_time) {
        this.last_update_time = last_update_time;
    }

    public String getBank_receipt_url() {
        return bank_receipt_url;
    }

    public void setBank_receipt_url(String bank_receipt_url) {
        this.bank_receipt_url = bank_receipt_url;
    }

    public BigDecimal getExchange_rate() {
        return exchange_rate;
    }

    public void setExchange_rate(BigDecimal exchange_rate) {
        this.exchange_rate = exchange_rate;
    }

    public String getTransaction_desc() {
        return transaction_desc;
    }

    public void setTransaction_desc(String transaction_desc) {
        this.transaction_desc = transaction_desc;
    }

    public BigDecimal getForeign_exchange_fee() {
        return foreign_exchange_fee;
    }

    public void setForeign_exchange_fee(BigDecimal foreign_exchange_fee) {
        this.foreign_exchange_fee = foreign_exchange_fee;
    }

    public BigDecimal getWithdraw_fee() {
        return withdraw_fee;
    }

    public void setWithdraw_fee(BigDecimal withdraw_fee) {
        this.withdraw_fee = withdraw_fee;
    }

    public WalletTransactionRecord(int transaction_id, int buyer_id, int bank_card_id, String transaction_number, int transaction_type, String account_name, BigDecimal transaction_money, BigDecimal commission, BigDecimal discount_commission, int transaction_method, Timestamp complete_time, int status, BigDecimal actual_money, BigDecimal actual_commission, BigDecimal actual_discount_commission, BigDecimal balance, int business_id, int finance_type, String note, String operator_name, String operator_ip, String create_by, Timestamp create_time, String last_update_by, Timestamp last_update_time, String bank_receipt_url, BigDecimal exchange_rate, String transaction_desc, BigDecimal foreign_exchange_fee, BigDecimal withdraw_fee) {
        this.transaction_id = transaction_id;
        this.buyer_id = buyer_id;
        this.bank_card_id = bank_card_id;
        this.transaction_number = transaction_number;
        this.transaction_type = transaction_type;
        this.account_name = account_name;
        this.transaction_money = transaction_money;
        this.commission = commission;
        this.discount_commission = discount_commission;
        this.transaction_method = transaction_method;
        this.complete_time = complete_time;
        this.status = status;
        this.actual_money = actual_money;
        this.actual_commission = actual_commission;
        this.actual_discount_commission = actual_discount_commission;
        this.balance = balance;
        this.business_id = business_id;
        this.finance_type = finance_type;
        this.note = note;
        this.operator_name = operator_name;
        this.operator_ip = operator_ip;
        this.create_by = create_by;
        this.create_time = create_time;
        this.last_update_by = last_update_by;
        this.last_update_time = last_update_time;
        this.bank_receipt_url = bank_receipt_url;
        this.exchange_rate = exchange_rate;
        this.transaction_desc = transaction_desc;
        this.foreign_exchange_fee = foreign_exchange_fee;
        this.withdraw_fee = withdraw_fee;


    }
}
