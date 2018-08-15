package com.cmp.service;

import com.cmp.pojo.CmpItemDesc;

public interface CmpItemDescService {

    /**
     * 添加商品描述
     * @param cmpItemDesc
     * @return
     */
    public int insertItemDesc(CmpItemDesc cmpItemDesc);

    /**
     * 更改商品描述
     * @param cmpItemDesc
     * @return
     */
    public int updateItemDesc(CmpItemDesc cmpItemDesc);

    /**
     * 查询指定cid的商品描述
     * @param id
     * @return
     */
    public CmpItemDesc selectItemDescById(Long id);
}
