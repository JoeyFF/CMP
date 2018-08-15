package com.cmp.service.impl;

import com.cmp.common.pojo.ItemDesc;
import com.cmp.dao.CmpItemDao;
import com.cmp.dao.CmpItemDescDao;
import com.cmp.pojo.CmpItem;
import com.cmp.pojo.CmpItemDesc;
import com.cmp.pojo.CmpItemQuery;
import com.cmp.service.CmpItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CmpItemServiceImpl implements CmpItemService {

    @Autowired
    private CmpItemDao cmpItemDao;

    @Autowired
    private CmpItemDescDao cmpItemDescDao;


    @Override
    public int insertItem_Desc(CmpItem cmpItem, CmpItemDesc cmpItemDesc) {
        return 0;
    }

    @Override
    public int insertItem(CmpItem cmpItem) {
        return 0;
    }

    @Override
    public int updateItem(CmpItem cmpItem) {
        return 0;
    }

    @Override
    public List<CmpItem> selectItem(int pageNum, int num) {
        CmpItemQuery example = new CmpItemQuery();
        example.setPageNo(pageNum);
        example.setPageSize(num);
        CmpItemQuery.Criteria criteria = example.createCriteria();
        return cmpItemDao.selectByExample(example);
    }

    @Override
    public ItemDesc selectItem_Desc(Long id) {
        return null;
    }

    @Override
    public CmpItem selectItemById(Long id) {
        return null;
    }

    @Override
    public int updateItemStatusById(Long id) {
        return 0;
    }
}
