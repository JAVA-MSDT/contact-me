package com.javamsdt.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "enabled", columnDefinition = "BOOLEAN DEFAULT true")
	private boolean enabled;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;

	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
	private Set<Email> emails = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Address> address = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PhoneNumber> phoneNumbers = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<SocialNetwork> socialNetworks = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Image> images = new HashSet<>();

	@OneToMany(mappedBy = "user", cascade = { CascadeType.MERGE, CascadeType.DETACH })
	private Set<Job> jobs = new HashSet<>();

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "contact_id")
	private User contact;

	@OneToMany(mappedBy = "contact", cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,
			CascadeType.DETACH }, orphanRemoval = false)
	private Set<User> users = new HashSet<>();

	@Version
	private long version;

	public User() {
	}

	public User(final String firstName, final String lastName, final String middleName, final String username,
			final String password, final boolean enabled, final Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
	}

	public User(final String firstName, final String lastName, final String middleName, final String username,
			final String password, final boolean enabled, final Role role, final long version) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.version = version;
	}

	public User(final long id, final String firstName, final String lastName, final String middleName,
			final String username, final String password, final boolean enabled, final Role role, final long version) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.version = version;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(final Role role) {
		this.role = role;
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

	public User getContact() {
		return contact;
	}

	public void setContact(final User contact) {
		this.contact = contact;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(final Set<User> users) {
		this.users = users;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(final long version) {
		this.version = version;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", middleName=");
		builder.append(middleName);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append(", role=");
		builder.append(role);
		builder.append(", emails=");
		builder.append(emails);
		builder.append(", address=");
		builder.append(address);
		builder.append(", phoneNumbers=");
		builder.append(phoneNumbers);
		builder.append(", socialNetworks=");
		builder.append(socialNetworks);
		builder.append(", images=");
		builder.append(images);
		builder.append(", jobs=");
		builder.append(jobs);
		builder.append(", contact=");
		builder.append(contact);
		builder.append(", users=");
		builder.append(users);
		builder.append(", version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (enabled ? 1231 : 1237);
		result = (prime * result) + ((firstName == null) ? 0 : firstName.hashCode());
		result = (prime * result) + (int) (id ^ (id >>> 32));
		result = (prime * result) + ((lastName == null) ? 0 : lastName.hashCode());
		result = (prime * result) + ((middleName == null) ? 0 : middleName.hashCode());
		result = (prime * result) + ((password == null) ? 0 : password.hashCode());
		result = (prime * result) + ((role == null) ? 0 : role.hashCode());
		result = (prime * result) + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (enabled != other.enabled) {
			return false;
		}
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (middleName == null) {
			if (other.middleName != null) {
				return false;
			}
		} else if (!middleName.equals(other.middleName)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (role != other.role) {
			return false;
		}
		if (username == null) {
			if (other.username != null) {
				return false;
			}
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}

	// ======================= Association Helper methods ======================= //

	public void addEmail(final Email email) {
		this.emails.add(email);
		email.setUser(this);
	}

	public void removeEmail(final Email email) {
		this.emails.remove(email);
		email.setUser(null);
	}

}
