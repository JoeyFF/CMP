//package com.cmp.service.impl;
//
//import com.cmp.common.pojo.TaoTaoResult;
//import com.cmp.mapper.TbUserMapper;
//import com.cmp.pojo.TbUser;
//import com.cmp.pojo.TbUserExample;
//import com.cmp.service.TestService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Date;
//import java.util.List;
//
///**
// * @author:wong
// */
//@Service
////开启事务管理
//@Transactional
//public class TestServiceImpl implements TestService {
//
//    //自动注入mapper接口
//    @Autowired
//    private TbUserMapper tbUserMapper;
//
//    @Override
//    public TaoTaoResult createUser(TbUser tbUser) {
//        //设置创建日期
//        tbUser.setCreated(new Date());
//        tbUser.setUpdated(new Date());
//        tbUserMapper.insert(tbUser);
//        //返回通用数据格式
//        return TaoTaoResult.ok();
//    }
//
//    //得到所有的用户列表
//    public List<TbUser> getUserList() {
//        //创建查询条件
//        TbUserExample example = new TbUserExample();
//        //由于查询条件为空，所以不需要创建criteria
//        //调用mapper接口查询
//        List<TbUser> list = tbUserMapper.selectByExample(example);
//        return list;
//    }
//
//    @Override
//    public TbUser getUserByUsername(String username) {
//        //通过username查询用户
//        TbUserExample example=new TbUserExample();
//        TbUserExample.Criteria criteria=example.createCriteria();
//        //设置查询条件
//        criteria.andUsernameEqualTo(username);
//        List<TbUser> tbUsers = tbUserMapper.selectByExample(example);
//        if (tbUsers==null||tbUsers.size()==0)
//            return null;
//        return tbUsers.get(0);
//    }
//}
