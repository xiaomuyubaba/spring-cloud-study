package com.lijin.study.springcloud.common.exception;

import com.lijin.study.springcloud.common.enums.ErrorCodeEnum;
import com.lijin.study.springcloud.common.enums.FuncEnum;

public class BizException extends RuntimeException {

    private final FuncEnum func; // 功能码
    private final ErrorCodeEnum errCode;
    private final String msg;

    protected BizException(FuncEnum func, ErrorCodeEnum errCode, Throwable cause) {
        this(func, errCode, null, cause);
    }

    protected BizException(FuncEnum func, ErrorCodeEnum errCode, String msg, Throwable cause) {
        super(msg != null ? msg : errCode.getDesc(), cause);
        this.func = func;
        this.errCode = errCode;
        this.msg = msg != null ? msg : errCode.getDesc();
    }

    public ErrorCodeEnum getErrCode() {
        return errCode;
    }

    public String getMsg() {
        return msg;
    }

    public FuncEnum getFunc() {
        return func;
    }
}
