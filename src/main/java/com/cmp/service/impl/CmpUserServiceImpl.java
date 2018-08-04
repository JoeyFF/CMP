package com.cmp.service.impl;

import com.cmp.dao.CmpUserDao;
import com.cmp.pojo.CmpUser;
import com.cmp.service.CmpUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zdb
 * CmpUserService
 * 要保证数据的有效性，例如，要写如数据库里的数据不能为负
 */
@Service
@Transactional
public class CmpUserServiceImpl implements CmpUserService {
    @Autowired
    private CmpUserDao cmpUserDao;

    @Override
    public int insert(CmpUser cmpUser) {
        return cmpUserDao.insert(cmpUser);
    }

    /**
     * 通过微信号和密码登录，账号不存在和密码错误都将抛出异常
     * @param wx
     * @param password
     * @return
     */
    @Override
    public CmpUser loginByWx(String wx, String password) throws NullPointerException{
        CmpUser cmpUser = cmpUserDao.selectByWx(wx);
        if (cmpUser == null) {
            throw new NullPointerException("账号不存在");
        } else{
            cmpUser = cmpUserDao.loginByWx(wx, password);
            if (cmpUser == null) {
                throw new NullPointerException("密码错误");
            }
        }
        return cmpUser;
    }

    /**
     * 通过手机号和密码登录，账号不存在和密码错误都会抛出异常
     * @param phone
     * @param password
     * @return
     * @throws NullPointerException
     */
    @Override
    public CmpUser loginByPhone(String phone, String password) throws NullPointerException{
        CmpUser cmpUser = cmpUserDao.selectByPhone(phone);
        if (cmpUser == null) {
            throw new NullPointerException("账号不存在");
        } else{
            cmpUser = cmpUserDao.loginByPhone(phone, password);
            if (cmpUser == null) {
                throw new NullPointerException("密码错误");
            }
        }
        return cmpUser;
    }

    /**
     * 根据openid查找用户
     * @param openid
     * @return
     */
    @Override
    public CmpUser selectByOpenid(String openid) {
        CmpUser cmpUser = cmpUserDao.selectByOpenid(openid);
        return cmpUser;
    }

    /**
     * 通过手机号查找用户
     * @param phone
     * @return
     */
    @Override
    public CmpUser selectByPhone(String phone) {
        CmpUser cmpUser = cmpUserDao.selectByPhone(phone);
        return cmpUser;
    }

    /**
     * 通过微信号查找用户
     * @param wx
     * @return
     */
    @Override
    public CmpUser selectByWx(String wx) {
        CmpUser cmpUser = cmpUserDao.selectByWx(wx);
        return cmpUser;
    }

    /**
     * 更新用户，如果没有该用户就抛出异常，非法更新
     * @param cmpUser
     * @return
     * @throws NullPointerException
     */
    @Override
    public int update(CmpUser cmpUser) throws NullPointerException{
        String openid = cmpUser.getOpenid();
        if (cmpUserDao.selectByOpenid(openid) != null) {
            return cmpUserDao.update(cmpUser);
        } else {
            throw new NullPointerException("非法更新，没有此用户");
        }
    }


    /**
     * 更新用户密码，如果没有该用户将无法进行更新
     * @param phone
     * @param password
     * @return
     * @throws NullPointerException
     */
    @Override
    public int updatePassword(String phone, String password) throws NullPointerException{
        CmpUser cmpUser = cmpUserDao.selectByPhone(phone);
        //没有这个用户
        if (cmpUser != null) {
            return cmpUserDao.updatePassword(phone, password);
        } else {
            //抛出异常和返回0冲突，当用户不存在的时候就抛出异常
            //将异常让高层捕捉，捕捉到异常时就说明用户不存在
            throw new NullPointerException("非法更新，没有此用户");
        }
    }
}
