package com.shop.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoableException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception exception) {
        String resmsg = "进入这个全局异常处理器了........这里出问题，请找管理员处理吧！！！";
        ModelAndView modelAndView = new ModelAndView("error");
        //判断异常是属于什么类型的异常，根据不同的异常类型给出不同的异常提示信息
        if (exception instanceof MyException) {
            resmsg = ((MyException) exception).getMsg();
        }
        modelAndView.addObject("errmsg", resmsg);
        return modelAndView;
    }
}
