package com.javamsdt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "phone_number")
public class PhoneNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "country_code", nullable = true)
	private String countryCode;

	@Column(name = "phone_number", nullable = true)
	private String phoneNumber;

	@Column(name = "main_number", nullable = true)
	private boolean mainNumber;

	@ManyToOne
	private User user;

	@ManyToOne
	private Job job;

	@Version
	private long version;

	public PhoneNumber() {
	}

	public PhoneNumber(final String countryCode, final String phoneNumber, final boolean mainNumber) {
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
		this.mainNumber = mainNumber;
	}

	public PhoneNumber(final String countryCode, final String phoneNumber, final boolean mainNumber,
			final long version) {
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
		this.mainNumber = mainNumber;
		this.version = version;
	}

	public PhoneNumber(final long id, final String countryCode, final String phoneNumber, final boolean mainNumber,
			final long version) {
		this.id = id;
		this.countryCode = countryCode;
		this.phoneNumber = phoneNumber;
		this.mainNumber = mainNumber;
		this.version = version;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(final String countryCode) {
		this.countryCode = countryCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isMainNumber() {
		return mainNumber;
	}

	public void setMainNumber(final boolean mainNumber) {
		this.mainNumber = mainNumber;
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
		builder.append("PhoneNumber [id=");
		builder.append(id);
		builder.append(", countryCode=");
		builder.append(countryCode);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", mainNumber=");
		builder.append(mainNumber);
		builder.append(", user=");
		builder.append(user);
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
		result = (prime * result) + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = (prime * result) + (int) (id ^ (id >>> 32));
		result = (prime * result) + (mainNumber ? 1231 : 1237);
		result = (prime * result) + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
		PhoneNumber other = (PhoneNumber) obj;
		if (countryCode == null) {
			if (other.countryCode != null) {
				return false;
			}
		} else if (!countryCode.equals(other.countryCode)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (mainNumber != other.mainNumber) {
			return false;
		}
		if (phoneNumber == null) {
			if (other.phoneNumber != null) {
				return false;
			}
		} else if (!phoneNumber.equals(other.phoneNumber)) {
			return false;
		}
		return true;
	}

}
