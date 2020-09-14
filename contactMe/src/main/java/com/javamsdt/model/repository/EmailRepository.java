package com.javamsdt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javamsdt.domain.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{

}
