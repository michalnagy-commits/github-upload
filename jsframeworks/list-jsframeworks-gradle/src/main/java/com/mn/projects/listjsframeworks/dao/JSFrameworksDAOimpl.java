package com.mn.projects.listjsframeworks.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mn.projects.listjsframeworks.entity.JSFrameworks;



@Repository
public class JSFrameworksDAOimpl implements JSFrameworksDAO {
	
	// define field for entitymanager	
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public JSFrameworksDAOimpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}

	@Override	
	public List<JSFrameworks> findAll() {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		Query<JSFrameworks> theQuery = 
			currentSession.createQuery("from JSFrameworks", JSFrameworks.class);
		
		// execute query and get result list
		List<JSFrameworks>jsFrameworks = theQuery.getResultList();
		
		// return the results		
		return jsFrameworks;
	}

	@Override
	public JSFrameworks findById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);		
		
		// get the jsframeworks
		JSFrameworks theJSFrameworks =
				currentSession.get(JSFrameworks.class, theId);
		
		// return jsframeworks		
		return theJSFrameworks;
	}
	
	@Override
	public List<JSFrameworks> findByNazev(String theNazev) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
		Query<JSFrameworks>theQuery =
				currentSession.createQuery(
					"from JSFrameworks where nazev=:jsFrameworksNazev", JSFrameworks.class);
		
		theQuery.setParameter("jsFrameworksNazev", theNazev);
		
		// execute query and get result list
		List<JSFrameworks>jsFrameworks = theQuery.getResultList();		
				
		// return jsframeworks		
		return jsFrameworks;
	}

	@Override
	public void save(JSFrameworks theJSFrameworks) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// save jsframeworks
		currentSession.saveOrUpdate(theJSFrameworks);
		
	}

	@Override
	public void deleteById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		Query<?> theQuery = 
				currentSession.createQuery(
						"delete from JSFrameworks where id=:jsFrameworksId");
		
		theQuery.setParameter("jsFrameworksId", theId);
		
		theQuery.executeUpdate();
		
	}

}
