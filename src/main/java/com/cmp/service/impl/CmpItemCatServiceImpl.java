package com.cmp.service.impl;

import com.cmp.dao.CmpItemCatDao;
import com.cmp.pojo.CmpItemCat;
import com.cmp.pojo.CmpItemCatQuery;
import com.cmp.pojo.CmpItemCatQuery.Criteria;
import com.cmp.service.CmpItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zdb
 */
@Service
@Transactional
public class CmpItemCatServiceImpl implements CmpItemCatService {

    @Autowired
    private CmpItemCatDao cmpItemCatDao;

    /**
     * 插入一条商品信息
     * @param cmpItemCat
     * @return int
     */
    @Override
    public int insertItemCat(CmpItemCat cmpItemCat) {
        /**
         * 这里先判断id是否存在再进行插入，如果不存在的话返回-1
         */
        CmpItemCat isExist = cmpItemCatDao.selectByPrimaryKey(cmpItemCat.getId());
        //存在的话在进行正常插入，正常更新的返回值是大于等于0的
        if (isExist != null) {
            return cmpItemCatDao.insertSelective(cmpItemCat);
        }
        return -1;
    }

    /**
     * 返回指定id的商品
     * @param id
     * @return CmpItemCat
     */
    @Override
    public CmpItemCat selectOneItemCat(Long id) {
        return cmpItemCatDao.selectByPrimaryKey(id);
    }

    /**
     * 返回指定parent_id的所有商品
     * @param parentId
     * @return List<CmpItemCat>
     */
    @Override
    public List<CmpItemCat> selectItemCat(Long parentId) {
        List<CmpItemCat> resultList = null;
        CmpItemCatQuery example = new CmpItemCatQuery();
        Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        return cmpItemCatDao.selectByExample(example);
    }

    /**
     * 对商品类进行更新
     * @param cmpItemCat
     * @return int
     */
    @Override
    public int updateItemCat(CmpItemCat cmpItemCat) {
        /**
         * 这里先判断id是否存在再进行更新，如果不存在的话返回-1
         */
        CmpItemCat isExist = cmpItemCatDao.selectByPrimaryKey(cmpItemCat.getId());
        //存在的话在进行正常更新，正常更新的返回值是大于等于0的
        if (isExist != null) {
            return cmpItemCatDao.updateByPrimaryKeySelective(cmpItemCat);
        }
        return -1;
    }
}
