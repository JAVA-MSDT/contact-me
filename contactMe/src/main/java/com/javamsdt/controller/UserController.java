package com.javamsdt.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javamsdt.controller.dto.UserDto;
import com.javamsdt.domain.User;
import com.javamsdt.model.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping(path = "/users")
	public ResponseEntity<List<UserDto>> users() {

		List<UserDto> users = userService.findAllUsers().stream().map(this::fromUserdomain)
				.collect(Collectors.toList());

		if ((users != null) && !users.isEmpty()) {
			return new ResponseEntity<>(users, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping(path = "/users/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable(value = "id") final long id) {
		Optional<User> userOptional = userService.findByid(id);
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			System.out.println("User: " + user.getEmails().size());
			UserDto userDtoResponse = fromUserdomain(user);
			System.out.println("userDtoResponse: " +  userDtoResponse.getEmails().size());
			return new ResponseEntity<>(userDtoResponse, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(path = "/users", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserDto> addUser(@RequestBody final UserDto userDto) {
		User userSaved = userService.saveUser(toUserDomain(userDto));

		UserDto userDtoResponse = fromUserdomain(userSaved);

		if (userSaved != null) {
			return new ResponseEntity<>(userDtoResponse, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}


	// ======================= Mappers ======================= //

	private User toUserDomain(final UserDto userDto) {
		return modelMapper.map(userDto, User.class);
	}

	private UserDto fromUserdomain(final User user) {
		return modelMapper.map(user, UserDto.class);
	}

}
