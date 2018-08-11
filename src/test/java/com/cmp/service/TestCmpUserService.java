package com.cmp.service;

import com.cmp.pojo.CmpUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCmpUserService {
    @Autowired
    private CmpUserService cmpUserService;

    @Test
    public void testInsert(){
        CmpUser cmpUser = new CmpUser();
        cmpUser.setOpenid("fe32dasxs");
        cmpUser.setNickname("dsfcx2");
        cmpUser.setSex((byte) 1);
        cmpUser.setPhone("18921367318");
        cmpUser.setPassword("123456");
        System.out.println(cmpUserService.insert(cmpUser));
        System.out.println("成功执行");
    }

    @Test
    public void testLoginByWx(){
        CmpUser cmpUser = cmpUserService.loginByWx("mydwsas" , "123456");
        System.out.println(cmpUser);
    }

    @Test
    public void testLoginByPhone(){
        CmpUser cmpUser = cmpUserService.loginByPhone("1892189318" , "123456");
        System.out.println(cmpUser);
    }

    @Test
    public void testSelectByOpenid(){
        CmpUser cmpUser = cmpUserService.selectByOpenid("1231cdc93");
        System.out.println(cmpUser);
    }

    @Test
    public void testSelectByPhone(){
        CmpUser cmpUser = cmpUserService.selectByPhone("1892189318");
        System.out.println(cmpUser);
    }

    @Test
    public void testSelectByWx(){
        CmpUser cmpUser = cmpUserService.selectByWx("mydwsas");
        System.out.println(cmpUser);
    }

    @Test
    public void testUpdate(){
        CmpUser cmpUser = cmpUserService.selectByWx("mydwsas");
        cmpUser.setPassword("123456789");
        cmpUserService.update(cmpUser);
        System.out.println(cmpUserService.update(cmpUser));
    }

    @Test
    public void testUpdatePassword(){
        System.out.println(cmpUserService.updatePassword("1892189318" ,"12345678"));

    }
}
