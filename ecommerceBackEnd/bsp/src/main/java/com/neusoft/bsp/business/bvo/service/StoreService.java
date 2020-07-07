package com.neusoft.bsp.business.bvo.service;

import com.neusoft.bsp.business.po.Store;

import java.util.List;

public interface StoreService {

    int insert(Store store);

    int update(Store store);

    int delete(int str_id);

    Store getById(int str_id);

    List<Store> getAllByDsrId(int dsr_id);
}
