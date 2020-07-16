package com.neusoft.bsp.controller;

import com.neusoft.bsp.admin.parameter.po.Parameter;
import com.neusoft.bsp.admin.parameter.service.ParameterService;
import com.neusoft.bsp.business.vo.ParameterVO;
import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/parameter")
public class ParameterController extends BaseController {
    @Autowired
    ParameterService parameterService;

    @PostMapping("/getParameters")
    public BaseModelJson<List<Parameter>> getParameter(){
        BaseModelJson<List<Parameter>> response = new BaseModelJson<>();
        List<Parameter> result = parameterService.getAll();
//        System.out.println(result);
//        System.out.println(parameterService.getAll());
        if(result!=null && result.size()!=0){
            response.setSuccess();
            response.setData(result);
        }else{
            throw BusinessException.NO_PARAMETER;
        }
        return response;
    }

    @PostMapping("/addParameter")
    public BaseModel addParameter(@RequestBody ParameterVO parameter){
        BaseModel response = new BaseModel();
        if(parameterService.addParameter(parameter)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }

    @PostMapping("/updateParameter")
    public BaseModel updateParameter(@RequestBody ParameterVO parameter){
        BaseModel response = new BaseModel();
        if(parameterService.updateParameter(parameter)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }

    @PostMapping("/deleteParameter")
    public BaseModel deleteParameter(@RequestBody ParameterVO parameter){
        BaseModel response = new BaseModel();
        if(parameterService.deleteParameter(parameter)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }
}
