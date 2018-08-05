package by.htp.entity;

public class Vehicle {
	
	
	// ID
	private int ID;
	//модель
	private String model;
	//год выпуска
	private String year;
	//тип кузова
	private String typeCarcase;
	//цена
	private String price;
	//трансмиссия
	private String transmission;
	//тип топлива
	private String typeFuel;
	//объем двигателя
	private String engineCapacity;
	//привод
	private String driveUnit;
	//пробег
	private String mileage;
	
	
	
	
	public Vehicle() {
		
	}
	
	
	public Vehicle(int ID, String model, String year, String typeCarcase, String price, String transmission, String typeFuel, String engineCapacity, String driveUnit, String mileage) {
		this.ID = ID;
		this.model = model;
		this.year = year;
		this.typeCarcase = typeCarcase;
		this.price = price;
		this.transmission = transmission;
		this.typeFuel = typeFuel;
		this.engineCapacity = engineCapacity;
		this.driveUnit = driveUnit;
		this.mileage = mileage;
		
	}
	
	public Vehicle(String model, String year, String typeCarcase, String price, String transmission, String typeFuel, String engineCapacity, String driveUnit, String mileage) {
		this.model = model;
		this.year = year;
		this.typeCarcase = typeCarcase;
		this.price = price;
		this.transmission = transmission;
		this.typeFuel = typeFuel;
		this.engineCapacity = engineCapacity;
		this.driveUnit = driveUnit;
		this.mileage = mileage;
		
	}
	
	
	
	@Override
	public String toString() {
		return "Vehicle [ID=" + ID + ", model=" + model + ", year=" + year + ", type_of_carcase=" + typeCarcase
				+ ", price=" + price + ", transmission=" + transmission + ", typeFuel=" + typeFuel + ", engineCapacity="
				+ engineCapacity + ", driveUnit=" + driveUnit + ", mileage=" + mileage + "]";
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getType_of_carcase() {
		return typeCarcase;
	}
	public void setType_of_carcase(String type_of_carcase) {
		this.typeCarcase = type_of_carcase;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getTypeFuel() {
		return typeFuel;
	}
	public void setTypeFuel(String typeFuel) {
		this.typeFuel = typeFuel;
	}
	public String getEngineCapacity() {
		return engineCapacity;
	}
	public void setEngineCapacity(String engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	public String getDriveUnit() {
		return driveUnit;
	}
	public void setDriveUnit(String driveUnit) {
		this.driveUnit = driveUnit;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ID ^ (ID >>> 32));
		result = prime * result + ((driveUnit == null) ? 0 : driveUnit.hashCode());
		result = prime * result + ((engineCapacity == null) ? 0 : engineCapacity.hashCode());
		result = prime * result + ((mileage == null) ? 0 : mileage.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((transmission == null) ? 0 : transmission.hashCode());
		result = prime * result + ((typeFuel == null) ? 0 : typeFuel.hashCode());
		result = prime * result + ((typeCarcase == null) ? 0 : typeCarcase.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}






	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (ID != other.ID)
			return false;
		if (driveUnit == null) {
			if (other.driveUnit != null)
				return false;
		} else if (!driveUnit.equals(other.driveUnit))
			return false;
		if (engineCapacity == null) {
			if (other.engineCapacity != null)
				return false;
		} else if (!engineCapacity.equals(other.engineCapacity))
			return false;
		if (mileage == null) {
			if (other.mileage != null)
				return false;
		} else if (!mileage.equals(other.mileage))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (transmission == null) {
			if (other.transmission != null)
				return false;
		} else if (!transmission.equals(other.transmission))
			return false;
		if (typeFuel == null) {
			if (other.typeFuel != null)
				return false;
		} else if (!typeFuel.equals(other.typeFuel))
			return false;
		if (typeCarcase == null) {
			if (other.typeCarcase != null)
				return false;
		} else if (!typeCarcase.equals(other.typeCarcase))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

}
