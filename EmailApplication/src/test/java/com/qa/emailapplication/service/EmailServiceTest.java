package com.qa.emailapplication.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.emailapplication.domain.Email;
import com.qa.emailapplication.repo.EmailRepo;

@RunWith(MockitoJUnitRunner.class)
public class EmailServiceTest {

	@Mock
	private EmailRepo repo;
	
	@InjectMocks
	private EmailService service;


	@Test
	public void createTest() {

		Email toCreate = new Email(0, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");
		Email created = new Email(1L, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");

		Mockito.when(this.repo.save(toCreate)).thenReturn(created);

		assertEquals(created, this.service.create(toCreate));

		Mockito.verify(this.repo, Mockito.times(1)).save(toCreate);
	}

	@Test
	public void readTest() {

		Long id = 1L;
		Email testEmail = new Email(id, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");

		testEmail.setId(id);

		List<Email> email = List.of(testEmail);

		Mockito.when(this.repo.findAll()).thenReturn(email);

		assertThat(this.service.readAll()).isEqualTo(email);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void testReadById() {

		Long id = 1L;
		Email expected = new Email(id, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(expected));

		assertThat(this.service.read(id)).isEqualTo(expected);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}

	@Test
	public void testUpdate() {

		Long id = 1L;
		Email newValues = new Email(0, "Mike", "Michaels", "1123456789", "Accounting", "mike.michaels");

		Email existing = new Email(id, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");

		Email updated = new Email(id, newValues.getFirstName(), newValues.getLastName(), newValues.getPassword(),
				newValues.getDepartment(), newValues.getEmail());

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(existing));

		Mockito.when(this.repo.save(updated)).thenReturn(updated);

		assertThat(this.service.update(id, newValues)).isEqualTo(updated);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
		Mockito.verify(this.repo, Mockito.times(1)).save(updated);

	}

	@Test
	public void testDelete() {

		Long id = 1L;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.delete(id)).isTrue();

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

}
