package com.qa.emailapplication;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

//	private List<EmailDTO> Email = new ArrayList<>();
	private ModelMapper mapper;
	private EmailRepo repo;

	@Autowired
	public EmailService(EmailRepo repo, ModelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}
	
//	Email Service constructor
	public EmailService(EmailRepo repo) {
		super();
		this.repo = repo;
	}

////	Map DTO to Input
//	public EmailDTO mapToDTO(Email a) {
//		return this.mapper.map(a, EmailDTO.class);
//
//	}
	
//	public Email mapFromDTO(EmailDTO a) {
//		return this.mapper.map(a, Email.class);
//	}
	
////createbyDTO 
//	public EmailDTO createByDTO(EmailDTO a) {
//		Email saveIt = this.mapFromDTO(a);
//		Email saved = this.repo.save(saveIt);
//		return this.mapToDTO(saved);
//	}
	
////	readAllByDTO
//	public List<EmailDTO> readAllbyDTO() {
//		return this.Email;
//		
//	}

	
//	create
	public Email create(Email a) {
		return this.repo.save(a);
	}

// ReadAll
	public List<Email> readAll() {
		return this.repo.findAll();
	}

// Read by id
	public Email read(long id) {
		return this.repo.findById(id).get();
	}
	
//FindbyId
	public List<Email> findByName(String name) {
		return this.repo.findByname(name);
	}

// update
	public Email update(long id, Email e) {
		Email exists = this.repo.findById(id).orElseThrow(EmailNotFoundException::new);
		exists.setFirstName(e.getFirstName());
		exists.setLastName(e.getLastName());
		return this.repo.saveAndFlush(exists);
	}


// delete
	public boolean delete(long id) {
		if (!this.repo.existsById(id)) {
			throw new EmailNotFoundException();
		}
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}


}