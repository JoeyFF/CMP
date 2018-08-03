package com.cmp.dao;

import com.cmp.pojo.CmpUser;

/**
 * 用户的dao层
 * 要保证数据的正确性，例如更新库存操作时，要保证库存是非负的
 */
public interface CmpUserDao {

    /**
     * 用户自动注册
     * @param cmpUser
     * @return
     */
    public int insert(CmpUser cmpUser);


}
