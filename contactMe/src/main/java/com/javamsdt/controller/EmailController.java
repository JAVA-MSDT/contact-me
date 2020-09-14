package com.javamsdt.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javamsdt.domain.Email;
import com.javamsdt.domain.User;
import com.javamsdt.model.repository.EmailRepository;
import com.javamsdt.model.service.UserService;

@RestController
public class EmailController {

	@Autowired
	private EmailRepository emailRepository;

	@Autowired
	private UserService userService;

	@GetMapping(path = "/emails")
	public ResponseEntity<List<Email>> emails() {
		List<Email> emails = emailRepository.findAll();
		if ((emails != null) && !emails.isEmpty()) {
			return new ResponseEntity<>(emails, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(path = "/emails/{username}/updateEmail", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> updateUserEmail(@PathVariable(value = "username") final String username,
			@Param(value = "newEmail") final String newEmail, @RequestBody final Email email) {

		Optional<User> userOptional = userService.findByUsername(username);
		Email emailHolder = new Email();

		if (userOptional.isPresent()) {
			User user = userOptional.get();

			Set<Email> emails = user.getEmails();
			for (Email em : emails) {
				if (em.getEmail().equals(email.getEmail())) {
					em.setEmail(newEmail);
					emailHolder = em;
					user.addEmail(emailHolder);
					userService.updateUser(user);
					return new ResponseEntity<>(HttpStatus.OK);

				}
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	@PostMapping(path = "/emails/{id}/addEmail", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> addEmailToUser(@PathVariable(value = "id") final long id,
			@RequestBody final Email email) {

		Optional<User> userOptional = userService.findByid(id);

		if (userOptional.isPresent()) {
			User user = userOptional.get();

			boolean isEmailExists = user.getEmails().stream()
					.anyMatch(userEmail -> userEmail.getEmail().equals(email.getEmail()));
			if (!isEmailExists) {
				user.addEmail(email);
				userService.updateUser(user);
				return new ResponseEntity<>(HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	}

	@DeleteMapping(path = "/emails/{username}/removeEmail", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> removeEmailFromUser(@PathVariable(value = "username") final String username,
			@RequestBody final Email email) {
		Optional<User> userOptional = userService.findByUsername(username);

		if (userOptional.isPresent()) {
			User user = userOptional.get();

			boolean isEmailExists = user.getEmails().stream()
					.anyMatch(userEmail -> userEmail.getEmail().equals(email.getEmail()));

			System.out.println(isEmailExists + ", " + user.getEmails().size());

			Set<Email> emails = user.getEmails()
					.stream().filter(userEmail -> userEmail.getEmail().equals(email.getEmail()))
					.collect(Collectors.toSet());
			System.out.println(emails.size());

			if (isEmailExists) {
				user.removeEmail(email);
				user.setEmails(emails);
				System.out.println(isEmailExists + ", Inside: " + user.getEmails().size());
				userService.updateUser(user);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}

		return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
}
