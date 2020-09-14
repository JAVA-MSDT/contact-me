package com.javamsdt.domain;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "image")
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "image_title", nullable = true)
	private String imageTitle;

	@Column(name = "image", nullable = true)
	private byte[] image;

	@Column(name = "main_image", nullable = true)
	private boolean mainImage;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Version
	private long version;

	public Image() {
	}

	public Image(final String imageTitle, final byte[] image, final boolean mainImage) {
		this.imageTitle = imageTitle;
		this.image = image;
		this.mainImage = mainImage;
	}

	public Image(final String imageTitle, final byte[] image, final boolean mainImage, final long version) {
		this.imageTitle = imageTitle;
		this.image = image;
		this.mainImage = mainImage;
		this.version = version;
	}

	public Image(final long id, final String imageTitle, final byte[] image, final boolean mainImage,
			final long version) {
		this.id = id;
		this.imageTitle = imageTitle;
		this.image = image;
		this.mainImage = mainImage;
		this.version = version;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getImageTitle() {
		return imageTitle;
	}

	public void setImageTitle(final String imageTitle) {
		this.imageTitle = imageTitle;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(final byte[] image) {
		this.image = image;
	}

	public boolean isMainImage() {
		return mainImage;
	}

	public void setMainImage(final boolean mainImage) {
		this.mainImage = mainImage;
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
		builder.append("Image [id=");
		builder.append(id);
		builder.append(", imageTitle=");
		builder.append(imageTitle);
		builder.append(", image=");
		builder.append(Arrays.toString(image));
		builder.append(", mainImage=");
		builder.append(mainImage);
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
		result = (prime * result) + Arrays.hashCode(image);
		result = (prime * result) + ((imageTitle == null) ? 0 : imageTitle.hashCode());
		result = (prime * result) + (mainImage ? 1231 : 1237);
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
		Image other = (Image) obj;
		if (id != other.id) {
			return false;
		}
		if (!Arrays.equals(image, other.image)) {
			return false;
		}
		if (imageTitle == null) {
			if (other.imageTitle != null) {
				return false;
			}
		} else if (!imageTitle.equals(other.imageTitle)) {
			return false;
		}
		if (mainImage != other.mainImage) {
			return false;
		}
		return true;
	}

}
