package com.cmp.common.utils;

/**
 * controller返回状态的枚举类
 */
public enum EnumUtils {
    SUCCESS("成功",200),
    NOT_NULL("参数不能为空",300),
    PARAM_ERROR("参数错误",400),
    ERROR("服务器异常",500)
    ;
    private String desc;
    private Integer status;

    EnumUtils(String desc, Integer status) {
        this.desc = desc;
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static void main(String[] args) {
        System.out.println(EnumUtils.SUCCESS.getDesc());
    }
}
