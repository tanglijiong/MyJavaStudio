package com.xjj.service;

import com.xjj.entity.Area;

/**
 * Area相关方法，使用缓存
 * @author XuJijun
 *
 */
public interface AreaService {
	/**
	 * 根据areaId获取Area
	 * @param areaId
	 * @return Area
	 */
	public Area getAreaById(int areaId);

}
