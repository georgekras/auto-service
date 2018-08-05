package by.htp.dao.impl;

public class SQLquery {
	
	private SQLquery() {
		
	}
	
	public static final String SIGN_IN = "SELECT ID, login, password, status, email FROM `service-mercedes`.user WHERE login=? AND password=? AND status = '1'";
	public static final String SIGN_UP = "INSERT INTO `service-mercedes`.user (login, password,status,email) VALUES (?, ?, ?, ?)";
	public static final String CHECK_LOGIN = "SELECT login FROM `service-mercedes`.user WHERE login=?";
	public static final String DELETE_USER = "UPDATE `service-mercedes`.user SET status='0' WHERE id= ?";
	public static final String SELECT_USER_ID = "SELECT ID FROM `service-mercedes`.user WHERE login=? AND status = '1'";
	
	public static final String SELECT_ALL_VEHICLE = "SELECT * FROM `service-mercedes`.vehicle WHERE status='1'";
	public static final String ADD_VEHICLE = "INSERT INTO `service-mercedes`.vehicle (model, status, year, typeCarcase, price, transmission, typeFuel, engineCapacity, driveUnit, mileage) VALUES (?,?,?,?,?,?,?,?,?,?)";
	
	
	
	public static final String ID = "ID";
	public static final String STATUS = "status";
	public static final String EMAIL = "email";
	
	public static final String MODEL = "model";
	public static final String YEAR = "year";
	public static final String TYPE_OF_CARCASE = "typeCarcase";
	public static final String PRICE = "price";
	public static final String TRANSMISSION = "transmission";
	public static final String TYPE_OF_FUEL = "typeFuel";
	public static final String ENGINE_CAPACITY = "engineCapacity";
	public static final String DRIVE_UNIT = "driveUnit";
	public static final String MILEAGE = "mileage";
	
	
	
}
