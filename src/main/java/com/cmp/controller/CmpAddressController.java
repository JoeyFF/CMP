
package com.cmp.controller;

import com.cmp.common.pojo.Result;
import com.cmp.common.utils.SessionUtils;
import com.cmp.pojo.CmpAddress;
import com.cmp.service.CmpAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author zdb
 */
@RestController
@RequestMapping("/user")
public class CmpAddressController {

    @Autowired
    CmpAddressService cmpAddressService;

    /**
     * POST方法添加收获地址
     * @param request
     * @param response
     * @return Result<String>
     */
    @RequestMapping(value = "/add_address", method = RequestMethod.POST)
    public Result<String> add_address(HttpServletRequest request, HttpServletResponse response) {
        Result<String> result;
        String openid = (String)SessionUtils.getSessionAttribute(request, "openid");
        if (openid == null) {
            result = Result.Error("尚未登陆");
            return result;
        }
        /**
         * 从request中取出传过来的收货地址，将其中的参数取出进行封装
         */
        String name = request.getParameter("name").trim();
        String phone = request.getParameter("phone").trim();
        String province = request.getParameter("province").trim();
        String city = request.getParameter("city").trim();
        String country = request.getParameter("city").trim();
        Integer type = null;
        /**
         * 对收获地址类型进行判断，确保返回整形，通过异常捕捉进行判断
         */
        try {
            type = Integer.parseInt(request.getParameter("type").trim());
        } catch (Exception e) {
            result = Result.Error("收货地址类型错误");
            return result;
        }

        /**
         * 判断字段是否为空
         */
        if ("".equals(name)) {
            result = Result.Error("name不能为空");
            return result;
        }
        if ("".equals(phone)) {
            result = Result.Error("phone不能为空");
            return result;
        }
        if ("".equals(province)) {
            result = Result.Error("province不能为空");
            return result;
        }
        if ("".equals(city)) {
            result = Result.Error("city不能为空");
            return result;
        }
        if ("".equals(country)) {
            result = Result.Error("country不能为空");
            return result;
        }
        if (type == null) {
            result = Result.Error("type不能为空");
            return result;
        }

        /**
         * 封装收获地址
         */
        CmpAddress cmpAddress = new CmpAddress();
        cmpAddress.setName(name);
        cmpAddress.setPhone(phone);
        cmpAddress.setProvince(province);
        cmpAddress.setCity(city);
        cmpAddress.setCountry(country);
        cmpAddress.setType(type);
        cmpAddress.setOpenid(openid);

        /**
         * 将收获地址进行持久化存储
         */
        int resultCount = cmpAddressService.insertAddress(cmpAddress);
        if (resultCount <= 0) {
            result = Result.Error("设置信息异常");
            return result;
        }
        result = Result.Success("OK");
        return result;
    }

/*-----------------------------------------------------------------------------------------*/


    /**
     * POST方法删除收获地址，根据openid和id进行删除
     * @param request
     * @param response
     * @return Result<String>
     */
    @RequestMapping(value = "/del_address", method = RequestMethod.POST)
    public Result<String> del_address(HttpServletRequest request, HttpServletResponse response) {

        Result<String> result;

        /**
         * 从session中获取openid
         */
        String id = request.getParameter("id");
        String openid = (String)SessionUtils.getSessionAttribute(request, "openid");
        /**
         * 确保已经登陆才进行地址的删除
         * 用session的getAttribute方法返回的是Object，用以判断用null进行判断
         */
        if (openid == null) {
            result = Result.Error("尚未登陆");
            return result;
        }
        int resultCount = cmpAddressService.delAddress(openid, id);
        /**
         * 服务器端插入数据异常
         */
        if (resultCount <= 0) {
            result = Result.Error("设置信息异常");
            return result;
        }
        result = Result.Success("OK");
        return result;
    }

/*------------------------------------------------------------------------------------------*/

    /**
     * 更新收获地址
     * @param request
     * @param response
     * @return Result<String>
     */
    @RequestMapping(value = "/update_address", method = RequestMethod.POST)
    public Result<String> update_address(HttpServletRequest request, HttpServletResponse response) {

        Result<String> result;
        String openid = (String)SessionUtils.getSessionAttribute(request, "openid");
        if (openid == null) {
            result = Result.Error("尚未登陆");
            return result;
        }
        /**
         * 从request中取出传过来的收货地址，将其中的参数取出进行封装
         */
        String name = request.getParameter("name").trim();
        String phone = request.getParameter("phone").trim();
        String province = request.getParameter("province").trim();
        String city = request.getParameter("city").trim();
        String country = request.getParameter("city").trim();
        Integer type = null;
        /**
         * 对收获地址类型进行判断，确保返回整形，通过异常捕捉进行判断
         */
        try {
            type = Integer.parseInt(request.getParameter("type").trim());
        } catch (Exception e) {
            result = Result.Error("收货地址类型错误");
            return result;
        }

        /**
         * 判断字段是否为空
         */
        if ("".equals(name)) {
            result = Result.Error("name不能为空");
            return result;
        }
        if ("".equals(phone)) {
            result = Result.Error("phone不能为空");
            return result;
        }
        if ("".equals(province)) {
            result = Result.Error("province不能为空");
            return result;
        }
        if ("".equals(city)) {
            result = Result.Error("city不能为空");
            return result;
        }
        if ("".equals(country)) {
            result = Result.Error("country不能为空");
            return result;
        }
        if (type == null) {
            result = Result.Error("type不能为空");
            return result;
        }

        /**
         * 封装收获地址
         */
        CmpAddress cmpAddress = new CmpAddress();
        cmpAddress.setName(name);
        cmpAddress.setPhone(phone);
        cmpAddress.setProvince(province);
        cmpAddress.setCity(city);
        cmpAddress.setCountry(country);
        cmpAddress.setType(type);
        cmpAddress.setOpenid(openid);

        int resultCount = cmpAddressService.updateAddress(cmpAddress);
        if (resultCount <= 0) {
            result = Result.Error("设置信息异常");
        }
        result = Result.Success("OK");
        return result;
    }


/*--------------------------------------------------------------------------------------------*/

    /**
     * 返回所有收货地址
     * @param request
     * @return Result<String>
     */
    @RequestMapping(value = "/get_address", method = RequestMethod.POST)
    public Result<List<CmpAddress>> get_address(HttpServletRequest request) {
        Result<List<CmpAddress>> result;
        String openid = (String)SessionUtils.getSessionAttribute(request, "openid");
        if (openid == null) {
            result = Result.Error("尚未登陆");
            return result;
        }

        List<CmpAddress> resultList = cmpAddressService.selectAddress(openid);
        result = new Result<List<CmpAddress>>(200, "OK", resultList);
        return result;
    }

/*-------------------------------------------------------------------------------------------------*/

    /**
     * 查看指定id的收货地址
     * @param request
     * @param response
     * @return Result<String>
     */
    @RequestMapping(value = "/get_address", method = RequestMethod.GET)
    public Result<CmpAddress> get_address(HttpServletRequest request, HttpServletResponse response) {
        Result<CmpAddress> result;
        String openid = (String)SessionUtils.getSessionAttribute(request, "openid");
        if (openid == null) {
            result = Result.Error("尚未登陆");
            return result;
        }
        String id = request.getParameter("id");
        if ("".equals(id)) {
            result = Result.Error("id不能为空");
            return result;
        }
        CmpAddress cmpAddress = cmpAddressService.selectOneAddress(openid, id);
        result = new Result<CmpAddress>(200, "OK", cmpAddress);
        return result;
    }
}