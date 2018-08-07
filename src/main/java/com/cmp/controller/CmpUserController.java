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
        Result<String> result;

        String openid = request.getParameter("openid").trim();
        String nickname = request.getParameter("nickname").trim();
        Byte sex;
        String province = request.getParameter("province").trim();
        String city = request.getParameter("city").trim();
        String country = request.getParameter("country").trim();
        String headimgurl = request.getParameter("headimgurl").trim();
        Byte subscribe;
        Long groupid;
        //类型强转
        try{
            sex = Byte.parseByte(request.getParameter("sex").trim());
            subscribe = Byte.parseByte(request.getParameter("subscribe").trim());
            groupid = Long.parseLong(request.getParameter("groupid").trim());
        }catch(Exception e){
            result = new Result<String>(400,"输入有误",null);
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
            result = new Result<String>(200,"OK",null);
            return result;
        }else{
            result = new Result<String>(400,"手机号或者微信号重复",null);
            return result;
        }
    }

    /**
     * 根据微信号和密码登录
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/user/login_wx")
    public Result<String> login_wx(HttpServletRequest request , HttpServletResponse response){
    	Result<String> result;
    	String wx = request.getParameter("wx").trim();
    	String password = request.getParameter("password").trim();
    	if(wx.isEmpty() || password.isEmpty()){
            result = new Result<String>(400,"账户或者密码不能为空",null);
            return result;
        }
    	CmpUser user = cmpUserService.loginByWx(wx, password);
    	if(user != null) {
    		 SessionUtils.setSessionAttribute(request ,"openid" , user.getOpenid());
    	     CookieUtils.setCookie(request , response ,"nickname" , user.getNickname() , 604800);
    	     result = new Result<String>(200,"OK",null);
    	     return result;
    	}else{
    		result = new Result<String>(400,"账户或者密码错误",null);
    		return result;
    	}
    }

    /**
     * 根据手机号和密码登录
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/user/login_phone")
    public Result<String> login_phone(HttpServletRequest request , HttpServletResponse response){
    	Result<String> result;
    	String phone = request.getParameter("phone").trim();
    	String password = request.getParameter("password").trim();
    	if(phone.isEmpty() || password.isEmpty()){
            result = new Result<String>(400,"账户或者密码不能为空",null);
            return result;
        }
    	CmpUser user = cmpUserService.loginByPhone(phone, password);

    	if(user != null) {
    		 SessionUtils.setSessionAttribute(request ,"openid" , user.getOpenid());
    	     CookieUtils.setCookie(request , response ,"nickname" , user.getNickname() , 604800);
    	     result = new Result<String>(200,"OK",null);
    	     return result;
    	}else{
    		result = new Result<String>(400,"账户或者密码错误",null);
    		return result;
    	}
    }

    /**
     * 根据手机号查询用户
     * @param request
     * @param response
     * @return Result<CmpUser>
     */
    @GetMapping("/user/findinfo_phone")
    public Result<CmpUser> findinfo_phone(HttpServletRequest request , HttpServletResponse response){
    	Result<CmpUser> result;
    	String phone = request.getParameter("phone").trim();
    	if(phone.isEmpty()){
            result = new Result<CmpUser>(400,"手机号不能为空",null);
            return result;
        }
    	CmpUser user = cmpUserService.selectByPhone(phone);
    	if(user != null) {
    		result = new Result<CmpUser>(200,"OK",user);
    	    return result;
    	}else{
    		result = new Result<CmpUser>(400,"用户未找到",null);
    		return result;
    	}
    }

    /**
     * 根据openid查询用户
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/user/findinfo_openid")
    public Result<CmpUser> findinfo_openid(HttpServletRequest request , HttpServletResponse response){
    	Result<CmpUser> result;
    	String openid = request.getParameter("openid").trim();
    	if("".equals(openid)) {
    		result = new Result<CmpUser>(400 , "openid不能为空" ,null);
    		return result;
    	}
    	CmpUser user = cmpUserService.selectByOpenid(openid);
    	if(user!=null) {
    		result = new Result<CmpUser>(200,"OK",user);
    	    return result;
    	}else{
    		result = new Result<CmpUser>(400,"用户未找到",null);
    		return result;
    	}
    }

    /**
     * 根据微信号查询用户
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/user/findinfo_wx")
    public Result<CmpUser> findinfo_wx(HttpServletRequest request , HttpServletResponse response){
    	Result<CmpUser> result;
    	String wx = request.getParameter("wx").trim();
    	if(wx.isEmpty()){
            result = new Result<CmpUser>(400,"微信号不能为空",null);
            return result;
        }
    	CmpUser user = cmpUserService.selectByWx(wx);
    	if(user!=null) {
    		result = new Result<CmpUser>(200,"OK",user);
    	    return result;
    	}else{
    		result = new Result<CmpUser>(400,"用户未找到",null);
    		return result;
    	}
    }

    /**
     * 更新用户信息
     * @param request
     * @param response
     * @return
     */
    @PostMapping("user/set_detail")
    public Result<String> set_detail(HttpServletRequest request , HttpServletResponse response){
        Result<String> result = new Result<>(200 , "测试" ,null);
        String phone = request.getParameter("phone").trim();
        String school = request.getParameter("school").trim();
        String code = request.getParameter("code").trim();
        String province = request.getParameter("province").trim();
        String city = request.getParameter("city").trim();
        String country = request.getParameter("country").trim();
        String address = request.getParameter("address").trim();
        String wx = request.getParameter("wx").trim();
        Byte sex;
        //类型强转
        try{
            sex = Byte.parseByte(request.getParameter("sex").trim());
        }catch(Exception e){
            result = new Result<String>(400,"输入有误",null);
            return result;
        }
        //不能为空的
        if("".equals(sex)){
            result = new Result<String>(400,"sex不能为空",null);
            return result;
        }
        //封装CmpUser对象
        CmpUser cmpUser = new CmpUser();
        cmpUser.setPhone(phone);
        cmpUser.setSchool(school);;
        cmpUser.setSex(sex);
        cmpUser.setProvince(province);
        cmpUser.setCity(city);
        cmpUser.setCountry(country);
        cmpUser.setAddress(address);
        cmpUser.setProvince(province);
        cmpUser.setCity(city);
        cmpUser.setWx(wx);

        int num = cmpUserService.update(cmpUser);
        if(num >= 1){
            //成功执行
            result = new Result<String>(200,"OK",null);
            return result;
        }else{
            result = new Result<String>(400,"设置信息异常",null);
            return result;
        }
    }

    /**
     * 用户更新密码
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/user/set_password")
    public Result<String> set_password(HttpServletRequest request , HttpServletResponse response){
    	Result<String> result;
    	String code = request.getParameter("code").trim();
    	String password = request.getParameter("password").trim();
        String phone = request.getParameter("phone").trim();
        if(code.isEmpty() || password.isEmpty() || phone.isEmpty()){
            result = new Result<String>(400,"信息异常",null);
            return result;
        }
    	int num = cmpUserService.updatePassword(phone, password);

    	if(num >= 1) {
            //成功执行
            result = new Result<String>(200,"OK",null);
            return result;
        }else{
            result = new Result<String>(400,"设置信息异常",null);
            return result;
        }

    }


}
