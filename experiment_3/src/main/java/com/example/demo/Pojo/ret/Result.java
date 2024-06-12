package com.example.demo.Pojo.ret;

import com.example.demo.Pojo.ret.enums.ResultEnum;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.util.Objects;

/**
 * @author MZ_Li
 * @date 2024/6/12 11:31
 */
@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

    private Result() {
    }

    protected static <T> Result<T> build(T data) {
        Result<T> result = new Result<>();
        if (!Objects.isNull(data)) {
            result.setData(data);
        }
        return result;
    }

    protected static <T> Result<T> build(T body, Integer code, String msg) {
        Result<T> result = build(body);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    protected static <T> Result<T> build(T body, ResultEnum resultEnum) {
        Result<T> result = build(body);
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        return result;
    }

    public static <T> Result<T> success() {
        return Result.success(null);
    }

    public static <T> Result<T> success(T data) {
        return build(data, ResultEnum.SUCCESS);
    }

    public static <T> Result<T> fail() {
        return Result.fail(null);
    }

    public static <T> Result<T> fail(T data) {
        return build(data, ResultEnum.FAIL);
    }

    public static <T> Result<T> warn() {
        return Result.warn(null);
    }

    public static <T> Result<T> warn(String msg) {
        return Result.warn(msg, null);
    }

    public static <T> Result<T> warn(String msg, T data) {
        if (StringUtils.isBlank(msg)) {
            return build(data, ResultEnum.WRAN);
        }
        return build(data, ResultEnum.WRAN.getCode(), msg);
    }

    public static <T> Result<T> error() {
        return Result.error(null);
    }

    public static <T> Result<T> error(String msg) {
        return Result.error(msg, null);
    }

    public static <T> Result<T> error(String msg, T data) {
        if (StringUtils.isBlank(msg)) {
            return build(null, ResultEnum.SERVICE_ERROR);
        }
        return build(data, ResultEnum.SERVICE_ERROR.getCode(), msg);
    }
}
