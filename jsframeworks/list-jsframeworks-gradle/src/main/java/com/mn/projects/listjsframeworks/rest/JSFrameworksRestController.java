package com.mn.projects.listjsframeworks.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mn.projects.listjsframeworks.entity.JSFrameworks;
import com.mn.projects.listjsframeworks.service.JSFrameworksService;



@RestController
@RequestMapping("/api")
public class JSFrameworksRestController {

	private JSFrameworksService jsFrameworksService;
		
	@Autowired
	public JSFrameworksRestController(JSFrameworksService theJSFrameworksService) {
		jsFrameworksService = theJSFrameworksService;
	}
	
	// expose "/JSFrameworks" and return list of JSFrameworks
	
	@GetMapping("/jsframeworks")
	public List<JSFrameworks> findAll(){
		return jsFrameworksService.findAll();
	}
	
	// add mapping for GET /jsframeworks/id/{jsframeworkId}
	
	@GetMapping("/jsframeworks/id/{jsFrameworkId}")
	public JSFrameworks getJSFramework(@PathVariable("jsFrameworkId") int jsFrameworkId ) {
		JSFrameworks theJSFrameworks = jsFrameworksService.findById(jsFrameworkId);
		
		if(theJSFrameworks==null) {
			throw new RuntimeException("JSFramework id not found - " + jsFrameworkId);
		}
		
		return theJSFrameworks;
	}
	
	// add mapping for GET /jsframeworks/{jsframeworksNazev}
	
	@GetMapping("/jsframeworks/{jsFrameworksNazev}")
	public List<JSFrameworks> getListJSFrameworks(@PathVariable("jsFrameworksNazev") String jsFrameworksNazev){
		List<JSFrameworks> theJSFrameworks = jsFrameworksService.findByNazev(jsFrameworksNazev);
		
		if(theJSFrameworks==null) {
			throw new RuntimeException("JSFramework nazev not found - " + jsFrameworksNazev);
		}
		
		return theJSFrameworks;
	}
	
	// add mapping for POST /jsframeworks
	
	@PostMapping("/jsframeworks")
	public JSFrameworks addJSFrameworks(@RequestBody JSFrameworks theJSFrameworks) {
						
		theJSFrameworks.setId(0);
		
		jsFrameworksService.save(theJSFrameworks);
		
		return theJSFrameworks;		
	}
	
	// add mapping for PUT /jsframeworks - update existing jsframework
	
	@PutMapping("/jsframeworks")
	public JSFrameworks updateJSFrameworks(@RequestBody JSFrameworks theJSFrameworks) {
	
		jsFrameworksService.save(theJSFrameworks);
		
		return theJSFrameworks;
		
	}
	
	// add mapping for DELETE /jsframeworks/{jsframeworkId} - delete jsframework
	
	@DeleteMapping("/jsframeworks/{jsFrameworkId}")
	public String deleteJSFramework(@PathVariable("jsFrameworkId") int jsFrameworkId) {
		
		JSFrameworks tempJSFrameworks = jsFrameworksService.findById(jsFrameworkId);
		
		// throw exeption if null
		if (tempJSFrameworks==null) {
			throw new RuntimeException("JSFramework id not found - " + jsFrameworkId );
		}
			
		jsFrameworksService.deleteById(jsFrameworkId);
		
		return "Deleted JSFramework id - " + jsFrameworkId;
	}
			
}
