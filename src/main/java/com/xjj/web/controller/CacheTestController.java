package com.xjj.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xjj.entity.Area;
import com.xjj.json.JsonResult;
import com.xjj.service.AreaService;

/**
 * 测试用Map接收参数
 * @author XuJijun
 *
 */
@RestController
@RequestMapping(value = "/cache/test/")
public class CacheTestController {
	@Autowired
	AreaService areaService;
	
	/**
	 * 根据AreaId获得一个Area
	 * @param areaId
	 * @return Area
	 */
	@RequestMapping(value = "getArea")
	public JsonResult getArea(Integer areaId) {
		JsonResult jr = new JsonResult();
		Area a = areaService.getAreaById(areaId);
		jr.setData(a);
		return jr;
	}

}
