package com.lijin.study.springcloud.common.entity;

/**
 * 同一应答对象
 *
 * @param <T>
 */
public class Response<T> {

    private String code; // 应答码
    private String msg; // 应答描述
    private final long respTm; // 应答时间
    private T respData; // 应答报文体

    public Response() {
        this.respTm = System.currentTimeMillis();
    }

    /**
     * 成功应答
     *
     * @param data
     * @param <R>
     * @return
     */
    public static <R> Response<R> success(R data) {
        Response<R> response = new Response<>();
        response.code = RespCodeEnum.RC_0000.getCode();
        response.msg = RespCodeEnum.RC_0000.getMsg();
        response.setRespData(data);
        return response;
    }

    /**
     * 默认失败应答
     *
     * @param data 默认失败应答报文数据实体
     * @param <R>  应答报文数据类型
     * @return 默认失败应答报文实体
     */
    public static <R> Response<R> fail(R data) {
        return fail(RespCodeEnum.RC_ZZZZ, data);
    }

    /**
     * 指定失败应答码的失败应答
     *
     * @param failRespCode 失败应答码
     * @param data         失败应答数据
     * @param <R>          泛型
     * @return 失败应答报文实体类
     */
    public static <R> Response<R> fail(RespCodeEnum failRespCode, R data) {
        if (failRespCode == null) {
            failRespCode = RespCodeEnum.RC_ZZZZ;
        }
        Response<R> response = new Response<>();
        response.code = failRespCode.getCode();
        response.msg = failRespCode.getMsg();
        response.setRespData(data);
        return response;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getRespTm() {
        return respTm;
    }

    public T getRespData() {
        return respData;
    }

    public void setRespData(T respData) {
        this.respData = respData;
    }
}
