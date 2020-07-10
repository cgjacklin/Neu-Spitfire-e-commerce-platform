package com.neusoft.bsp.admin.wallet.mapper;
import com.neusoft.bsp.admin.wallet.po.WalletAccountFund;
import com.neusoft.bsp.common.base.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletAccountFundMapper  extends BaseMapper<Integer, WalletAccountFund> {
    List<WalletAccountFund> getAllById(Integer buyer_id);
}
