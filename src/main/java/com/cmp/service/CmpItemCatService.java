package com.cmp.service;

import com.cmp.pojo.CmpItemCat;

import java.util.List;

/**
 * 商品类目service
 */
public interface CmpItemCatService {

    /**
     * 添加商品类目
     * @param cmpItemCat
     * @return
     */
    public int insertItemCat(CmpItemCat cmpItemCat);

    /**
     * 根据id查询商品类目
     * @param id
     * @return
     */
    public CmpItemCat selectOneItemCat(Long id);

    /**
     * 根据parentId查询商品类目
     * @param parentId
     * @return
     */
    public List<CmpItemCat> selectItemCat(Long parentId);

    /**
     * 根据id更改商品类目
     * @param cmpItemCat
     * @return
     */
    public int updateItemCat(CmpItemCat cmpItemCat);
}
