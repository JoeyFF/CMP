package com.cmp.controller;

import com.cmp.common.pojo.Result;
import com.cmp.common.utils.CookieUtils;
import com.cmp.common.utils.SessionUtils;
import com.cmp.pojo.CmpUser;
import com.cmp.service.CmpUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;

/**
 * CmpUser控制层
 * 要确保数据合法性；例如是数字类型的变量，不能接受不可强转为数字的字符串
 */
@RestController
public class CmpUserController {
    @Autowired
    private CmpUserService cmpUserService;

    /**
     * 自动注册
     * @param request
     * @param response
     */
    @PostMapping(value = "/user/register")
    public Result<String> register(HttpServletRequest request , HttpServletResponse response){
        Result<String> result = new Result<>(200 , "测试" ,null);

        String openid = request.getParameter("openid").trim();
        String nickname = request.getParameter("nickname").trim();
        int sex;
        String province = request.getParameter("province").trim();
        String city = request.getParameter("city").trim();
        String country = request.getParameter("country").trim();
        String headimgurl = request.getParameter("headimgurl").trim();
        int subscribe;
        int groupid;
        //类型强转
        try{
            sex = Integer.parseInt(request.getParameter("sex").trim());
            subscribe = Integer.parseInt(request.getParameter("subscribe").trim());
            groupid = Integer.parseInt(request.getParameter("groupid").trim());
        }catch(Exception e){
            result = new Result<String>(500,"输入有误",null);
            return result;
        }
        //不能为空的
        if("".equals(openid)){
            result = new Result<String>(400,"openid不能为空",null);
            return result;
        }
        if("".equals(nickname)){
            result = new Result<String>(400,"nickname不能为空",null);
            return result;
        }
        if("".equals(sex)){
            result = new Result<String>(400,"sex不能为空",null);
            return result;
        }

        //封装CmpUser对象
        CmpUser cmpUser = new CmpUser();
        cmpUser.setOpenid(openid);
        cmpUser.setSex(sex);
        cmpUser.setNickname(nickname);
        cmpUser.setSubscribe(subscribe);
        cmpUser.setGroupid(groupid);
        cmpUser.setProvince(province);
        cmpUser.setCity(city);
        cmpUser.setCountry(country);
        cmpUser.setHeadimgurl(headimgurl);

        int num = cmpUserService.insert(cmpUser);
        if(num >= 1){
            //成功执行
            SessionUtils.setSessionAttribute(request ,"openid" , openid);
            CookieUtils.setCookie(request , response ,"nickname" , nickname , 604800);
            result = new Result<String>(200,"成功注册",null);
            return result;
        }else{
            result = new Result<String>(500,"注册失败",null);
            return result;
        }
    }

}
