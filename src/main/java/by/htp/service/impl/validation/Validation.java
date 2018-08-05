package by.htp.service.impl.validation;

public interface Validation {
	
	public abstract boolean checkLogin(String login);
	public abstract boolean checkPassword(String password);
	public abstract boolean checkEmail(String email);
	public abstract boolean checkYear(String year);
	public abstract boolean checkPrice(String price);
	public abstract boolean checkEngineCapacity(String engineCapacity);
	public abstract boolean checkMileAge(String mileAge);

}
