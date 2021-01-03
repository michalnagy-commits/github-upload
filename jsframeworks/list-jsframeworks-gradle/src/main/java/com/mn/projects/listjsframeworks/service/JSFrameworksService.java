package com.mn.projects.listjsframeworks.service;

import java.util.List;

import com.mn.projects.listjsframeworks.entity.JSFrameworks;


public interface JSFrameworksService {

	public List<JSFrameworks>findAll();
	
	public JSFrameworks findById(int theId);
	
	public List<JSFrameworks> findByNazev(String theNazev);
	
	public void save(JSFrameworks theJSFrameworks);
	
	public void deleteById(int theId);
}
