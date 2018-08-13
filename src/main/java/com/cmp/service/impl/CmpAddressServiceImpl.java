package com.cmp.service.impl;
import java.util.List;

import com.cmp.service.CmpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cmp.pojo.CmpAddressQuery;
import com.cmp.pojo.CmpAddressQuery.Criteria;
import com.cmp.pojo.CmpUser;
import com.cmp.pojo.CmpAddress;
import com.cmp.service.CmpAddressService;
import com.cmp.dao.CmpAddressDao;

@Service
@Transactional
public class CmpAddressServiceImpl implements CmpAddressService{

    @Autowired
    private CmpUserService cmpUserService;

    @Autowired
    private CmpAddressDao cmpAddressDao;

    @Override
    /**
     * 添加收货地址
     */
    public int insertAddress(CmpAddress cmpAddress) {
        CmpUser exisUser = cmpUserService.selectByOpenid(cmpAddress.getOpenid());
        if(exisUser != null) {
            return cmpAddressDao.insert(cmpAddress);
        }else {
            return 0;
        }
    }

    @Override
    /**
     * 删除收货地址
     */
    public int delAddress(String openid, int id) {
        CmpUser exisUser = cmpUserService.selectByOpenid(openid);
        if(exisUser != null) {
            CmpAddressQuery example = new CmpAddressQuery();
            Criteria criteria = example.createCriteria();
            criteria.andOpenidEqualTo(openid);
            criteria.andIdEqualTo(id);
            return cmpAddressDao.deleteByExample(example);
        }else {
            return 0;
        }
    }

    @Override
    /**
     * 更改收货地址
     */
    public int updateAddress(CmpAddress cmpAddress) {
        CmpUser exisUser = cmpUserService.selectByOpenid(cmpAddress.getOpenid());
        if(exisUser != null) {
            return cmpAddressDao.updateByPrimaryKey(cmpAddress);
        }else {
            return 0;
        }
    }

    @Override
    /**
     * 查看所有收货地址
     */
    public List<CmpAddress> selectAddress(String openid) {
        List<CmpAddress> result = null;
        CmpUser exisUser = cmpUserService.selectByOpenid(openid);
        if(exisUser != null) {
            CmpAddressQuery example = new CmpAddressQuery();
            Criteria criteria = example.createCriteria();
            criteria.andOpenidEqualTo(openid);
            result = cmpAddressDao.selectByExample(example);
        }
        return result;
    }

    @Override
    /**
     * 查看指定id的收货地址
     */
    public CmpAddress selectOneAddress(String openid, int id) {
        CmpUser exisUser = cmpUserService.selectByOpenid(openid);
        if(exisUser != null) {
            return cmpAddressDao.selectByPrimaryKey(id);
        }else {
            return null;
        }

    }

}