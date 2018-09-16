package javabean;
import java.io.Serializable;

public class CoordinateBean implements Serializable {
	private double latitude;
	private double longitude;

	private static final CoordinateBean INSTANCE = new CoordinateBean();
	
	private CoordinateBean() {}
	
	/*public CoordinateBean(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}*/

public static CoordinateBean getInstance() {
	return INSTANCE;
}

	public double getLatitude() {return latitude;}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {return longitude;}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

}
