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
@Table(name = "social_network")
public class SocialNetwork {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "social_title", nullable = true)
	private String socialTitle;

	@Column(name = "link", nullable = true)
	private String link;

	@ManyToOne
	private User user;

	@Version
	private long version;

	public SocialNetwork() {
	}

	public SocialNetwork(final String socialTitle, final String link) {
		this.socialTitle = socialTitle;
		this.link = link;
	}

	public SocialNetwork(final String socialTitle, final String link, final long version) {
		this.socialTitle = socialTitle;
		this.link = link;
		this.version = version;
	}

	public SocialNetwork(final long id, final String socialTitle, final String link, final long version) {
		this.id = id;
		this.socialTitle = socialTitle;
		this.link = link;
		this.version = version;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getSocialTitle() {
		return socialTitle;
	}

	public void setSocialTitle(final String socialTitle) {
		this.socialTitle = socialTitle;
	}

	public String getLink() {
		return link;
	}

	public void setLink(final String link) {
		this.link = link;
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
		builder.append("SocialNetwork [id=");
		builder.append(id);
		builder.append(", socialTitle=");
		builder.append(socialTitle);
		builder.append(", link=");
		builder.append(link);
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
		result = (prime * result) + (int) (id ^ (id >>> 32));
		result = (prime * result) + ((link == null) ? 0 : link.hashCode());
		result = (prime * result) + ((socialTitle == null) ? 0 : socialTitle.hashCode());
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
		SocialNetwork other = (SocialNetwork) obj;
		if (id != other.id) {
			return false;
		}
		if (link == null) {
			if (other.link != null) {
				return false;
			}
		} else if (!link.equals(other.link)) {
			return false;
		}
		if (socialTitle == null) {
			if (other.socialTitle != null) {
				return false;
			}
		} else if (!socialTitle.equals(other.socialTitle)) {
			return false;
		}
		return true;
	}

}
