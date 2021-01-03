package com.mn.projects.listjsframeworks.dao;

import java.util.List;

import com.mn.projects.listjsframeworks.entity.JSFrameworks;



public interface JSFrameworksDAO {

	public List<JSFrameworks> findAll();	
		
	public JSFrameworks findById(int theId);
	
	public List<JSFrameworks> findByNazev(String theNazev);
	
	public void save(JSFrameworks theJSFrameworks);
	
	public void deleteById(int theId);
	
}
