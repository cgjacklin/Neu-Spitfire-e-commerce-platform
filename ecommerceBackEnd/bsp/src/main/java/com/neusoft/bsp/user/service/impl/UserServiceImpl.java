package com.neusoft.bsp.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.common.exception.BusinessException;
import com.neusoft.bsp.common.security.service.AuthService;
import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.mapper.UserMapper;
import com.neusoft.bsp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
//
//    @Autowired
//    AuthService authService;

    @Override
    public int insert(User user) {
        setDefaultRights(user);
        return userMapper.insert(user);
    }

    @Override
    public int register(User user) {
        User checkName = getByUserName(user.getUsername());
        if(checkName!=null){
            throw BusinessException.DUPLICATE_USERNAME;
        }
        return insert(user);
    }

    @Override
    public int login(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("username", user.getUsername());
        map.put("password", user.getPassword());
        User checkName = getByUserName(user.getUsername());
        if(checkName==null){
            throw BusinessException.USERNAME_NOT_EXISTS;
        }
        List<User> users = getAllByFilter(map);
        if (users.size() == 0) {
            throw BusinessException.PASSWORD_WRONG;
        } else {
            return 1;
        }
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int delete(int userid) {
        return userMapper.delete(userid);
    }

    @Override
    public User getById(int userid) {
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

    @Override
    public void setDefaultRights(User user) {
        if(user.getRole_id().equals("mvo")){
            user.setRights(MVODEFAULT);
        }
        else if(user.getRole_id().equals("bvo")){
            user.setRights(BVODEFAULT);
        }
    }

    @Override
    public void setRights(User user, List<String> rights) {
        StringBuffer newRights = new StringBuffer("");
        for(String right:rights){
            newRights.append(right+",");
        }
        newRights.deleteCharAt(newRights.length()-1);
        user.setRights(newRights.toString());
        update(user);
    }

    @Override
    public String[] getRights(User user) {
        String[] rights = user.getRights().split(",");
        return rights;
    }
}
