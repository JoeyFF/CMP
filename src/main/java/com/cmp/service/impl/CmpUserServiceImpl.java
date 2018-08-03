package com.cmp.service.impl;

import com.cmp.dao.CmpUserDao;
import com.cmp.pojo.CmpUser;
import com.cmp.service.CmpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
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

    @Override
    public CmpUser loginByWx(String wx, String password) {
        return null;
    }

    @Override
    public CmpUser loginByPhone(String phone, String password) {
        return null;
    }

    @Override
    public CmpUser selectByOpenid(String openid) {
        return null;
    }

    @Override
    public CmpUser selectByPhone(String phone) {
        return null;
    }

    @Override
    public CmpUser selectByWx(String wx) {
        return null;
    }

    @Override
    public int update(CmpUser cmpUser) {
        return 0;
    }

    @Override
    public int updatePassword(String phone, String password) {
        return 0;
    }
}
