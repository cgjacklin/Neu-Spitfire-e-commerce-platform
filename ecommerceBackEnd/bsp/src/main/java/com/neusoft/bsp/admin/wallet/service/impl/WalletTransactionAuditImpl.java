package com.neusoft.bsp.admin.wallet.service.impl;

import com.neusoft.bsp.admin.wallet.mapper.WalletTransactionAuditMapper;

import com.neusoft.bsp.admin.wallet.po.WalletTransactionAudit;
import com.neusoft.bsp.admin.wallet.service.WalletTransactionAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("WalletTransactionAduitService")
public class WalletTransactionAuditImpl implements WalletTransactionAuditService {
    @Autowired
    WalletTransactionAuditMapper walletTransactionAuditMapper;

    @Override
    public int insert(WalletTransactionAudit walletTransactionAudit) {
        return walletTransactionAuditMapper.insert(walletTransactionAudit);
    }

    @Override
    public int update(WalletTransactionAudit walletTransactionAudit) {
        return walletTransactionAuditMapper.update(walletTransactionAudit);
    }

    @Override
    public int delete(int transaction_audit_id) {
        return walletTransactionAuditMapper.delete(transaction_audit_id);
    }

    @Override
    public WalletTransactionAudit getById(int transaction_audit_id) {
        return walletTransactionAuditMapper.getById(transaction_audit_id);
    }

    @Override
    public List<WalletTransactionAudit> getAll() {
        return walletTransactionAuditMapper.getAll();
    }

    @Override
    public List<WalletTransactionAudit> getAllById(Integer buyer_id) {
        return walletTransactionAuditMapper.getAllById(buyer_id);
    }
}
