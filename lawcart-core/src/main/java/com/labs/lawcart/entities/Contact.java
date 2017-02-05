package com.labs.lawcart.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
public class Contact implements Serializable{
	
	private static final long serialVersionUID = 1L;
 	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
 	private Integer id;


 	private String prefix;
 	
 	@Column(name="first_name")
 	private String firstName;
 	
 	@Column(name="last_name")
 	private String lastName;
 	
 	
 	@Column(name="company")
 	private String company;
 	

 	@Column(name="title")
 	private String title;
 	
 	@Column(name="work_email")
 	private String workEmail;
 	
 	@Column(name="home_email")
 	private String homeEmail;
 	
 	@Column(name="website")
 	private String website;
 	
 	
 	@Column(name="im")
 	private String im; 	
 	
 	@OneToMany(cascade=CascadeType.ALL, mappedBy="contact")
	private Set<Address> address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWorkEmail() {
		return workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	public String getHomeEmail() {
		return homeEmail;
	}

	public void setHomeEmail(String homeEmail) {
		this.homeEmail = homeEmail;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getIm() {
		return im;
	}

	public void setIm(String im) {
		this.im = im;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}
 	
 	
 	
 	
 	
}

