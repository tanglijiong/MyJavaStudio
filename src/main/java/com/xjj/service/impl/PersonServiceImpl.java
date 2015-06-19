package com.xjj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjj.dao.PersonDao;
import com.xjj.entity.Person;
import com.xjj.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;
	
	@Override
	public boolean addPerson(Person person) {
		
		return personDao.insertPerson(person)>0 ? true : false;
	}

}
