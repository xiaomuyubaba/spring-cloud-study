package com.lijin.study.springcloud.service.exception;

import com.lijin.study.springcloud.common.entity.Response;
import com.lijin.study.springcloud.common.enums.ErrorCodeEnum;
import com.lijin.study.springcloud.common.enums.FuncEnum;
import com.lijin.study.springcloud.common.exception.BizException;
import com.lijin.study.springcloud.common.util.RespUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ServiceExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ServiceExceptionHandler.class);

    /**
     * 全局异常处理
     *
     * @param e 异常信息
     * @return 错误信息
     */
    @ExceptionHandler(Exception.class)
    public Response<String> globalException(Exception e) {
        log.error("全局异常: {}", e.getMessage());
        return RespUtil.fail(FuncEnum.UNKNOWN, ErrorCodeEnum.RC_ZZZZ, e.getMessage());
    }

    /**
     * 业务异常处理
     *
     * @param bizException 异常信息
     * @return 错误信息
     */
    @ExceptionHandler(BizException.class)
    public Response<String> bizException(BizException bizException) {
        log.error("业务异常，功能码: [{}], 错误码: [{}], 异常原因: [{}]", bizException.getFunc().getCode(), bizException.getErrCode().getCode(), bizException.getMessage());
        return RespUtil.fail(bizException.getFunc(), bizException.getErrCode(), bizException.getMsg());
    }

    /**
     * 参数校验异常处理
     *
     * @param methodArgumentNotValidException 异常信息
     * @return 错误信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<String> methodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<ObjectError> errors = methodArgumentNotValidException.getBindingResult().getAllErrors();
        FieldError fieldError = (FieldError) errors.getFirst();
        log.error("参数校验异常 => 校验参数: {}, 原因是: {}", fieldError.getField(), fieldError.getDefaultMessage());
        return RespUtil.fail(FuncEnum.UNKNOWN, ErrorCodeEnum.RC_0002, fieldError.getDefaultMessage());
    }

    /**
     * 请求方式错误异常处理
     *
     * @param httpServletRequest 异常信息
     * @return 错误信息
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response<String> httpRequestMethodNotSupportedException(HttpServletRequest httpServletRequest) {
        log.error("请求方式错误异常 => 请求方式: {}, 请求地址: {}", httpServletRequest.getMethod(), httpServletRequest.getServletPath());
        return RespUtil.fail(FuncEnum.UNKNOWN, ErrorCodeEnum.RC_0001, "不支持该HTTP请求方法: " + httpServletRequest.getMethod());
    }

}
