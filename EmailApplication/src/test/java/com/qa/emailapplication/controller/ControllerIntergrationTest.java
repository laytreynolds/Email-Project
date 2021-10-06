package com.qa.emailapplication.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.context.ActiveProfiles;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.emailapplication.domain.Email;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class ControllerIntergrationTest {

		@Autowired
		private MockMvc mvc;
		
		@Autowired
		private ObjectMapper mapper;
		
		@Test
		public void createTest() throws Exception {
			
			Email entry = new Email(0, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");
			Email output = new Email(2L, "Layt", "Reynolds", "0123456789", "Sales"  , "layton.reynolds");
			
			String entryAsJSON = this.mapper.writeValueAsString(entry);
			String outputAsJSON = this.mapper.writeValueAsString(output);
			
			mvc.perform(post("/user/create")
					.contentType(MediaType.APPLICATION_JSON)
					.content(entryAsJSON))
					.andExpect(status().isCreated())
					.andExpect(content().json(outputAsJSON));	
		}
		
	
		
		
}


