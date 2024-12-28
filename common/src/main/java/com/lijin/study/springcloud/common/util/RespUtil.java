package com.lijin.study.springcloud.common.util;

import com.lijin.study.springcloud.common.entity.Response;
import com.lijin.study.springcloud.common.enums.ErrorCodeEnum;
import com.lijin.study.springcloud.common.enums.FuncEnum;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * 应答码对象工具类
 * <p>
 * 应答码由10位字母数字构成：
 * - 前6位取值表示功能码
 * - 后四位表示错误码
 */
public class RespUtil {

    private static final String SUCCESS_CODE = "0000000000";
    private static final String SUCCESS_MSG = "成功";

    /**
     * 成功应答
     *
     * @param data 成功应答报文体对象
     * @param <R>  成功应答报文体对象类型
     * @return 成功应答对象
     */
    public static <R> Response<R> success(R data) {
        Response<R> response = new Response<>();
        response.setCode(SUCCESS_CODE);
        response.setMsg(SUCCESS_MSG);
        response.setRespData(data);
        return response;
    }

    /**
     * 构造失败应答
     *
     * @param func      功能码
     * @param errorCode 应答码
     * @return 失败应答对象
     */
    public static <T> Response<T> fail(FuncEnum func, ErrorCodeEnum errorCode) {
        return fail(func, errorCode, null, null);
    }

    /**
     * 构造失败应答
     *
     * @param func      功能点
     * @param errorCode 应答码
     * @param msg       错误信息
     * @return 失败应答对象
     */
    public static <R> Response<R> fail(FuncEnum func, ErrorCodeEnum errorCode, String msg) {
        return fail(func, errorCode, msg, null);
    }

    /**
     * 构造失败应答
     *
     * @param func      模块码
     * @param errorCode 应答码
     * @param msg       错误信息
     * @param data      报文体数据
     * @param <R>       报文体类型
     * @return 失败应答
     */
    public static <R> Response<R> fail(FuncEnum func, ErrorCodeEnum errorCode, String msg, R data) {
        // func、errorCode不能为null
        Assert.notNull(func, "func is null!");
        Assert.notNull(errorCode, "errorCode is null!");

        // 构造失败应答对象
        Response<R> response = new Response<>();
        // 最终应答码构成： 模块 + 功能点 + 错误码，这样根据失败应答码就可以定位到功能点，便于排查
        String finalCode = func.getCode() + errorCode.getCode();
        response.setCode(finalCode);
        response.setMsg(StringUtils.hasLength(msg) ? msg : errorCode.getDesc());
        response.setRespData(data);
        return response;
    }
}
