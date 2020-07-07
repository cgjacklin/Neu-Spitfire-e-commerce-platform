package com.neusoft.bsp.business.bvo.service;

import com.neusoft.bsp.business.po.Dropshipper;
import org.springframework.stereotype.Service;

@Service
public interface DropshipperService {
    int insert(Dropshipper dropshipper);

//    int update(Dropshipper dropshipper);
//
//    int delete(int dsr_id);

    Dropshipper getById(int dsr_id);
}
