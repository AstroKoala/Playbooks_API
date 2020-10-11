package com.astrokoala.models;

import java.time.LocalDate;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

public class User {
	private int id;
	private String email;
	private String username;
	private LocalDate createDate;
	
	public User() {
		
	}
	
	public User(int id, String email, String username, LocalDate createDate) {
		this.id = id;
		this.email = email;
		this.username = username;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	
	public LinkedHashMap<?, ?> toLinkedHashMap() {
		ObjectMapper oMapper = new ObjectMapper();
		return oMapper.convertValue(this, LinkedHashMap.class);
	}
	
}
