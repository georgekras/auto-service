package by.htp.service;

import by.htp.entity.Vehicle;
import by.htp.service.exception.ServiceException;

import java.util.Map;

public interface AppService {
	
	public Map<Integer, Vehicle> getPortianCars() throws ServiceException;
	boolean addVehicle(String model, String year, String typeCarcase, String price, String transmission, String typeFuel, String engineCapacity, String driveUnit, String mileage) throws ServiceException;

	
	
}
