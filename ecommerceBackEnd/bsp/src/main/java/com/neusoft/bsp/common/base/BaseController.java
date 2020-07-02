package com.neusoft.bsp.common.base;

import com.neusoft.bsp.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;

/**
 * 所有controller的父类，可以打印log，并且处理所有的后端错误: 分为运行时错误和系统错误
 */
public class BaseController {
    Logger logger = LoggerFactory.getLogger(BusinessException.class);

    @ExceptionHandler
    @ResponseBody
    public BaseModel exp(HttpServletRequest request,Exception exception){
        BaseModel baseModel = new BaseModel();

        if(exception instanceof BusinessException){
            baseModel.message = exception.getMessage();
            baseModel.code = ((BusinessException) exception).getCode();
            this.logger.error("errorResponse:{}",baseModel.toString());
        }else{
            this.logger.error("errorResponse:{}",exception.toString());
            baseModel.code = 500;
            baseModel.message = "Sorry!Exception occurs!Please try it later";
        }
        return baseModel;
    }

    //处理验证错误
    public String getErrorResponse(BindingResult bindingResult){
        StringBuffer sb = new StringBuffer();
        Iterator errIterator = bindingResult.getAllErrors().iterator();
        while (errIterator.hasNext()){
            ObjectError objectError = (ObjectError)errIterator.next();
            this.logger.info(objectError.getDefaultMessage());
            this.logger.info(objectError.getCode());
            sb.append(objectError.getDefaultMessage()).append(",");
        }
        sb.delete(sb.length() - 1,sb.length());
        return  sb.toString();
    }

}
