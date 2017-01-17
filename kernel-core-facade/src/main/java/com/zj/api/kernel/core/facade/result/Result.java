package com.zj.api.kernel.core.facade.result;

import java.io.Serializable;

/**
 * Created by js on 2017/1/17.
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 8952286647419968985L;

    private T t;

    private int code;

    private boolean success;

    private String message;


    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Result<?> result = (Result<?>) o;

        if (code != result.code) return false;
        if (success != result.success) return false;
        if (t != null ? !t.equals(result.t) : result.t != null) return false;
        return message != null ? message.equals(result.message) : result.message == null;

    }

    @Override
    public int hashCode() {
        int result = t != null ? t.hashCode() : 0;
        result = 31 * result + code;
        result = 31 * result + (success ? 1 : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "t=" + t +
                ", code=" + code +
                ", success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
