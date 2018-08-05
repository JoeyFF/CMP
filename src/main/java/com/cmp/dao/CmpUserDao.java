package com.cmp.dao;

import com.cmp.pojo.CmpUser;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author zdb
 * 用户的dao层，这里只定义接口
 * 具体的实现通过对应的xml文件操作
 * @Repository表示将该类注册成为bean
 */
@Repository
public interface CmpUserDao {

    /**
     * 用户自动注册
     * @param cmpUser
     * @return int
     */
    public int insert(CmpUser cmpUser);

    /**
     * 根据微信名和密码进行登录,多参数传参通过@Param进行传参
     * @param wx
     * @param password
     * @return CMPUser
     */
    public CmpUser loginByWx(@Param("wx") String wx, @Param("password") String password);

    /**
     * 根据电话号码和密码进行登录
     * @param phone
     * @param password
     * @return CMPUser
     */
    public CmpUser loginByPhone(@Param("phone") String phone, @Param("password") String password);

    /**
     * 根据openid查询用户
     * @param openid
     * @return CMPUser
     */
    public CmpUser selectByOpenid(String openid);

    /**
     * 根据微信号查询用户
     * @param wx
     * @return CmpUser
     */
    public CmpUser selectByWx(String wx);

    /**
     * 根据电话号码查询用户
     * @param phone
     * @return CmpUser
     */
    public CmpUser selectByPhone(String phone);

    /**
     * 根据用户信息，实现时将通过取出CmpUser的openid进行更新
     * @param cmpUser
     * @return int
     */
    public int update(CmpUser cmpUser);

    /**
     * 更新密码，通过phone确定用户
     * @param phone
     * @param password
     * @return int
     */
    @Options(useGeneratedKeys = false)
    public int updatePassword(@Param("phone") String phone, @Param("password") String password);

}
