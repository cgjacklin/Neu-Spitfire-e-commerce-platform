package com.neusoft.bsp.controller;

import com.neusoft.bsp.admin.dictionary.po.Dictionary;
import com.neusoft.bsp.admin.dictionary.service.DictionaryService;

import com.neusoft.bsp.common.base.BaseController;
import com.neusoft.bsp.common.base.BaseModel;
import com.neusoft.bsp.common.base.BaseModelJson;
import com.neusoft.bsp.common.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/dictionary")
public class DictionaryController extends BaseController {
    @Autowired
    DictionaryService dictionaryService;
    
    @PostMapping("/getDictionaries")
    public BaseModelJson<List<Dictionary>> getDictionaries(){
        BaseModelJson<List<Dictionary>> response = new BaseModelJson<>();
        List<Dictionary> result = dictionaryService.getAll();
//        System.out.println(result);
//        System.out.println(DictionaryService.getAll());
        if(result!=null && result.size()!=0){
            response.setSuccess();
            response.setData(result);
        }else{
            throw BusinessException.NO_DICTIONARY;
        }
        return response;
    }

    @PostMapping("/addDictionary")
    public BaseModel addDictionary(@RequestBody Dictionary dictionary){
        BaseModel response = new BaseModel();
        if(dictionaryService.insert(dictionary)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }

    @PostMapping("/updateDictionary")
    public BaseModel updateDictionary(@RequestBody Dictionary dictionary){
        BaseModel response = new BaseModel();
        if(dictionaryService.update(dictionary)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }

    @PostMapping("/deleteDictionary")
    public BaseModel deleteDictionary(@RequestBody Dictionary dictionary){
        BaseModel response = new BaseModel();
        if(dictionaryService.deleteDictionary(dictionary)==1){
            response.setSuccess();
        }else{
            response.setFailure();
        }
        return response;
    }
}
