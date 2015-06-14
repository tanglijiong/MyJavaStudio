package com.xjj.cache.local.impl;

import org.springframework.stereotype.Component;

import com.xjj.cache.guava.GuavaAbstractLoadingCache;
import com.xjj.cache.local.ILocalCache;
import com.xjj.constants.AreaType;
import com.xjj.entity.Area;

/**
 * 本地缓存：areaId -> Area
 * @author XuJijun
 *
 */
@Component
public class LCAreaIdToArea extends GuavaAbstractLoadingCache<Integer, Area> implements ILocalCache<Integer, Area> {
	//@Autowired
	//private AreasDAO areasDAO;
	
	//由Spring来维持单例模式
	
	private LCAreaIdToArea(){
		setMaximumSize(3000); //最大缓存条数
	}
	
	@Override
	public Area get(Integer key) {
		try {
			return getValue(key);
		} catch (Exception e) {
			logger.error("无法根据areaId={}获取Area，可能是数据库中无该记录。", key ,e);
			return null;
		}
	}

	/**
	 * 从数据库中获取数据
	 */
	@Override
	protected Area fetchData(Integer key) {
		logger.debug("测试：正在从数据库中获取area，area id={}", key);
		//return areasDAO.getAreaById(key);
		//测试专用，实际项目使用areaDao从数据库中获取数据
		Area a = new Area();
		a.setCode(key);
		a.setId(key);
		a.setName("地区："+key);
		a.setParentCode(Integer.valueOf(key.toString().substring(0, key.toString().length()-3)));
		a.setPinyin("pinyin:"+key);
		a.setType(AreaType.CITY.getValue());
		
		return a;
	}
}
