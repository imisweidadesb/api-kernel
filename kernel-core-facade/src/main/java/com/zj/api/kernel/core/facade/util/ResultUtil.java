package com.zj.api.kernel.core.facade.util;

import com.zj.api.kernel.core.facade.constant.ResultCode;
import com.zj.api.kernel.core.facade.result.Result;

/**
 * Created by js on 2017/1/17.
 */
public class ResultUtil {

    /**
     * 获取一个成功的实例
     *
     * @param obj
     * @return
     */
    public static Result getSuccessResult(Object obj) {
        Result result = new Result();
        result.setSuccess(true);
        result.setMessage("");
        result.setCode(ResultCode.SUCCESS);
        result.setT(obj);
        return result;
    }

    /**
     * 获得一个系统错误的实例
     *
     * @param message
     * @return
     */
    public static Result getSystemErrorResult(String message) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMessage(message);
        result.setCode(ResultCode.SYSTEM_ERROR);
        return result;
    }

    /**
     * 获得一个参数错误的实例
     *
     * @param message
     * @return
     */
    public static Result getParamsErrorResult(String message) {
        Result result = new Result();
        result.setSuccess(false);
        result.setMessage(message);
        result.setCode(ResultCode.PARAMS_ERROR);
        return result;
    }


}
