package com.cmp.service.impl;

import com.cmp.dao.CmpUserDao;
import com.cmp.pojo.CmpUser;
import com.cmp.pojo.CmpUserQuery;
import com.cmp.service.CmpUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    /**
     * 插入用户
     */
    public int insert(CmpUser cmpUser) {
        return cmpUserDao.insert(cmpUser);
    }

    @Override
    /**
     * 通过微信号和密码登录，账号不存在和密码错误都将抛出异常
     */
    public CmpUser loginByWx(String wx, String password) throws NullPointerException {
        CmpUserQuery example = new CmpUserQuery();
        CmpUserQuery.Criteria criteria = example.createCriteria();
        criteria.andWxEqualTo(wx);
        criteria.andPasswordEqualTo(password);
        List<CmpUser> result = cmpUserDao.selectByExample(example);
        if(result.isEmpty()){
            return null;
        }else{
            return result.get(0);
        }
    }

    @Override
    /**
     * 通过手机号和密码登录，账号不存在和密码错误都会抛出异常
     */
    public CmpUser loginByPhone(String phone, String password) throws NullPointerException {
        CmpUserQuery example = new CmpUserQuery();
        CmpUserQuery.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        criteria.andPasswordEqualTo(password);
        List<CmpUser> result = cmpUserDao.selectByExample(example);
        if(result.isEmpty()){
            return null;
        }else{
            return result.get(0);
        }
    }

    @Override
    /**
     * 根据openid查找用户
     */
    public CmpUser selectByOpenid(String openid) {
        return cmpUserDao.selectByPrimaryKey(openid);
    }

    @Override
    /**
     * 通过手机号查找用户
     */
    public CmpUser selectByPhone(String phone) {
        CmpUserQuery example = new CmpUserQuery();
        CmpUserQuery.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<CmpUser> result = cmpUserDao.selectByExample(example);
        if(result.isEmpty()){
            return null;
        }else{
            return result.get(0);
        }
    }

    @Override
    /**
     * 通过微信号查找用户
     */
    public CmpUser selectByWx(String wx) {
        CmpUserQuery example = new CmpUserQuery();
        CmpUserQuery.Criteria criteria = example.createCriteria();
        criteria.andWxEqualTo(wx);
        List<CmpUser> result = cmpUserDao.selectByExample(example);
        if(result.isEmpty()){
            return null;
        }else{
            return result.get(0);
        }
    }

    @Override
    /**
     * 更新用户，如果没有该用户就抛出异常，非法更新
     */
    public int update(CmpUser cmpUser) throws NullPointerException {
        CmpUser exisUser = selectByOpenid(cmpUser.getOpenid());
        if(exisUser != null){
            //跟新用户
            return cmpUserDao.updateByPrimaryKey(cmpUser);
        }else{
            return 0;
        }
    }

    @Override
    /**
     * 更新密码
     */
    public int updatePassword(String phone, String password) throws NullPointerException {
        CmpUser exisUser = selectByPhone(phone);
        if(exisUser != null){
            //更新密码
            exisUser.setPassword(password);
            return cmpUserDao.updateByPrimaryKey(exisUser);
        }else{
            return 0;
        }
    }

}
