package com.cmp.dao;

import com.cmp.pojo.CmpUser;
import com.cmp.pojo.CmpUserQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CmpUserDao {
    int countByExample(CmpUserQuery example);

    int deleteByExample(CmpUserQuery example);

    int deleteByPrimaryKey(String openid);

    int insert(CmpUser record);

    int insertSelective(CmpUser record);

    List<CmpUser> selectByExample(CmpUserQuery example);

    CmpUser selectByPrimaryKey(String openid);

    int updateByExampleSelective(@Param("record") CmpUser record, @Param("example") CmpUserQuery example);

    int updateByExample(@Param("record") CmpUser record, @Param("example") CmpUserQuery example);

    int updateByPrimaryKeySelective(CmpUser record);

    int updateByPrimaryKey(CmpUser record);
}