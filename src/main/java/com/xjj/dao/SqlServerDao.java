package com.xjj.dao;

import org.apache.ibatis.annotations.Select;

import com.xjj.annotation.SqlServerDb;
import com.xjj.entity.SqlServerTb;

@SqlServerDb
public interface SqlServerDao {
	@Select("SELECT cVCRID,cVTYPE,cVCRETR FROM _tpVSA where cVCRID=#{id}")
	public SqlServerTb selectSample(String id);

}
