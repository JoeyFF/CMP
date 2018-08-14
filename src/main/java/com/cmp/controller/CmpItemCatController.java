package com.cmp.controller;

import com.cmp.common.pojo.Result;
import com.cmp.pojo.CmpItemCat;
import com.cmp.service.CmpItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
/**
 * @author 11048
 *
 */

@RestController
public class CmpItemCatController {
	
	@Autowired
	private CmpItemCatService cmpItemCatService;
	
	/**
	 * 添加商品种类
	 * @param request
	 * @param response
	 * @return
	 */
	@PostMapping(value="/item/insert_itemCat")
	public Result insert_itemCat(HttpServletRequest request , HttpServletResponse response){
		Result result = null;
		Long parentId = null;
		Boolean isParent = null;
		String name = request.getParameter("parentId").trim();
		//类型转换
		try {
			parentId = Long.parseLong(request.getParameter("parentId").trim());
			isParent = Boolean.parseBoolean(request.getParameter("isParent").trim());
		}catch(Exception e) {
			result = Result.Error("输入有误");
			return result;
		}
		//判断是否为空
		if("".equals(name)) {
			result = Result.Error("类目名称不能为空");
			return result;
		}
		if(parentId == null) {
			result = Result.Error("parentId不能为空");
			return result;
		}
		if(isParent == null) {
			result = Result.Error("isParent不能为空");
			return result;
		}
		//封装CmpItemCat
		CmpItemCat cmpItemCat = new CmpItemCat();
		cmpItemCat.setParentId(parentId);
		cmpItemCat.setIsParent(isParent);
		cmpItemCat.setName(name);
		int num = cmpItemCatService.insertItemCat(cmpItemCat);
		if(num>=1) {
			result = Result.Success();
			return result;
		}else {
			result = Result.Error("设置信息异常");
			return result;
		}
	}
	
	/**
	 * 查询商品种类
	 */
	@PostMapping(value="/item/get_itemCat")
	public Result<List<CmpItemCat>> get_itemCat(HttpServletRequest request , HttpServletResponse response){
		Result<List<CmpItemCat>> result = null;
		List<CmpItemCat> list = new ArrayList<CmpItemCat>();
		String type = request.getParameter("type").trim();
		Long id = null;
		Long parentId = null;
		//type=1,查询指定id的商品种类,否则查询parentId=xx的商品类目
		if("1".equals(type)) {
			try {
				id = Long.parseLong(request.getParameter("id").trim());
			}catch(Exception e) {
				result = new Result<List<CmpItemCat>>(400,"商品种类出错",null);
				return result;
			}
			if(id == null) {
				result = new Result<List<CmpItemCat>>(400,"id不能为空",null);
				return result;
			}
			CmpItemCat cmpItemCat = cmpItemCatService.selectOneItemCat(id);
			list.add(cmpItemCat);
			result = new Result<List<CmpItemCat>>(200,"成功",list);
			return result;
			
		}else {
			try {
				parentId = Long.parseLong(request.getParameter("parentId").trim());
			}catch(Exception e) {
				result = new Result<List<CmpItemCat>>(400,"商品种类出错",null);
				return result;
			}
			if(parentId == null) {
				result = new Result<List<CmpItemCat>>(400,"parentId不能为空",null);
				return result;
			}
			list = cmpItemCatService.selectItemCat(parentId);
			result = new Result<List<CmpItemCat>>(200,"成功",list);
			return result;
			
		}
	
	}		
	
	/**
	 * 更改商品类目
	 */
	@PostMapping(value="/item/update_itemcat")
	public Result update_itemcat(HttpServletRequest request , HttpServletResponse response){
		Result result = null;
		Long id = null;
		Long parentId = null;
		Boolean isParent = null;
		String name = request.getParameter("name").trim();
		try {
			parentId = Long.parseLong(request.getParameter("parentId").trim());
			id = Long.parseLong(request.getParameter("id").trim());
			isParent = Boolean.parseBoolean(request.getParameter("isParent").trim());
		}catch(Exception e) {
			result = Result.Error("输入有误");
		}
		//判断是否为空
		if("".equals(name)) {
			result = Result.Error("类目名称不能为空");
			return result;
		}
		if(parentId == null) {
			result = Result.Error("parentId不能为空");
			return result;
		}
		if(isParent == null) {
			result = Result.Error("isParent不能为空");
			return result;
		}
		if(id == null) {
			result = Result.Error("id不能为空");
			return result;
		}
		CmpItemCat cmpItemCat = new CmpItemCat();
		cmpItemCat.setId(id);
		cmpItemCat.setParentId(parentId);
		cmpItemCat.setIsParent(isParent);
		cmpItemCat.setName(name);
		int num = cmpItemCatService.updateItemCat(cmpItemCat);
		if(num>=1) {
			result = Result.Success();
			return result;
		}else {
			result = Result.Error("设置信息异常");
			return result;
		}
	}


}
