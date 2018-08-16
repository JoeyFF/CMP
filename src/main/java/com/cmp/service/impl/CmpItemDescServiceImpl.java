package com.cmp.service.impl;
import com.cmp.dao.CmpItemDescDao;
import com.cmp.dao.CmpItemDao;
import com.cmp.pojo.CmpItem;
import com.cmp.pojo.CmpItemDesc;
import com.cmp.service.CmpItemDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CmpItemDescServiceImpl implements CmpItemDescService{

    @Autowired
    private CmpItemDescDao cmpItemDescDao;
    @Autowired
    private CmpItemDao cmpItemDao;

	@Override
	public int insertItemDesc(CmpItemDesc cmpItemDesc) {
		return cmpItemDescDao.insertSelective(cmpItemDesc);
	}

	@Override
	public int updateItemDesc(CmpItemDesc cmpItemDesc) {
		CmpItem target = cmpItemDao.selectByPrimaryKey(cmpItemDesc.getItemId());
		if(target.getStatus() == 3) {
			return -1;
		}else {
			return cmpItemDescDao.updateByPrimaryKeySelective(cmpItemDesc);
		}
	}

	@Override
	public CmpItemDesc selectItemDescById(Long id) {
		return cmpItemDescDao.selectByPrimaryKey(id);
	}
	
}
