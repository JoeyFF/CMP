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
        cmpItemCat.setName("电子产品");

        int num = cmpItemCatService.insertItemCat(cmpItemCat);
        System.out.println("成功执行了 " + num + " 行");
    }

    @Test
    public void testSelectOneItemCat(){
        System.out.println(cmpItemCatService.selectOneItemCat((long) 1184));
    }

    @Test
    public void testSelectItemCat(){
        System.out.println(cmpItemCatService.selectItemCat((long) 0));
    }

    @Test
    public void testUpdateItemCat(){
        CmpItemCat cmpItemCat = cmpItemCatService.selectOneItemCat((long) 1183);
        cmpItemCat.setStatus(1);
        System.out.println(cmpItemCatService.updateItemCat(cmpItemCat));
    }
}
