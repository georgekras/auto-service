package by.htp.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import by.htp.dao.DAOFactory;
import by.htp.dao.UserDAO;
import by.htp.dao.exception.DAOException;
import by.htp.entity.AdminUser;
import by.htp.entity.User;
import by.htp.service.UserService;
import by.htp.service.exception.ServiceException;
import by.htp.service.impl.validation.ValidationProvider;


public class UserServiceImpl implements UserService {

	
	private final static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	
	@Override
	public User signIn(String login, String password) throws ServiceException{
		User user = null;
		
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoFactory.getUserDAO();
			user = userDAO.signIn(login, password);
			
		} catch (DAOException e) {
			LOGGER.warn("ServletException in Controller", e);
			throw new ServiceException("From DAO", e);
		}
	return user;
	}

	
	@Override
	public User signUp(String login, String password, String email) throws ServiceException {
		User user = new User(login, password, email);
		User userNew = null;
		List<String> listError = null;
		
		try {
			listError = ValidationProvider.checkNewUser(user);
			
			if(listError.isEmpty()) {
				DAOFactory daoFactory = DAOFactory.getInstance();
				UserDAO userDAO = daoFactory.getUserDAO();
				if(userDAO.checkLogin(login)) {
				userNew = userDAO.signUp(login, password, email);
				}
			}
			
		} catch (DAOException e) {
			LOGGER.warn("ServiceException in Service");
			throw new ServiceException("From DAO", e);
		}
		return userNew;
	}
		
	
	@Override
	public AdminUser signInAdmin(String login, String password) throws ServiceException {
		AdminUser admin = null;
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		
		try {
			admin = userDAO.signInAdmin(login, password);
		} catch (DAOException e) {
			LOGGER.warn("ServiceException in Service");
			throw new ServiceException("From DAO", e);
		}
		return admin;
	}

	
	
}
