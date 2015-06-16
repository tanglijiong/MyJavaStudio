package com.xjj.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xjj.cache.guava.GuavaCacheManager;
import com.xjj.json.JsonResult;
import com.xjj.json.PageParams;
import com.xjj.json.PageResult;

/**
 * 本地缓存管理接口：统计信息查询、重置数据……等
 * @author XuJijun
 *
 */
@RestController
@RequestMapping("/cache/admin")
public class CacheAdminController {
	
	/**
	 * 查询cache统计信息
	 * @param cacheName
	 * @return cache统计信息
	 */
	@RequestMapping(value = "/stats", method = RequestMethod.POST)
	public JsonResult cacheStats(String cacheName) {
		JsonResult jsonResult = new JsonResult();
		
		//暂时只支持获取全部
		
		switch (cacheName) {
		case "*":
			jsonResult.setData(GuavaCacheManager.getAllCacheStats());
			jsonResult.setMessage("成功获取了所有的cache！");
			break;

		default:
			break;
		}
		
		return jsonResult;
	}
	
	/**
	 * 清空缓存数据、并返回清空后的统计信息
	 * @param cacheName
	 * @return
	 */
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public JsonResult cacheReset(String cacheName) {
		JsonResult jsonResult = new JsonResult();
		
		GuavaCacheManager.resetCache(cacheName);
		jsonResult.setMessage("已经成功重置了" + cacheName + "！");
	
		return jsonResult;
	}
	
	/**
	 * 返回所有的本地缓存统计信息
	 * @return
	 */
	@RequestMapping(value = "/stats/all", method = RequestMethod.POST)
	public JsonResult cacheStatsAll() {
		return cacheStats("*");
	}
	
	/**
	 * 分页查询数据详情
	 * @param pageSize
	 * @param pageNo
	 * @param cacheName
	 * @return
	 */
	@RequestMapping(value = "/queryDataByPage", method = RequestMethod.POST)
	public PageResult<Object> queryDataByPage(@RequestParam Map<String, String> params){
		int pageSize = Integer.valueOf(params.get("pageSize"));
		int pageNo = Integer.valueOf(params.get("pageNo"));
		String cacheName = params.get("cacheName");
		
		PageParams<Object> page = new PageParams<>();
		page.setPageSize(pageSize);
		page.setPageNo(pageNo);
		Map<String, Object> param = new HashMap<>();
		param.put("cacheName", cacheName);
		page.setParams(param);
		
		return GuavaCacheManager.queryDataByPage(page);
	}
}
