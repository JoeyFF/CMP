//package com.cmp.controller;
//
//import com.cmp.common.pojo.TaoTaoResult;
//import com.cmp.pojo.TbUser;
//import com.cmp.service.TestService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
///**
// * @author:wong
// */
//@Controller
//public class TestController {
//
//    //注入服务bean
//    @Autowired
//    private TestService testService;
//
//    @RequestMapping("/test/getUserList")
//    //返回json数据
//    @ResponseBody
//    public List<TbUser> getUserList(){
//        List<TbUser> list = testService.getUserList();
//        return list;
//    }
//
//    @RequestMapping("/test/createUser")
//    @ResponseBody
//    public TaoTaoResult createUser(TbUser tbUser){
//        TaoTaoResult taoTaoResult = testService.createUser(tbUser);
//        return taoTaoResult;
//    }
//
//    @RequestMapping("/test/getUserByUsername/{username}")
//    @ResponseBody
//    public TbUser getUserByUsername(@PathVariable String username){
//        TbUser tb = testService.getUserByUsername(username);
//        return tb;
//    }
//}
