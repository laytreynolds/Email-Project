package com.qa.emailapplication;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class EmailServiceTest {
	
	@Autowired
	private EmailService service;
	
	@MockBean
	private EmailRepo repo;
	
	@Test
	void createTest() {
		
		 Email toCreate = new Email(0, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");
	     Email created = new Email(1L, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");
		
	     Mockito.when(this.repo.save(toCreate)).thenReturn(created);
	     
         Assertions.assertThat(this.service.create(toCreate)).isEqualTo(created);
         
         Mockito.verify(this.repo, Mockito.times(1)).save(toCreate);

	
	}
	
	 @Test
	  void readTest() {


	        Long id = 1L;
	        Email testEmail = new Email(id, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");
	        
	        testEmail.setId(id);
	        
	        List<Email> email = List.of(testEmail);

	        
	        Mockito.when(this.repo.findAll()).thenReturn(email);

	        Assertions.assertThat(this.service.readAll()).isEqualTo(email);

	        Mockito.verify(this.repo, Mockito.times(1)).findAll();

	 }
	 
	 @Test
	 void testReadById() {
		 
		 // GIVEN
		 Long id = 1L;
		 Email expected = new Email(id, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");
		 
		 // WHEN
		 Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(expected));
		 
		 // THEN
		 Assertions.assertThat(this.service.read(id)).isEqualTo(expected);
		 
		 // verify
		 Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	 }
	 
	 
//	 @Test
//	    void testDelete() {
//
//
//	        Long id = 1L;
//
//	        Mockito.when(this.repo.deleteById(id)).thenReturn(!this.repo.existsById(id));
//
//	        Assertions.assertThat(this.service.delete(id)).isTrue();
//
//	        Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
//
//	    }
	 
	 
	
	

}
