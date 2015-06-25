package com.xjj.dao;

import com.xjj.annotation.DbTest;
import com.xjj.entity.Person;

@DbTest
public interface PersonDao {

	public int insertPerson(Person person);
	
	public Person selectPersonForUpdate(int id);
	
	public int updatePersonById(Person person, int id);

	public int updatePersonByPhoneNo(Person person);
}
