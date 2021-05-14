package com.common;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T result;

    public Result() {
    }

    public static Result<?> ok(){
        Result<?> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        return result;
    }

    public static <T> Result<T> ok(T object){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMessage("操作成功");
        result.setResult(object);
        return result;
    }

    public static Result<?> fail(){
        Result<?> result = new Result<>();
        result.setCode(500);
        result.setMessage("操作失败");
        return result;
    }

    public static <T> Result<T> fail(T object){
        Result<T> result = new Result<>();
        result.setCode(500);
        result.setMessage("操作失败");
        result.setResult(object);
        return result;
    }
}
