package com.neusoft.bsp.mvo.service;

import com.neusoft.bsp.mvo.entity.Manufacturer;

public interface ManufacturerService {

    int insert(Manufacturer manufacturer);

    int update(Manufacturer manufacturer);

    int delete(int man_id);

    Manufacturer getById(int man_id);

    int updateUserWithLastManu(int user_id);

}
