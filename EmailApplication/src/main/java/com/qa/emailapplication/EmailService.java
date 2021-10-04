package com.qa.emailapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

//	private List<EmailDTO> Email = new ArrayList<>();
//	private ModelMapper mapper;
	private EmailRepo repo;

//	@Autowired
//	public EmailService(EmailRepo repo, ModelMapper mapper) {
//		this.repo = repo;
//		this.mapper = mapper;
//	}

////	Map DTO to Input
//	public EmailDTO mapToDTO(Email a) {
//		return this.mapper.map(a, EmailDTO.class);
//
//	}
//	
//	public Email mapFromDTO(EmailDTO a) {
//		return this.mapper.map(a, Email.class);
//	}

//	
////createbyDTO 
//	public EmailDTO createByDTO(EmailDTO a) {
//		Email saveIt = this.mapFromDTO(a);
//		Email saved = this.repo.save(saveIt);
//		return this.mapToDTO(saved);
//	}

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
		Email existing = this.repo.findById(id).orElseThrow(EmailNotFoundException::new);
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

}

////	readAllByDTO
//	public List<EmailDTO> readAllbyDTO() {
//		return this.Email;
//		
//	}