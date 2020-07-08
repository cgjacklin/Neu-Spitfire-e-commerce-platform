package com.neusoft.bsp.admin.parameter.service;

import com.github.pagehelper.PageInfo;
import com.neusoft.bsp.admin.parameter.mapper.ParameterMapper;
import com.neusoft.bsp.admin.parameter.po.Parameter;
import com.neusoft.bsp.admin.user.po.User;
import com.neusoft.bsp.business.vo.ParameterVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface ParameterService{
    int insert(Parameter parameter);

    int update(Parameter parameter);

    int delete(int id);

    Parameter getById(int id);

    List<Parameter> getAll();

    List<Parameter> getAllByFilter(Map<String,Object> map);

    int addParameter(ParameterVO parameterVO);

    int updateParameter(ParameterVO parameterVO);

    int deleteParameter(ParameterVO parameterVO);

//    List<ParameterVO> getParameters();
}
