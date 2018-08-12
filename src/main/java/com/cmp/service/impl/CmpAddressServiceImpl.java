package com.cmp.service.impl;

import com.cmp.dao.CmpAddressDao;
import com.cmp.pojo.CmpAddress;
import com.cmp.service.CmpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmpAddressServiceImpl implements CmpAddressService {

    @Autowired
    private CmpAddressDao cmpAddressDao;

    @Override
    public int insertAddress(CmpAddress cmpAddress) {
        return cmpAddressDao.insert(cmpAddress);
    }

    @Override
    public int delAddress(String openid, String id) {
        return 0;
    }

    @Override
    public int updateAddress(CmpAddress cmpAddress) {
        return 0;
    }

    @Override
    public List<CmpAddress> selectAddress(String openid) {
        return null;
    }

    @Override
    public CmpAddress selectOneAddress(String openid, String id) {
        return null;
    }
}
