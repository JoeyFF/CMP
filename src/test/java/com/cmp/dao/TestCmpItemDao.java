package com.cmp.dao;

import com.cmp.pojo.CmpItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCmpItemDao {

    @Autowired
    private CmpItemDao cmpItemDao;

    @Test
    public void testInsert(){
        CmpItem cmpItem = new CmpItem();
        cmpItem.setTitle("test789");
        cmpItem.setPrice((long) 1000);
        cmpItem.setNum(100);
        cmpItem.setCid((long) 1);
        cmpItem.setStatus((byte) 1);
        System.out.println(cmpItem.getId());
        System.out.println(cmpItemDao.insertSelective(cmpItem));
        System.out.println(cmpItem.getId());
    }
}
