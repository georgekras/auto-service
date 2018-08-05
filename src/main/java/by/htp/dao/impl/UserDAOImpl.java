package by.htp.dao.impl; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import by.htp.dao.UserDAO;
import by.htp.dao.connection_pool.ConnectionPool;
import by.htp.dao.exception.DAOException;
import by.htp.entity.AdminUser;
import by.htp.entity.User;






public class UserDAOImpl implements UserDAO{

	
	private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
	
	@Override
	public User signIn(String login, String password) throws DAOException{
		
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		User user = null;
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		
		try (Connection connection = connectionPool.takeConnection()){
			preparedStatement = connection.prepareStatement(SQLquery.SIGN_IN);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				password = HidingPassword.lockPassword(password);
				int ID = resultSet.getInt(SQLquery.ID);
				String status = resultSet.getString(SQLquery.STATUS);
				String email = resultSet.getString(SQLquery.EMAIL);
				
				user = new User(ID, login, password, status, email);
			}
		
		}catch(SQLException e) {
			LOGGER.warn("DAOException", e);
			throw new DAOException("SQLException",e);
		} catch (InterruptedException e) {
			LOGGER.warn("DAOException", e);
			throw new DAOException("SQLException",e);
		}
		return user;
	}

	@Override
	public User signUp(String login, String password, String email) throws DAOException {
		System.out.println("in dao signUP");
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		User user = null;
		String status = "1";
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		
		try (Connection connection = connectionPool.takeConnection()){
			
			preparedStatement = connection.prepareStatement(SQLquery.SIGN_UP);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, status);
			preparedStatement.setString(4, email);
			preparedStatement.execute();
			preparedStatement = connection.prepareStatement(SQLquery.SELECT_USER_ID);
			preparedStatement.setString(1, login);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int ID = resultSet.getInt(SQLquery.ID);
				user = new User(ID, login, password, status, email);
			}
			
		} catch (SQLException e) {	
			LOGGER.warn("DAOException", e);
			throw new DAOException("SQLException",e);
			
		} catch (InterruptedException e) {
			LOGGER.warn("DAOException", e);
			throw new DAOException("InterruptException", e);
		}
		
		return user;
	}
	
	@Override
	public boolean checkLogin(String login) throws DAOException {
		
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		
		try (Connection connection = connectionPool.takeConnection()){
			preparedStatement = connection.prepareStatement(SQLquery.CHECK_LOGIN);
			preparedStatement.setString(1, login);
			resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			return false;
		}
		}catch (SQLException e) {	
			LOGGER.warn("DAOException", e);
			throw new DAOException("SQLException",e);
			
		} catch (InterruptedException e) {
			LOGGER.warn("DAOException", e);
			throw new DAOException("InterruptException", e);
		}
		
		return true;
	}

	
	@Override
	public AdminUser signInAdmin(String login, String password) throws DAOException {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		AdminUser admin = null;
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		
		try(Connection connection = connectionPool.takeConnection()){
			preparedStatement = connection.prepareStatement(SQLquery.SIGN_IN);
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int ID = resultSet.getInt(SQLquery.ID);
				password = HidingPassword.lockPassword(password);
				admin = new AdminUser(ID, login, password);
			}
		}catch(SQLException e) {
			LOGGER.warn("DAOException", e);
			throw new DAOException("SQLException", e);
		}catch (InterruptedException e1) {
			LOGGER.warn("DAOException", e1);
			throw new DAOException("InterruptException", e1);
		}
		return admin;
	}

	
}
