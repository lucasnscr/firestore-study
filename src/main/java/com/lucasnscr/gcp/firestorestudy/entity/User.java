package com.lucasnscr.gcp.firestorestudy.entity;

import java.util.List;

public class User {

	private String name;
	private List<Phone> phones;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

}
