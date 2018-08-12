package com.cmp.common.pojo;

/**
 * 返回的结果模板
 * @param <T>
 */
public class Result<T> {
    private Integer status;
    private String msg;
    private T data;

    public Result() {

    }

    public Result(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Result Success(){
        return Success("成功");
    }

    public static Result Success(String msg){
        return new Result(200, msg , null);
    }

    public static Result Error(String msg){
        return new Result(400, msg , null);
    }

}
