package by.htp.service.impl;

import java.util.Map;

import org.apache.log4j.Logger;

import by.htp.dao.AppDAO;
import by.htp.dao.DAOFactory;
import by.htp.dao.exception.DAOException;
import by.htp.entity.Vehicle;
import by.htp.service.AppService;
import by.htp.service.exception.ServiceException;

public class AppServiceImpl implements AppService{
	
	private final static Logger LOGGER = Logger.getLogger(AppServiceImpl.class);

	@Override
	public Map<Integer, Vehicle> getPortianCars() {
		
		Map<Integer, Vehicle> cars = null;
		try {
			cars = DAOFactory.getInstance().getAppDAO().getAllCars();
		} catch (DAOException e) {
			
		}
		return cars;
	}

	@Override
	public boolean addVehicle(String model, String year, String typeCarcase, 
			String price, String transmission, String typeFuel, String engineCapacity, String driveUnit, String mileage) throws ServiceException{
		AppDAO daoFactory = DAOFactory.getInstance().getAppDAO();
		
		try {
			daoFactory.addVehicle(model, year, typeCarcase, price, transmission, typeFuel, engineCapacity, driveUnit, mileage);
		} catch (DAOException e) {
			LOGGER.warn("ServletException in Controller", e);
			throw new ServiceException("ServiceException",e);
		}
		
		return true;
	}

}
