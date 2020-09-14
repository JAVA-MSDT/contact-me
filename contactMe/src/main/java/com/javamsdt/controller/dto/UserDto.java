package com.javamsdt.controller.dto;

import java.util.Set;

import com.javamsdt.domain.Address;
import com.javamsdt.domain.Email;
import com.javamsdt.domain.Image;
import com.javamsdt.domain.Job;
import com.javamsdt.domain.PhoneNumber;
import com.javamsdt.domain.SocialNetwork;
import com.javamsdt.domain.User;

public class UserDto {
	private long id;

	private String firstName;

	private String lastName;

	private String middleName;

	private Set<Email> emails;

	private Set<Address> address;

	private Set<PhoneNumber> phoneNumbers;

	private Set<SocialNetwork> socialNetworks;

	private Set<Image> images;

	private Set<Job> jobs;

	private Set<User> users;

	public UserDto() {
	}

	public UserDto(final long id, final String firstName, final String lastName, final String middleName, final Set<Email> emails,
			final Set<Address> address, final Set<PhoneNumber> phoneNumbers, final Set<SocialNetwork> socialNetworks,
			final Set<Image> images, final Set<Job> jobs, final Set<User> users) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.emails = emails;
		this.address = address;
		this.phoneNumbers = phoneNumbers;
		this.socialNetworks = socialNetworks;
		this.images = images;
		this.jobs = jobs;
		this.users = users;
	}


	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	public Set<Email> getEmails() {
		return emails;
	}

	public void setEmails(final Set<Email> emails) {
		this.emails = emails;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(final Set<Address> address) {
		this.address = address;
	}

	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(final Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Set<SocialNetwork> getSocialNetworks() {
		return socialNetworks;
	}

	public void setSocialNetworks(final Set<SocialNetwork> socialNetworks) {
		this.socialNetworks = socialNetworks;
	}

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(final Set<Image> images) {
		this.images = images;
	}

	public Set<Job> getJobs() {
		return jobs;
	}

	public void setJobs(final Set<Job> jobs) {
		this.jobs = jobs;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(final Set<User> users) {
		this.users = users;
	}

}
