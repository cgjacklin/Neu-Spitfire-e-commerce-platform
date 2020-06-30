package com.neusoft.backend.Exception;

import com.neusoft.backend.utils.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ExceptionHelper {

    @ExceptionHandler({ArithmeticException.class})
    public CommonResult arithmeticex(){
        return CommonResult.validateFailed();
    }
}
