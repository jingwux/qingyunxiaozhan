package top.sicso.blog.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.sicso.blog.common.ResultBean;
import top.sicso.blog.constant.ResultCodeEnum;

/**
 * 全局异常处理类
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerException.class)
    @ResponseBody
    public ResultBean handleCustomerException(CustomerException e) {
        return resultHandler(e.getResultCodeEnum());
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean defaultException(Exception e) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(ResultCodeEnum.UNKNOWN_ERROR.getCode());
        resultBean.setMessage(ResultCodeEnum.UNKNOWN_ERROR.getMessage() + "：" + e.getMessage());
        return resultBean;
    }

    private ResultBean resultHandler(ResultCodeEnum resultCodeEnum) {
        ResultBean resultBean = new ResultBean();
        resultBean.setCode(resultCodeEnum.getCode());
        return resultBean;
    }


}
