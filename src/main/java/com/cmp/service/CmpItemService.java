package com.cmp.service;

import com.cmp.common.pojo.ItemDesc;
import com.cmp.pojo.CmpItem;
import com.cmp.pojo.CmpItemDesc;

import java.util.List;

public interface CmpItemService {

    /**
     * 添加商品基本信息和描述
     * @param cmpItem
     * @param cmpItemDesc
     * @return
     */
    public int insertItem_Desc(CmpItem cmpItem , CmpItemDesc cmpItemDesc);

    /**
     * 添加商品基本信息，会自动返回id，封装在cmpItem对象中
     * @param cmpItem
     * @return
     */
    public int insertItem(CmpItem cmpItem);

    /**
     * 更改商品基本信息
     * @param cmpItem
     * @return
     */
    public int updateItem(CmpItem cmpItem);

    /**
     * 查询商品基本信息(分页，每次返回10条数据，因为是移动端，不需要返回总页数)
     * @param pageNum 第几页
     * @param num 几条数据(默认10)
     * @return
     */
    public List<CmpItem> selectItem(int pageNum , int num);

    /**
     * 查询指点id的商品全部信息
     * @param id
     * @return
     */
    public ItemDesc selectItem_Desc(Long id);

    /**
     * 查询指定id的商品基本信息
     * @param id
     * @return
     */
    public CmpItem selectItemById(Long id);


    /**
     * 更新指定id的商品的status
     * @param id
     * @return
     */
    public int updateItemStatusById(Long id);
}
