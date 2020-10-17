package com.example.CRUD.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CRUD.entity.CRUDentity;
import com.example.CRUD.repository.CRUDrepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service

public class CRUDservice {

	@Autowired
	CRUDrepository repository;
	

	public List<CRUDentity> getAllData() {
		return repository.getallData();
	}
	

	

	public Boolean saveData(CRUDentity data) {
	  CRUDentity temp= repository.save(data);
		  return true;
		
	}
	

	
	public CRUDentity getDatadefaultAction(Long id)
	{
		CRUDentity entity= new CRUDentity();
		entity.setAge(0);
		entity.setCurrentstatus("Default Value");
		entity.setDate("Default Value");
		entity.setDetectedcity("Default Value");
		entity.setDetectedstate("Default Value");
		entity.setName("Default Value");
		entity.setId(0L);
		
		return entity;
	}


	public Boolean editData(Long id, CRUDentity data) {
		Optional<CRUDentity> value=repository.findById(id);
		
	    data.setId(value.get().getId());
	    repository.save(data);
	    return true;	
		
	}
	




	public Boolean StoreDummyData(CRUDentity[] data) {
		List<CRUDentity> list=Arrays.asList(data);

		System.out.println("Hello"+list);
		repository.saveAll(list);
		return true;
	}
	
	


	
	

}
