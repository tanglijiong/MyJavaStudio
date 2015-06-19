package com.xjj.dao;

import com.xjj.annotation.DbTest;
import com.xjj.entity.Person;

@DbTest
public interface PersonDao {

	public int insertPerson(Person person);
}
