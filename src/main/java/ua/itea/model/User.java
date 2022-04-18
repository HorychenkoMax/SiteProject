package ua.itea.model;

import java.util.Objects;

public class User {

	private String login;
	private String password;
	private String name;
	private String gender;
	private String address;
	private String comment;

	public User() {

	}

	public User(String login, String password, String name, String gender, String address, String comment) {
		this.login = login;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.comment = comment;
	}

	public String getLogin() {
		return login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "User [login=" + login + ", password=" + password + ", name=" + name + ", gender=" + gender
				+ ", address=" + address + ", comment=" + comment + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, comment, gender, login, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(address, other.address) && Objects.equals(comment, other.comment)
				&& Objects.equals(login, other.login) && Objects.equals(password, other.password);
	}

}
