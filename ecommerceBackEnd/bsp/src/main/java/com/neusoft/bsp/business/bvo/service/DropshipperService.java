package com.neusoft.bsp.business.bvo.service;

import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.business.po.Dropshipper;
import org.springframework.stereotype.Service;

@Service
public interface DropshipperService {
    int insert(Dropshipper store);

    int update(Dropshipper store);

    int delete(int str_id);

    Dropshipper getById(int str_id);

    int addDropshipper(User user);
}
