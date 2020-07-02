package com.neusoft.bsp.common.base;

import java.util.List;
import java.util.Map;

public interface BaseMapper<S,T> {
    int insert(T t);

    int update(T t);

    int delete(S pk);

    T getById(S pk);

    List<T> getAll();

    List<T> getAllByFilter(Map<String,Object> map);

}
