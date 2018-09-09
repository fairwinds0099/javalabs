package Singleton;

public class SingletonCoordinate {
	
	private static SingletonCoordinate uniqueInstance = new SingletonCoordinate();
	private double latitude;
	private double longitude;

	
	// It seems to me that it is a good idea to have another parameterized constructor here 
	// to initialize the fields. If I do that way, I do not need to define private setters which are only used once. 
	// Instead, I can use parameterized constructur to initiliaze the fields (aka, latitude and longitude) 
	// What do you think ?
	private SingletonCoordinate() { 
		setLatitude(35.0);
		setLongitude(39.0);
	}
	
	
	public static SingletonCoordinate getInstance() {
		return uniqueInstance;		
	}

	public double getLatitude() {return latitude;}

	private void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {return longitude;}

	private void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	
	
	
}
