package by.htp.dao;

import java.util.List;
import java.util.Map;

import by.htp.dao.exception.DAOException;
import by.htp.entity.Vehicle;

public interface AppDAO {
	
	public Map<Integer, Vehicle> getAllCars() throws DAOException;
	public void addVehicle(String model, String year, String typeCarcase, String price, String transmission, String typeFuel, String engineCapacity, String driveUnit, String mileage) throws DAOException;
	public List<?> getList(int ID);
}
