package com.javamsdt.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "job_title", nullable = true)
	private String jobTitle;

	@Column(name = "job_position", nullable = true)
	private String jobPosition;

	@Column(name = "company_name", nullable = true)
	private String companyName;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Email> emails = new HashSet<>();

	@OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PhoneNumber> phoneNumbers = new HashSet<>();

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "image_id")
	private Image image;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;

	@Version
	private long version;

	public Job() {
	}

	public Job(final String jobTitle, final String jobPosition, final String companyName) {
		this.jobTitle = jobTitle;
		this.jobPosition = jobPosition;
		this.companyName = companyName;
	}

	public Job(final String jobTitle, final String jobPosition, final String companyName, final long version) {
		this.jobTitle = jobTitle;
		this.jobPosition = jobPosition;
		this.companyName = companyName;
		this.version = version;
	}

	public Job(final long id, final String jobTitle, final String jobPosition, final String companyName,
			final long version) {
		this.id = id;
		this.jobTitle = jobTitle;
		this.jobPosition = jobPosition;
		this.companyName = companyName;
		this.version = version;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(final String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(final String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(final String companyName) {
		this.companyName = companyName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(final Address address) {
		this.address = address;
	}

	public Set<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(final Set<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(final Image image) {
		this.image = image;
	}


	public Set<Email> getEmails() {
		return emails;
	}

	public void setEmails(final Set<Email> emails) {
		this.emails = emails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
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
		builder.append("Job [id=");
		builder.append(id);
		builder.append(", jobTitle=");
		builder.append(jobTitle);
		builder.append(", jobPosition=");
		builder.append(jobPosition);
		builder.append(", companyName=");
		builder.append(companyName);
		builder.append(", address=");
		builder.append(address);
		builder.append(", phoneNumbers=");
		builder.append(phoneNumbers);
		builder.append(", image=");
		builder.append(image);
		builder.append(", user=");
		builder.append(user);
		builder.append(", version=");
		builder.append(version);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((companyName == null) ? 0 : companyName.hashCode());
		result = (prime * result) + (int) (id ^ (id >>> 32));
		result = (prime * result) + ((jobPosition == null) ? 0 : jobPosition.hashCode());
		result = (prime * result) + ((jobTitle == null) ? 0 : jobTitle.hashCode());
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
		Job other = (Job) obj;
		if (companyName == null) {
			if (other.companyName != null) {
				return false;
			}
		} else if (!companyName.equals(other.companyName)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (jobPosition == null) {
			if (other.jobPosition != null) {
				return false;
			}
		} else if (!jobPosition.equals(other.jobPosition)) {
			return false;
		}
		if (jobTitle == null) {
			if (other.jobTitle != null) {
				return false;
			}
		} else if (!jobTitle.equals(other.jobTitle)) {
			return false;
		}
		return true;
	}

}
