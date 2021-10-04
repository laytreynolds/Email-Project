package com.qa.emailapplication;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

	@InjectMocks
	private EmailService service;

	@Mock
	private EmailRepo repo;

	@Test
	void createTest() {

		Email toCreate = new Email(0, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");
		Email created = new Email(1L, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");

		Mockito.when(this.repo.save(toCreate)).thenReturn(created);

		assertEquals(created, this.service.create(toCreate));

		Mockito.verify(this.repo, Mockito.times(1)).save(toCreate);
	}

	@Test
	void readTest() {

		Long id = 1L;
		Email testEmail = new Email(id, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");

		testEmail.setId(id);

		List<Email> email = List.of(testEmail);

		Mockito.when(this.repo.findAll()).thenReturn(email);

		assertThat(this.service.readAll()).isEqualTo(email);

		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	void testReadById() {

		Long id = 1L;
		Email expected = new Email(id, "Layt", "Reynolds", "0123456789", "Sales", "layton.reynolds");

		Mockito.when(this.repo.findById(id)).thenReturn(Optional.of(expected));

		assertThat(this.service.read(id)).isEqualTo(expected);

		Mockito.verify(this.repo, Mockito.times(1)).findById(id);
	}

	@Test
	void testUpdate() {

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
	void testDelete() {

		Long id = 1L;

		Mockito.when(this.repo.existsById(id)).thenReturn(false);

		assertThat(this.service.delete(id)).isTrue();

		Mockito.verify(this.repo, Mockito.times(1)).existsById(id);
	}

}
