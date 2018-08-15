package com.cmp.dao;

import com.cmp.pojo.CmpItem;
import com.cmp.pojo.CmpItemQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpItemDao {
    int countByExample(CmpItemQuery example);

    int deleteByExample(CmpItemQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(CmpItem record);

    int insertSelective(CmpItem record);

    List<CmpItem> selectByExample(CmpItemQuery example);

    CmpItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmpItem record, @Param("example") CmpItemQuery example);

    int updateByExample(@Param("record") CmpItem record, @Param("example") CmpItemQuery example);

    int updateByPrimaryKeySelective(CmpItem record);

    int updateByPrimaryKey(CmpItem record);
}