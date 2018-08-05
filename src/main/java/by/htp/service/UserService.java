package by.htp.service;


import by.htp.entity.AdminUser;
import by.htp.entity.User;
import by.htp.service.exception.ServiceException;

public interface UserService {
	
	public User signIn(String login, String password) throws ServiceException;
	public User signUp(String login, String password, String email) throws ServiceException;
	public AdminUser signInAdmin(String login, String password) throws ServiceException;
	

}
