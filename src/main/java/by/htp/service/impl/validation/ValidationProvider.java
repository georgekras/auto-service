package by.htp.service.impl.validation;


import java.util.ArrayList;
import java.util.List;

import by.htp.entity.User;
import by.htp.entity.Vehicle;

public class ValidationProvider {
	
	public static final String LOGIN_ERROR = "incorrect login";
	public static final String PASSWORD_ERROR = "incorrect password";
	public static final String EMAIL_ERROR = "incorrect email";
	
	
	//Constructors
	public ValidationProvider() { }
	
	private static List<String> errorList = new ArrayList<String>();
	
	//Validate new User
	public static List<String> checkNewUser(User user) {
		Validation valid = new ValidationImpl();
		if(!valid.checkLogin(user.getLogin())){ errorList.add(LOGIN_ERROR);}
		if(!valid.checkPassword(user.getPassword())) {errorList.add(PASSWORD_ERROR);}
		if(!valid.checkEmail(user.getEmail())) {errorList.add(EMAIL_ERROR);}
		
		return errorList;
	}
	
	public static List<String> getErrorList() {
		return errorList;
	}
	
	public void putErrors(String error) {
		errorList.add(error);
	}
	
}
