package com.neusoft.bsp.bvo.service;

import com.neusoft.bsp.bvo.entity.Manufacturer;
import com.neusoft.bsp.user.entity.User;

public interface ManufacturerService {

    int insert(Manufacturer manufacturer);

    int update(Manufacturer manufacturer);

    int delete(int man_id);

    Manufacturer getById(int man_id);

    int updateUserWithLastManu(int user_id);

}
