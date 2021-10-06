package com.qa.emailapplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.emailapplication.domain.Email;
import com.qa.emailapplication.dto.EmailDTO;
import com.qa.emailapplication.repo.EmailRepo;

@Service
public class EmailService {

	private ModelMapper mapper;
	private EmailRepo repo;

	@Autowired
	public EmailService(EmailRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}

//	Map DTO to Input
	public EmailDTO mapToDTO(Email a) {
		return this.mapper.map(a, EmailDTO.class);

	}


//	Email Service constructor
	public EmailService(EmailRepo repo) {
		super();
		this.repo = repo;
	}

//	create
	public Email create(Email a) {
		return this.repo.save(a);
	}

//Read All
	public List<Email> readAll() {
		return this.repo.findAll();
	}

//Read By Id

	public Email read(long id) {
		return this.repo.findById(id).get();
	}

//update
	public Email update(Long id, Email newEmail) {

		Email existing = this.repo.findById(id).orElseThrow();

		existing.setFirstName(newEmail.getFirstName());
		existing.setLastName(newEmail.getLastName());
		existing.setPassword(newEmail.getPassword());
		existing.setDepartment(newEmail.getDepartment());
		existing.setEmail(newEmail.getEmail());
		return this.repo.save(existing);
	}

//delete
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);

	}

	public List<EmailDTO> readAllDTO() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	public EmailDTO createDTO(Email e) {
		Email saved = this.repo.save(e);
		return this.mapToDTO(saved);
	}
	
	//Read by department
		public List<Email> readByDep(String d) {
			return this.repo.findAllByDepartmentSQL(d); 
		}
	
}
