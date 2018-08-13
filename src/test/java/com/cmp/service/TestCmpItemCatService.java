package com.cmp.service;


import com.cmp.pojo.CmpItemCat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCmpItemCatService {

    @Autowired
    private CmpItemCatService cmpItemCatService;


    @Test
    public void testInsertItemCat(){
        CmpItemCat cmpItemCat = new CmpItemCat();
        cmpItemCat.setParentId((long) 0);
        cmpItemCat.setIsParent(true);
        cmpItemCat.setName("test");

        int num = cmpItemCatService.insertItemCat(cmpItemCat);
        System.out.println("成功执行了 " + num + " 行");
    }
}
