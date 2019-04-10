package top.sicso.blog.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import top.sicso.blog.common.ResultBean;

/**
 * 全局异常处理类
 */
@ControllerAdvice
@Slf4j
public class CustomerExceptionHandler {

    @ExceptionHandler(CustomerException.class)
    @ResponseBody
    public ResultBean handleCustomerException(Exception e) {
        ResultBean resultBean = new ResultBean();
        if (e instanceof CustomerException) {
            resultBean.setMessage(e.getMessage());
        } else {
            resultBean.setMessage("未知错误");
        }

        return resultBean;
    }


    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView handle404Exception(Exception e, ModelAndView modelAndView) {
        if (e != null) {
            modelAndView.addObject("errorMsg", e.getMessage());
            modelAndView.setViewName("/404");
        }
        return modelAndView;
    }


    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ModelAndView handle500Exception(Exception e, ModelAndView modelAndView) {
        if (e != null) {
            modelAndView.addObject("errorMsg", e.getMessage());
            modelAndView.setViewName("/500");
        }
        return modelAndView;
    }


}
