//package com.qa.emailapplication.dto;
//
//import static org.junit.Assert.assertEquals;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.qa.emailapplication.domain.Email;
//import com.qa.emailapplication.repo.EmailRepo;
//import com.qa.emailapplication.service.EmailService;
//
//@RunWith(MockitoJUnitRunner.class)
//
//public class EmailDTOTest {
//	
//	@Mock
//	private EmailRepo repo;
//	
//	@Mock
//	private EmailDTO dto;
//
//	@InjectMocks
//	private EmailService service;
//	
//	@Test
//	public void createDTOTest() {
//
//		Email toCreate = new Email(0, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");
//		EmailDTO created = new EmailDTO();
//
//		Mockito.when(this.repo.save(toCreate)).thenReturn(created);
//
//		assertEquals(created, this.service.create(toCreate));
//
//		Mockito.verify(this.repo, Mockito.times(1)).save(toCreate);
//	}
//
//}
