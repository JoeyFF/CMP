package com.cmp.dao;

import com.cmp.pojo.CmpItemDesc;
import com.cmp.pojo.CmpItemDescQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpItemDescDao {
    int countByExample(CmpItemDescQuery example);

    int deleteByExample(CmpItemDescQuery example);

    int deleteByPrimaryKey(Long itemId);

    int insert(CmpItemDesc record);

    int insertSelective(CmpItemDesc record);

    List<CmpItemDesc> selectByExampleWithBLOBs(CmpItemDescQuery example);

    List<CmpItemDesc> selectByExample(CmpItemDescQuery example);

    CmpItemDesc selectByPrimaryKey(Long itemId);

    int updateByExampleSelective(@Param("record") CmpItemDesc record, @Param("example") CmpItemDescQuery example);

    int updateByExampleWithBLOBs(@Param("record") CmpItemDesc record, @Param("example") CmpItemDescQuery example);

    int updateByExample(@Param("record") CmpItemDesc record, @Param("example") CmpItemDescQuery example);

    int updateByPrimaryKeySelective(CmpItemDesc record);

    int updateByPrimaryKeyWithBLOBs(CmpItemDesc record);

    int updateByPrimaryKey(CmpItemDesc record);
}