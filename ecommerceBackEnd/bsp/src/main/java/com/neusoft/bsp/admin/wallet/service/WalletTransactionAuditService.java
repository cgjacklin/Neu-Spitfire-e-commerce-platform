package com.neusoft.bsp.admin.wallet.service;

import com.neusoft.bsp.admin.wallet.po.WalletTransactionAudit;

import java.util.List;

public interface WalletTransactionAuditService {
    int insert(WalletTransactionAudit walletTransactionAudit);

    int update(WalletTransactionAudit walletTransactionAudit);

    int delete(int transaction_audit_id);

    WalletTransactionAudit getById(int transaction_audit_id);

    List<WalletTransactionAudit> getAll();

    List<WalletTransactionAudit> getAllById(Integer buyer_id);
}
