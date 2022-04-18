package ua.itea.service;

import java.util.Objects;

public class RegistrationCheckService {
	private String errorText;
	private String CHECK_PASSWORD = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
	private String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	boolean isError = false;

	public boolean IsRegistrationCorrect(String login, String password, String rePassword, String name, String gender,
			String address, String comment) {
		if (login.length() < 1) {
			isError = true;
			this.errorText += "<li> login is empty </li>";
		}
		if (!login.matches(EMAIL_PATTERN)) {
			isError = true;
			this.errorText += "<li> login is not correct </li>";
		}
		if (password.length() < 1) {
			isError = true;
			this.errorText += "<li> password is empty </li>";
		}
//		if (!password.matches(CHECK_PASSWORD)) {
//			isError = true;
//			this.errorText += "<li> not a secure password </li>";
//		}
		if (rePassword.length() < 1 && !Objects.isNull(rePassword)) {
			isError = true;
			this.errorText += "<li> re-password is empty </li>";
		}
		if (!Objects.equals(password, rePassword)) {
			isError = true;
			this.errorText += "<li> password and re-password do not match </li>";
		}
		if (name.length() < 1 && !Objects.isNull(name)) {
			isError = true;
			this.errorText += "<li> name is empty </li>";
		}
		if (Objects.isNull(gender) || gender.length() < 1) {
			isError = true;
			this.errorText += "<li> gender is empty </li>";
		}
		if (address.length() < 1) {
			isError = true;
			this.errorText += "<li> address is empty </li>";
		}
//		if (comment.length() < 1 && !Objects.isNull(comment)) {
//			isError = true;
//			this.errorText += "<li> comment is empty </li>";
//		}
		return isError;
	}

	public String getError() {
		return errorText;
	}
}
