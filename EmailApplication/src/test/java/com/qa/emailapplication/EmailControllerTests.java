package com.qa.emailapplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
@RunWith(SpringRunner.class)
public class EmailControllerTests {
	
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@MockBean
	private EmailService service;
	
	@Test
	public void createTest() throws Exception {
		Email entry = new Email(0, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");
		
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		
		Mockito.when(this.service.create(entry)).thenReturn(entry);
		
		mvc.perform(post("/user/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON)).andExpect(status().isCreated())
				.andExpect(content().json(entryAsJSON));
		
		
		}
	
	@Test
	public void readTest() throws Exception {
		
		Long id = 1L;
		
		Email testEmail = new Email(id, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");
		
		List<Email> email = List.of(testEmail);
		
		String emailJSON = this.mapper.writeValueAsString(email);

		Mockito.when(this.service.readAll()).thenReturn(email);
		
		mvc.perform(get("/user/read")
				.contentType(MediaType.APPLICATION_JSON)
				.content(emailJSON)).andExpect(status().isOk())
				.andExpect(content().json(emailJSON));
	}

	
	@Test
	public void readIdTest() throws Exception {
		
		Long id = 1L;
		
		
		Email testEmail = new Email(id, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");
		
		testEmail.setId(id);
		
		String emailJSON = this.mapper.writeValueAsString(testEmail);
		
		Mockito.when(this.service.read(id)).thenReturn(testEmail);
		
		mvc.perform(get("/user/read/{id}", 1L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(emailJSON)).andExpect(status().isOk())
				.andExpect(content().json(emailJSON));
	}
	
	
	@Test
	public void updateTest() throws Exception {
		
		Long id = 2L;	
		
		Email newValues = new Email(id, "Mike", "Michaels", "1123456789", "Accounting", "mike.michaels");
		
		Email updated = new Email(id, newValues.getFirstName(), newValues.getLastName(), newValues.getPassword(),
				newValues.getDepartment(), newValues.getEmail());
		
		String updatedAsJSON = this.mapper.writeValueAsString(newValues);
		
		Mockito.when(this.service.update(id, newValues)).thenReturn(updated);
		
		
		mvc.perform(put("/user/update/{id}", 1L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(updatedAsJSON)).andExpect(status().isAccepted())
				.andExpect(content().json(updatedAsJSON));
	}
	

}
