package com.lucasnscr.gcp.firestorestudy.entity;

public class Phone {
	private int number;
	private PhoneType type;

	Phone() {
	}

	Phone(int number, PhoneType type) {
		this.number = number;
		this.type = type;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public PhoneType getType() {
		return this.type;
	}

	public void setType(PhoneType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Phone{" + "number=" + this.number + ", type=" + this.type + '}';
	}
}

enum PhoneType {
	WORK, CELL;
}
