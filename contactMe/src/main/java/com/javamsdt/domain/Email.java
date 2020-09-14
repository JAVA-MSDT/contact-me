package com.javamsdt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "email")
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "email")
	private String email;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;

	@Version
	private long version;

	public Email() {
	}

	public Email(final String email) {
		this.email = email;
	}

	public Email(final String email, final long version) {
		this.email = email;
		this.version = version;
	}

	public Email(final long id, final String email, final long version) {
		this.id = id;
		this.email = email;
		this.version = version;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(final Job job) {
		this.job = job;
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
		builder.append("Email [id=");
		builder.append(id);
		builder.append(", email=");
		builder.append(email);
		builder.append(", job=");
		builder.append(job);
		builder.append(", version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((email == null) ? 0 : email.hashCode());
		result = (prime * result) + (int) (id ^ (id >>> 32));
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
		Email other = (Email) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		return true;
	}

}
