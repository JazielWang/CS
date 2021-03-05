package com.itheima.resolver;

import com.itheima.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 王杰
 */
public class MyExceptionResolver implements HandlerExceptionResolver {

    @Override
    /**
     * Exception:我们的异常
     * ModelAndView:跳转到错误视图信息
     */
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        if (e instanceof MyException){
            modelAndView.addObject("info","自定义异常");
        }else if (e instanceof ClassCastException){
            modelAndView.addObject("info", "类型转换异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
