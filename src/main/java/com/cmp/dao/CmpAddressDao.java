package com.cmp.dao;

import com.cmp.pojo.CmpAddress;
import com.cmp.pojo.CmpAddressQuery;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CmpAddressDao {
    int countByExample(CmpAddressQuery example);

    int deleteByExample(CmpAddressQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(CmpAddress record);

    int insertSelective(CmpAddress record);

    List<CmpAddress> selectByExample(CmpAddressQuery example);

    CmpAddress selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CmpAddress record, @Param("example") CmpAddressQuery example);

    int updateByExample(@Param("record") CmpAddress record, @Param("example") CmpAddressQuery example);

    int updateByPrimaryKeySelective(CmpAddress record);

    int updateByPrimaryKey(CmpAddress record);

    /**
     * 更新指定openid的type
     * @param openid
     * @return
     */
    int updateTypeByOpenId(@Param("openid") String openid , @Param("type") int type);
}