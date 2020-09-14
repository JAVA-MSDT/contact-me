package com.javamsdt.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javamsdt.domain.User;
import com.javamsdt.model.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> findByid(final long id) {
		return userRepository.findById(id);
	}

	public Optional<User> findByUsername(final String username) {
		return userRepository.findByUsername(username);
	}

	public User saveUser(final User user) {
		user.addEmail(user.getEmails().stream().findFirst().get());
		return userRepository.save(user);
	}

	public User updateUser(final User user) {
		return userRepository.save(user);
	}

}
