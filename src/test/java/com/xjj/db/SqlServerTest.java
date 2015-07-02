package com.xjj.db;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjj.BaseJunit4Test;
import com.xjj.dao.SqlServerDao;
import com.xjj.entity.SqlServerTb;

public class SqlServerTest extends BaseJunit4Test{
	@Autowired
	SqlServerDao sqlServerDao;
	
	@Test
	public void getSample(){
		SqlServerTb selectSample = sqlServerDao.selectSample("SA00090427");
		System.out.println(selectSample);
	}

}
