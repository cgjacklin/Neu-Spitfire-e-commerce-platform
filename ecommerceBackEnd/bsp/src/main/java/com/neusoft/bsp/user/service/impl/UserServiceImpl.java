package com.neusoft.bsp.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.mapper.UserMapper;
import com.neusoft.bsp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int delete(String userid) {
        return userMapper.delete(userid);
    }

    @Override
    public User getById(String userid) {
        return userMapper.getById(userid);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public List<User> getAllByFilter(Map<String, Object> map) {
        return userMapper.getAllByFilter(map);
    }

    @Override
    public PageInfo<User> getAllByFilter(Integer pageNum, Integer pageSize) {
        return this.getAllByFilter(pageNum, pageSize, new HashMap<>());
    }

    @Override
    public PageInfo<User> getAllByFilter(Integer pageNum, Integer pageSize, Map<String, Object> map) {
        PageHelper.startPage(pageNum, pageSize,true);
        List<User> users = userMapper.getAllByFilter(map);

        return new PageInfo<>(users);
    }

    @Override
    public User getByUserName(String userName) {
        return userMapper.getByUsername(userName);
    }
}
