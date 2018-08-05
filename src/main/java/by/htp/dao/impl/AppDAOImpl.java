package by.htp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import by.htp.dao.AppDAO;
import by.htp.dao.connection_pool.ConnectionPool;
import by.htp.dao.exception.DAOException;
import by.htp.entity.Vehicle;

public class AppDAOImpl implements AppDAO {
	
	private final static Logger LOGGER = Logger.getLogger(AppDAOImpl.class);

	@Override
	public Map<Integer, Vehicle> getAllCars() throws DAOException {
		
		Statement statement;
		ResultSet resultSet;
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		Map<Integer, Vehicle> cars = new HashMap<Integer, Vehicle>();

		try (Connection connection = connectionPool.takeConnection()) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SQLquery.SELECT_ALL_VEHICLE);

			while (resultSet.next()) {
				int ID = resultSet.getInt(SQLquery.ID);
				String model = resultSet.getString(SQLquery.MODEL);
				String year = resultSet.getString(SQLquery.YEAR);
				String typeCarcase = resultSet.getString(SQLquery.TYPE_OF_CARCASE);
				String price = resultSet.getString(SQLquery.PRICE);
				String transmission = resultSet.getString(SQLquery.TRANSMISSION);
				String typeFuel = resultSet.getString(SQLquery.TYPE_OF_FUEL);
				String engineCapacity = resultSet.getString(SQLquery.ENGINE_CAPACITY);
				String driveUnit = resultSet.getString(SQLquery.DRIVE_UNIT);
				String mileage = resultSet.getString(SQLquery.MILEAGE);

				Vehicle vehicle = new Vehicle(ID, model, year, typeCarcase, price, transmission, typeFuel,
						engineCapacity, driveUnit, mileage);
				cars.put(ID, vehicle);
			}

		} catch (SQLException e) {
			LOGGER.fatal("SQLException in DAO", e);
			throw new DAOException("SQLException",e);
		} catch (InterruptedException e) {
			LOGGER.fatal("InterruptedException in DAO", e);
			throw new DAOException("InterruptedException",e);
		}
		return cars;
	}

	@Override
	public void addVehicle(String model, String year, String typeCarcase, String price, String transmission,
			String typeFuel, String engineCapacity, String driveUnit, String mileage) throws DAOException {
		
		PreparedStatement preparedStatement;
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		
		try (Connection connection = connectionPool.takeConnection()){
			preparedStatement = connection.prepareStatement(SQLquery.ADD_VEHICLE);
			preparedStatement.setString(1, model);
			preparedStatement.setString(2, "1");
			preparedStatement.setString(3, year);
			preparedStatement.setString(4, typeCarcase);
			preparedStatement.setString(5, price);
			preparedStatement.setString(6, transmission);
			preparedStatement.setString(7, typeFuel);
			preparedStatement.setString(8, engineCapacity);
			preparedStatement.setString(9, driveUnit);
			preparedStatement.setString(10, mileage);
			preparedStatement.execute();
			
			
		} catch (SQLException e) {
			LOGGER.fatal("SQLException in DAO", e);
			throw new DAOException("SQLException",e);
			
		} catch (InterruptedException e) {
			LOGGER.fatal("SQLException in DAO", e);
			throw new DAOException("InterruptedException",e);
		}
		
	}
	

	@Override
	public List<?> getList(int ID) {
		
		return null;
	}

	

}
