package com.cmp.service;

import com.cmp.pojo.CmpAddress;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址的service层
 */
@Service
public interface CmpAddressService {

    /**
     * 添加收货地址
     * @param cmpAddress
     * @return
     */
    public int insertAddress(CmpAddress cmpAddress);

    /**
     * 删除指定id的收货地址
     * @param openid
     * @param id
     * @return
     */
    public int delAddress(String openid , String id);

    /**
     * 更新指定id的收货地址
     * @param cmpAddress
     * @return
     */
    public int updateAddress(CmpAddress cmpAddress);


    /**
     * 查询所有的收货地址
     * @param openid
     * @return
     */
    public List<CmpAddress> selectAddress(String openid);

    /**
     * 查询指定id的收货地址
     * @param openid
     * @param id
     * @return
     */
    public CmpAddress selectOneAddress(String openid , String id);
}
