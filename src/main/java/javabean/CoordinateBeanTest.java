package javabean;

import static org.junit.Assert.*;

import org.junit.Test;


public class CoordinateBeanTest {
	
	@Test
	public void canCreateCoordinateBean() {
		
		CoordinateBean coordinatebean = new CoordinateBean();
		coordinatebean.setLatitude(39.0);
		coordinatebean.setLongitude(36.0);		
		
		assertEquals(39.0,coordinatebean.getLatitude(),0.0001);
		assertEquals(36.0, coordinatebean.getLongitude(), 0.0001);		
	}

}
