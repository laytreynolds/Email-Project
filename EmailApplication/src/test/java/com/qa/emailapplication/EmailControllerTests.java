package com.qa.emailapplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
//	@Test
//	public void readTest() throws Exception {
//		
//		Long id = 1L;
//		
//		Email testEmail = new Email(id, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");
//		
//		testEmail.setId(id);
//		
//		List<Email> email = List.of(testEmail);
//
//		Mockito.when(this.service.readAll()).thenReturn(email);
//		
//		mvc.perform(get("/user/read")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(testEmail)).andExpect(status().isOk())
//				.andExpect(content().json(entryAsJSON));
//		
//		
//	}
	
	
	
	
	

}
