package com.neusoft.bsp.admin.user.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.admin.user.po.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    static String MVODEFAULT = "MVOmyInfo,MVOrecordProduct,MVOproductPicture,MVObillManagement,MVOwallet";

    static String BVODEFAULT = "BVOmyInfo,BVOshopManagement,BVOproductPreview,BVOwishList,BVObillManagement,BVOwallet";

    static String ADMINDEFAULT = "MVOmyInfo,MVOrecordProduct,MVOproductPicture,MVObillManagement,MVOwallet,"+
            "BVOmyInfo,BVOshopManagement,BVOproductPreview,BVOwishList,BVObillManagement,BVOwallet"+
            "dictionaryManagement,parameterManagement,moneySettlement";

    int insert(User user);

    int insertUserAndBvo(User user);

    int update(User user);

    int delete(int userid);

    User getById(int userid);

    void setDefaultRights(User user);

    void setRights(User user, List<String> rights);

    String[] getRights(User user);

    List<User> getAll();

    List<User> getAllByFilter(Map<String,Object> map);

    //pagenum pagenow page size
    PageInfo<User> getAllByFilter(Integer pageNum, Integer pageSize);

    PageInfo<User> getAllByFilter(Integer pageNum, Integer pageSize, Map<String,Object> map);

    User getByUserName(String userName);

    int register(User user);

    User login(User user);

}
