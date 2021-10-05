package com.qa.emailapplication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepo extends JpaRepository<Email, Long> {
	
	  @Query(value = "SELECT * from Email WHERE department = ?1", nativeQuery = true)
	    List<Email> findAllByDepartmentSQL(String department); // department is parameter 1

}