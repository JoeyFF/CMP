package com.cmp.service.impl;

import com.cmp.dao.CmpItemCatDao;
import com.cmp.pojo.CmpItemCat;
import com.cmp.service.CmpItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CmpItemCatServiceImpl implements CmpItemCatService {

    @Autowired
    private CmpItemCatDao cmpItemCatDao;

    @Override
    public int insertItemCat(CmpItemCat cmpItemCat) {
        return cmpItemCatDao.insert(cmpItemCat);
    }

    @Override
    public CmpItemCat selectOneItemCat(Long id) {
        return null;
    }

    @Override
    public List<CmpItemCat> selectItemCat(Long parentId) {
        return null;
    }

    @Override
    public int updateItemCat(CmpItemCat cmpItemCat) {
        return 0;
    }
}
