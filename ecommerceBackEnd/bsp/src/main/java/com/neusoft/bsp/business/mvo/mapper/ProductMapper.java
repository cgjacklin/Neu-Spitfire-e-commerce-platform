package com.neusoft.bsp.business.mvo.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.business.po.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductMapper extends BaseMapper<Integer, Product> {
    @Override
    int insert(Product product);

    @Override
    int update(Product product);

    @Override
    int delete(Integer pk);

    @Override
    Product getById(Integer pk);

    @Override
    List<Product> getAll();

    @Override
    List<Product> getAllByFilter(Map<String, Object> map);
}
