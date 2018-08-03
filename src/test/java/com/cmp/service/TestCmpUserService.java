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
        cmpUser.setOpenid("fess1293");
        cmpUser.setNickname("dsdz12");
        cmpUser.setSex(2);
        System.out.println(cmpUserService.insert(cmpUser));
        System.out.println("成功执行");
    }

}
