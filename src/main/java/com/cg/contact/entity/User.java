package com.cg.contact.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user1")
public class User {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	private String password;
	private String imageUrl;
	private String about;
	private String role;
	private boolean enabled;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true)
	private List<Contact> contacts = new ArrayList<>();
	
	
	
	public User(int id, String name, String email, String password, String imageUrl, String about, String role,
			boolean enabled, List<Contact> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.imageUrl = imageUrl;
		this.about = about;
		this.role = role;
		this.enabled = enabled;
		this.contacts = contacts;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	

	@Override
	public String toString() {
		return "User [about=" + about + ", contacts=" + contacts + ", email=" + email + ", enabled=" + enabled + ", id="
				+ id + ", imageUrl=" + imageUrl + ", name=" + name + ", password=" + password + ", role=" + role + "]";
	}

	public BooleanSupplier isActive1() {
		// TODO Auto-generated method stub
		return null;
	}

	public User addContactInUser1(User contact1) {
		return contact1;
		// TODO Auto-generated method stub
		
	}

	public String getContact1() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}