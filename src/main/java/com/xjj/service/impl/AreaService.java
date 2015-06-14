package com.xjj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xjj.cache.local.ILocalCache;
import com.xjj.entity.Area;
import com.xjj.service.IAreaService;


@Service
public class AreaService implements IAreaService {
	@Resource(name="LCAreaIdToArea")
	ILocalCache<Integer, Area> lCAreaIdToArea;
	
	@Override
	public Area getAreaById(int areaId) {
		return lCAreaIdToArea.get(areaId);
	}

}
