package com.cmp.service;

import com.cmp.pojo.CmpAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCmpAddressService {

    @Autowired
    private CmpAddressService cmpAddressService;

    @Test
    public void testInsertAddress(){
        CmpAddress cmpAddress = new CmpAddress();
        cmpAddress.setAddress("文岚路9号");
        cmpAddress.setCity("上海");
        cmpAddress.setCountry("中国");
        cmpAddress.setName("天天");
        cmpAddress.setPhone("1282893908");
        cmpAddress.setType(1);
        cmpAddress.setOpenid("iu1293");
        cmpAddress.setProvince("");

        int num = cmpAddressService.insertAddress(cmpAddress);
        System.out.println("成功执行了 " + num + " 行");
    }

    @Test
    public void testDelAddress(){
        String openid = "i93";
        int id = 2;
        int num = cmpAddressService.delAddress(openid , id);
        System.out.println("成功执行了 " + num + " 行");
    }

    @Test
    public void testSelectOneAddress(){
        String openid = "iu1293";
        int id = 3;
        System.out.println(cmpAddressService.selectOneAddress(openid , id));
    }

    @Test
    public void testSelectAddress(){
        String openid = "iu1293";
        System.out.println(cmpAddressService.selectAddress(openid));
    }

    @Test
    public void testUpdateAddress(){
        String openid = "iu1293";
        int id = 3;
        CmpAddress cmpAddress = cmpAddressService.selectOneAddress(openid , id);
        cmpAddress.setName("张三狗");
        int num = cmpAddressService.updateAddress(cmpAddress);
        System.out.println("成功执行了 " + num + " 行");
    }
}
