package com.neusoft.bsp.business.mvo.service;


import com.neusoft.bsp.business.po.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {

    int delete(Integer brd_id);

    int insert(Brand brand);

    List<Brand> getAllById(Integer man_id);

    int update(Brand brand);

    Brand getById(Integer brd_id);
}
