package com.neusoft.bsp.user.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.user.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    int insert(User user);

    int update(User user);

    int delete(String userid);

    User getById(String userid);

    List<User> getAll();

    List<User> getAllByFilter(Map<String,Object> map);

    //pagenum pagenow page size
    PageInfo<User> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<User> getAllByFilter(Integer pageNum, Integer pageSize, Map<String,Object> map);

    User getByUserName(String userName);

}
