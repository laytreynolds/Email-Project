package com.qa.emailapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.emailapplication.domain.Email;
import com.qa.emailapplication.dto.EmailDTO;
import com.qa.emailapplication.service.EmailService;

@RestController
@RequestMapping("/user")
public class EmailController {

	@Autowired
	private EmailService service;

//create
	@PostMapping("/create")
	public ResponseEntity<Email> create(@RequestBody Email e) {
		return new ResponseEntity<Email>(this.service.create(e), HttpStatus.CREATED);
	}

//Read
	@GetMapping("/read")
	public ResponseEntity<List<Email>> readAll() {
		return new ResponseEntity<List<Email>>(this.service.readAll(), HttpStatus.OK);

	}

//ReadId
	@GetMapping("/read/{id}")
	public ResponseEntity<Email> read(@PathVariable long id) {
		return new ResponseEntity<Email>(this.service.read(id), HttpStatus.OK);

	}

//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Email> update(@PathVariable long id, @RequestBody Email e) {
		return new ResponseEntity<Email>(this.service.update(id, e), HttpStatus.ACCEPTED);

	}

//delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable long id) {
		return new ResponseEntity<Boolean>(this.service.delete(id), HttpStatus.NO_CONTENT);
	}

//ReadAllByDTO
	@GetMapping("/readDTO")
	public ResponseEntity<List<EmailDTO>> readAllDTO() {
		return new ResponseEntity<List<EmailDTO>>(this.service.readAllDTO(), HttpStatus.OK);
	}

//create via DTO
	@PostMapping("/createDTO")
	public ResponseEntity<EmailDTO> createDTO(@RequestBody Email Email) {
		return new ResponseEntity<EmailDTO>(this.service.createDTO(Email), HttpStatus.CREATED);
	}
	
	//Read
		@GetMapping("/read/dep/{d}")
		public ResponseEntity<List<Email>> readByDep(@PathVariable String d) {
			return new ResponseEntity<List<Email>>(this.service.readByDep(d), HttpStatus.OK);

		}

}
