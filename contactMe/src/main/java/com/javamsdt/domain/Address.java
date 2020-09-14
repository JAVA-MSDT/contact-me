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

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "zipcode", nullable = true)
	private String zipcode;

	@Column(name = "flat_number", nullable = true)
	private String flatNumber;

	@Column(name = "bulding_number", nullable = true)
	private String buildingNumber;

	@Column(name = "street_name", nullable = true)
	private String streetName;

	@Column(name = "city", nullable = true)
	private String city;

	@Column(name = "province", nullable = true)
	private String province;

	@Column(name = "country", nullable = true)
	private String country;

	@Column(name = "main_address", nullable = true)
	private boolean mainAddress;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Version
	private long version;

	public Address() {
	}

	public Address(final String zipcode, final String flatNumber, final String buildingNumber, final String streetName,
			final String city, final String province, final String country, final boolean mainAddress) {
		this.zipcode = zipcode;
		this.flatNumber = flatNumber;
		this.buildingNumber = buildingNumber;
		this.streetName = streetName;
		this.city = city;
		this.province = province;
		this.country = country;
		this.mainAddress = mainAddress;
	}

	public Address(final String zipcode, final String flatNumber, final String buildingNumber, final String streetName,
			final String city, final String province, final String country, final boolean mainAddress,
			final long version) {
		this.zipcode = zipcode;
		this.flatNumber = flatNumber;
		this.buildingNumber = buildingNumber;
		this.streetName = streetName;
		this.city = city;
		this.province = province;
		this.country = country;
		this.mainAddress = mainAddress;
		this.version = version;
	}

	public Address(final long id, final String zipcode, final String flatNumber, final String buildingNumber,
			final String streetName, final String city, final String province, final String country,
			final boolean mainAddress, final long version) {
		this.id = id;
		this.zipcode = zipcode;
		this.flatNumber = flatNumber;
		this.buildingNumber = buildingNumber;
		this.streetName = streetName;
		this.city = city;
		this.province = province;
		this.country = country;
		this.mainAddress = mainAddress;
		this.version = version;
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(final String zipcode) {
		this.zipcode = zipcode;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(final String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getBuildingNumber() {
		return buildingNumber;
	}

	public void setBuildingNumber(final String buildingNumber) {
		this.buildingNumber = buildingNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(final String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(final String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(final String country) {
		this.country = country;
	}

	public boolean isMainAddress() {
		return mainAddress;
	}

	public void setMainAddress(final boolean mainAddress) {
		this.mainAddress = mainAddress;
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
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", zipcode=");
		builder.append(zipcode);
		builder.append(", flatNumber=");
		builder.append(flatNumber);
		builder.append(", buildingNumber=");
		builder.append(buildingNumber);
		builder.append(", streetName=");
		builder.append(streetName);
		builder.append(", city=");
		builder.append(city);
		builder.append(", province=");
		builder.append(province);
		builder.append(", country=");
		builder.append(country);
		builder.append(", mainAddress=");
		builder.append(mainAddress);
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
		result = (prime * result) + ((buildingNumber == null) ? 0 : buildingNumber.hashCode());
		result = (prime * result) + ((city == null) ? 0 : city.hashCode());
		result = (prime * result) + ((country == null) ? 0 : country.hashCode());
		result = (prime * result) + ((flatNumber == null) ? 0 : flatNumber.hashCode());
		result = (prime * result) + (int) (id ^ (id >>> 32));
		result = (prime * result) + (mainAddress ? 1231 : 1237);
		result = (prime * result) + ((province == null) ? 0 : province.hashCode());
		result = (prime * result) + ((streetName == null) ? 0 : streetName.hashCode());
		result = (prime * result) + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		Address other = (Address) obj;
		if (buildingNumber == null) {
			if (other.buildingNumber != null) {
				return false;
			}
		} else if (!buildingNumber.equals(other.buildingNumber)) {
			return false;
		}
		if (city == null) {
			if (other.city != null) {
				return false;
			}
		} else if (!city.equals(other.city)) {
			return false;
		}
		if (country == null) {
			if (other.country != null) {
				return false;
			}
		} else if (!country.equals(other.country)) {
			return false;
		}
		if (flatNumber == null) {
			if (other.flatNumber != null) {
				return false;
			}
		} else if (!flatNumber.equals(other.flatNumber)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (mainAddress != other.mainAddress) {
			return false;
		}
		if (province == null) {
			if (other.province != null) {
				return false;
			}
		} else if (!province.equals(other.province)) {
			return false;
		}
		if (streetName == null) {
			if (other.streetName != null) {
				return false;
			}
		} else if (!streetName.equals(other.streetName)) {
			return false;
		}
		if (zipcode == null) {
			if (other.zipcode != null) {
				return false;
			}
		} else if (!zipcode.equals(other.zipcode)) {
			return false;
		}
		return true;
	}

}
