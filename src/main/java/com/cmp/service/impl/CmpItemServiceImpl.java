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
    /**
     * 添加商品基本信息和全部描述
     */
    public int insertItem_Desc(CmpItem cmpItem, CmpItemDesc cmpItemDesc) {
    	this.insertItem(cmpItem);
    	cmpItemDesc.setItemId(cmpItem.getId());
        return cmpItemDescDao.insertSelective(cmpItemDesc);
    }

    @Override
    /**
     * 添加商品基本信息
     */
    public int insertItem(CmpItem cmpItem) {
    	return cmpItemDao.insertSelective(cmpItem);
    }

    @Override
    /**
     * 更改商品基本信息
     */
    public int updateItem(CmpItem cmpItem) {
        CmpItem target = this.selectItemById(cmpItem.getId());
        //更改商品不存在
        if(target == null) {
        	return 0;
        }
        //商品已被删除则返回-1
        if(target.getStatus() == 3) {
        	return -1;
        }else {
        	return cmpItemDao.updateByPrimaryKeySelective(cmpItem);
        }
    }

    @Override
    /**
     * 查询商品基本信息
     */
    public List<CmpItem> selectItem(int pageNum, int num) {
        CmpItemQuery example = new CmpItemQuery();
        example.setPageNo(pageNum);
        example.setPageSize(num);
        CmpItemQuery.Criteria criteria = example.createCriteria();
        return cmpItemDao.selectByExample(example);
    }

    @Override
    /**
     * 查询指定id商品的全部信息
     */
    public ItemDesc selectItem_Desc(Long id) {

        CmpItem target = this.selectItemById(id);
        //商品不存在
        if(target == null) {
        	return null;
        }
        
        //封装ItemDesc
    	ItemDesc itemDesc = new ItemDesc();
    	itemDesc.setId(target.getId());
    	itemDesc.setTitle(target.getTitle());
    	itemDesc.setSellPoint(target.getSellPoint());
    	itemDesc.setPrice(target.getPrice());
    	itemDesc.setNewPrice(target.getNewPrice());
    	itemDesc.setNum(target.getNum());
    	itemDesc.setBarcode(target.getBarcode());
    	itemDesc.setImage(target.getImage());
    	itemDesc.setCid(target.getCid());
    	itemDesc.setStatus(target.getStatus());
    	itemDesc.setCreated(target.getCreated());
    	itemDesc.setItemDesc(cmpItemDescDao.selectByPrimaryKey(id).toString());
    	return itemDesc;
        
    }

    @Override
    /**
     * 查询指定id商品的基本信息
     */
    public CmpItem selectItemById(Long id) {
        return cmpItemDao.selectByPrimaryKey(id);
    }

    /**
     * 更新指定id商品的status
     */
//    public int updateItemStatusById(Long id, Byte status) {
//        CmpItem target = this.selectItemById(id);
//        //更改商品不存在
//        if(target == null) {
//        	return 0;
//        }else {
//        	target.setStatus(status);
//        	return this.updateItem(target);
//        }
//    }
}
