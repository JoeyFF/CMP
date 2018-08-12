package com.cmp.dao;

import com.cmp.pojo.CmpUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCmpUserDao {

    @Autowired
    private CmpUserDao cmpUserDao;

    @Test
    public void testInsert(){
        CmpUser cmpUser = new CmpUser();
        cmpUser.setOpenid("1231cdc93");
        cmpUser.setNickname("ddc12");
        cmpUser.setWx("mydwsas");
        cmpUser.setPassword("123456");
        cmpUser.setSex(Byte.parseByte("1"));
        System.out.println(cmpUserDao.insert(cmpUser));
        System.out.println("成功插入");
    }



}
