package com.cmp.dao;

import com.cmp.pojo.CmpItemCat;
import com.cmp.pojo.CmpItemCatQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmpItemCatDao {
    int countByExample(CmpItemCatQuery example);

    int deleteByExample(CmpItemCatQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(CmpItemCat record);

    int insertSelective(CmpItemCat record);

    List<CmpItemCat> selectByExample(CmpItemCatQuery example);

    CmpItemCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CmpItemCat record, @Param("example") CmpItemCatQuery example);

    int updateByExample(@Param("record") CmpItemCat record, @Param("example") CmpItemCatQuery example);

    int updateByPrimaryKeySelective(CmpItemCat record);

    int updateByPrimaryKey(CmpItemCat record);
}