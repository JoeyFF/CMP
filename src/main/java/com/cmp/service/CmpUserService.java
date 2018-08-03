package com.cmp.service;

import com.cmp.pojo.CmpUser;

/**
 * CmpUserservice层
 */
public interface CmpUserService {
    /**
     * 用户自动注册
     * @param cmpUser
     * @return
     */
    public int insert(CmpUser cmpUser);

    /**
     * 根据微信号和密码登录
     * @param wx
     * @param password
     * @return
     */
    public CmpUser loginByWx(String wx , String password);

    /**
     * 根据手机号和密码登录
     * @param phone
     * @param password
     * @return
     */
    public CmpUser loginByPhone(String phone , String password);

    /**
     * 根据openid查询用户
     * @param openid
     * @return
     */
    public CmpUser selectByOpenid(String openid);

    /**
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    public CmpUser selectByPhone(String phone);

    /**
     * 根据微信号查询用户
     * @param wx
     * @return
     */
    public CmpUser selectByWx(String wx);

    /**
     * 更新用户信息
     * @param cmpUser
     * @return
     */
    public int update(CmpUser cmpUser);

    /**
     * 用户更新密码
     * @param phone
     * @param password
     * @return
     */
    public int updatePassword(String phone , String password);
}
