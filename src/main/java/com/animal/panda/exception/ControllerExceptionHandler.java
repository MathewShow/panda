package com.animal.panda.exception;

import com.animal.panda.pojo.IMoocJSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局controller层异常处理类
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    public static final String ERROR_VIEW = "error";

    /**
     * Exception异常捕捉处理
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response,Exception e){

        e.printStackTrace();//打印异常
        if(isAjax(request)){
            return IMoocJSONResult.errorException(e.getMessage());
        }else{
            ModelAndView model = new ModelAndView();
            model.addObject("exception",e);
            model.addObject("url",request.getRequestURL());
            model.setViewName(ERROR_VIEW);
            return model;
        }

    }

    /**
     * 判断请求是否是ajax异步请求
     * @param httpRequest
     * @return
     */
    public  boolean isAjax(HttpServletRequest httpRequest){
        return  (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals( httpRequest.getHeader("X-Requested-With").toString()) );
    }
}
