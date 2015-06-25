package com.xjj.service;

import com.xjj.entity.Person;

public interface PersonService {
	
	/**
	 * 新增一个Person
	 * @param person
	 * @return 成功或失败
	 */
	public boolean addPerson(Person person);
	
	public boolean updatePersonByPhoneNo(Person person);
}
