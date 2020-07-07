package com.neusoft.bsp.business.mvo.service;

import com.neusoft.bsp.business.po.Manufacturer;
import org.springframework.stereotype.Service;

@Service
public interface ManufacturerService {

    int insert(Manufacturer manufacturer);

    int update(Manufacturer manufacturer);

    int delete(int man_id);

    Manufacturer getById(int man_id);

    int updateUserWithLastManu(int user_id);

    int updateUserWithManuID(int man_id);
}
