package com.mn.projects.listjsframeworks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.mn.projects.listjsframeworks.entity.JSFrameworks;
import com.mn.projects.listjsframeworks.rest.JSFrameworksRestController;
import com.mn.projects.listjsframeworks.service.JSFrameworksServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class JSFrameworksRestControllerTest {
	
	@InjectMocks
	JSFrameworksRestController jsFrameworkRestController;	
		
	@Mock
	JSFrameworksServiceImpl jsFrameworksServiceImpl;	
	
	@Test
	public void testFindAll() {
		
		// test data		
		JSFrameworks jsFrameworks1 = new JSFrameworks("Angular","1.3","2027-10-20",1000);
		jsFrameworks1.setId(1);
				
		JSFrameworks jsFrameworks2 = new JSFrameworks("Rest","2.5","2030-01-01",100000);
		jsFrameworks2.setId(2);
				
		List<JSFrameworks> listJSFrameworks= new ArrayList<>();		
		listJSFrameworks.add(jsFrameworks1);
		listJSFrameworks.add(jsFrameworks2);		
				
		when(jsFrameworksServiceImpl.findAll()).thenReturn(listJSFrameworks);
		
		// when
		List<JSFrameworks> result = jsFrameworkRestController.findAll();		
		
		// then
		assertThat(result.size()).isEqualTo(2);
		
		assertThat(result.get(0).getNazev())
					.isEqualTo(jsFrameworks1.getNazev());
		
		assertThat(result.get(1).getNazev())
					.isEqualTo(jsFrameworks2.getNazev());		
		
	}
	
	@Test
	public void testFindById() {
		
		// test data		
		JSFrameworks jsFrameworks3 = new JSFrameworks("Vue","3.0","2030-01-01",10000);
		jsFrameworks3.setId(3);
				
		when(jsFrameworksServiceImpl.findById(3)).thenReturn(jsFrameworks3);
		
		// when
		JSFrameworks result = jsFrameworkRestController.getJSFramework(3);
				
		// then
		assertThat(result.getId()==3);	
		
		assertThat(result.getVersion())
				.isEqualTo(jsFrameworks3.getVersion());
		
	}
	
	@Test
	public void testFindByNazev() {
		
		// test data		
		JSFrameworks jsFrameworks0 = new JSFrameworks("Ember","2.0","2030-12-31",10000);
		jsFrameworks0.setId(1);
		
		JSFrameworks jsFrameworks1 = new JSFrameworks("Nuxt","1.0","2030-01-01",22000);
		jsFrameworks1.setId(2);
				
		JSFrameworks jsFrameworks2 = new JSFrameworks("Nuxt","2.0","2035-01-01",12000);
		jsFrameworks2.setId(3);
				
		List<JSFrameworks> listJSFrameworks= new ArrayList<>();		
		listJSFrameworks.add(jsFrameworks0);
		listJSFrameworks.add(jsFrameworks1);
		listJSFrameworks.add(jsFrameworks2);
		
		List<JSFrameworks>listJSFrameworks1= new ArrayList<>();
		listJSFrameworks1.add(jsFrameworks1);
		listJSFrameworks1.add(jsFrameworks2);
		
		when(jsFrameworksServiceImpl.findByNazev("Nuxt")).thenReturn(listJSFrameworks1);
		
		// when
		List<JSFrameworks> result = jsFrameworkRestController.getListJSFrameworks("Nuxt");
				
				
		// then
		assertThat(result.size()).isEqualTo(2);
		
		assertThat(result.get(0).getNazev())
					.isEqualTo(jsFrameworks1.getNazev());
		
		assertThat(result.get(1).getNazev())
		.isEqualTo(jsFrameworks1.getNazev());

	}
	
	@Test
	public void testSave() {
		        
        // test data 		
 		JSFrameworks jsFrameworks1 = new JSFrameworks("Svelte","1.0","2031-12-31",5000);
 		 		 		
 		// when
 		JSFrameworks result = jsFrameworkRestController.addJSFrameworks(jsFrameworks1);
 		
 		// then
 		assertThat(result.getId()).isEqualTo(0);
        
	}

}
