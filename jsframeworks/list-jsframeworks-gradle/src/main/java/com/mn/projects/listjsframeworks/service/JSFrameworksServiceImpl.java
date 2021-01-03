package com.mn.projects.listjsframeworks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mn.projects.listjsframeworks.dao.JSFrameworksDAO;
import com.mn.projects.listjsframeworks.entity.JSFrameworks;



@Service
public class JSFrameworksServiceImpl implements JSFrameworksService {
	
	private JSFrameworksDAO jsFrameworksDAO;
	
	@Autowired
	public JSFrameworksServiceImpl(JSFrameworksDAO theJSFrameworksDAO) {
		jsFrameworksDAO = theJSFrameworksDAO;
	}
	
	@Override
	@Transactional
	public List<JSFrameworks> findAll() {
		return jsFrameworksDAO.findAll();
	}

	@Override
	@Transactional
	public JSFrameworks findById(int theId) {
		return jsFrameworksDAO.findById(theId);
	}
	
	@Override
	@Transactional
	public List<JSFrameworks> findByNazev(String theNazev) {
		return jsFrameworksDAO.findByNazev(theNazev);
	}

	@Override
	@Transactional
	public void save(JSFrameworks theJSFrameworks) {
		jsFrameworksDAO.save(theJSFrameworks);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		jsFrameworksDAO.deleteById(theId);

	}	

}
