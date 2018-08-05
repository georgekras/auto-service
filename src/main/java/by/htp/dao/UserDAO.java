package by.htp.dao;

import by.htp.dao.exception.DAOException;
import by.htp.entity.AdminUser;
import by.htp.entity.User;

public interface UserDAO {
	
	public abstract User signIn(String login, String password) throws DAOException;
	public abstract AdminUser signInAdmin(String login, String password) throws DAOException;
	public abstract User signUp(String login, String password, String email) throws DAOException;
	public abstract boolean checkLogin(String login) throws DAOException;
}
