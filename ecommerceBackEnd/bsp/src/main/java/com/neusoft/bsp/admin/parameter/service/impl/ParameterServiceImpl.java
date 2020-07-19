package com.neusoft.bsp.admin.parameter.service.impl;

import com.neusoft.bsp.admin.parameter.mapper.ParameterMapper;
import com.neusoft.bsp.admin.parameter.po.Parameter;
import com.neusoft.bsp.admin.parameter.service.ParameterService;
import com.neusoft.bsp.admin.user.mapper.UserMapper;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.business.vo.ParameterVO;
import com.neusoft.bsp.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ParameterService")
public class ParameterServiceImpl implements ParameterService {
    @Autowired
    ParameterMapper parameterMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public int insert(Parameter parameter) {
        return parameterMapper.insert(parameter);
    }

    @Override
    public int update(Parameter parameter) {
        return parameterMapper.update(parameter);
    }

    @Override
    public int delete(int id) {
        return parameterMapper.delete(id);
    }

    @Override
    public Parameter getById(int id) {
        return parameterMapper.getById(id);
    }

    @Override
    public List<Parameter> getAll() {
        return parameterMapper.getAll();
    }

    @Override
    public List<Parameter> getAllByFilter(Map<String, Object> map) {
        return parameterMapper.getAllByFilter(map);
    }

    @Override
    public int addParameter(ParameterVO parameterVO) {
        Parameter parameter = new Parameter(parameterVO);
        User user = userMapper.getById(parameterVO.getUser_id());
        HashMap<String, Object> para = new HashMap<>();
        para.put("param_cd", parameter.getParam_cd());
        List<Parameter> checkExist = parameterMapper.getAllByFilter(para);
        if(checkExist.size()!=0){
            throw BusinessException.DUPLICATE_PARAM_CD;
        }

        long time = System.currentTimeMillis();
        Date date = new java.sql.Date(time);
        parameter.setCreation_date(date);
        parameter.setCreated_by(user.getUsername());
        parameter.setLast_update_by(user.getUsername());
        parameter.setLast_update_date(date);
        return parameterMapper.insert(parameter);
    }

    @Override
    public int updateParameter(ParameterVO parameterVO) {
        Parameter parameter = new Parameter(parameterVO);
        User user = userMapper.getById(parameterVO.getUser_id());
        HashMap<String, Object> para = new HashMap<>();
        para.put("param_cd", parameter.getParam_cd());
        List<Parameter> checkExist = parameterMapper.getAllByFilter(para);

        long time = System.currentTimeMillis();
        Date date = new java.sql.Date(time);
        parameter.setLast_update_by(user.getUsername());
        parameter.setLast_update_date(date);
        return parameterMapper.update(parameter);
    }

    @Override
    public int deleteParameter(ParameterVO parameterVO) {
        return delete(parameterVO.getPar_id());
    }

//    @Override
//    public List<Parameter> getParameters() {
//        return getAll();
//    }
}
