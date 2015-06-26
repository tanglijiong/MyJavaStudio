package com.xjj.db;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xjj.BaseJunit4Test;
import com.xjj.entity.Person;
import com.xjj.service.PersonService;

public class PersonCRUDTest extends BaseJunit4Test{

	@Autowired
	PersonService personService;
	
	@Test
	public void addNewPerson(){
		Person p = new Person();
		p.setFirstName("五");
		p.setLastName("王");
		p.setBirthDate(new Date());
		p.setSex('M');
		p.setPhoneNo("13625896321");
		
		personService.addPerson(p);
	}
	
	@Test
	public void updatePersonByPhoneNo(){
		Person p = new Person();
		p.setFirstName("七");
		p.setLastName("李");
		p.setBirthDate(new Date());
		p.setSex('F');
		p.setPhoneNo("13625896321");
		
		personService.updatePersonByPhoneNo(p);
	}
}
