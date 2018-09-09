package Singleton;

import static org.junit.Assert.*;
import org.junit.Test;

public class SingletonCoordinateTest {
	
	@Test
	public void canReturnSameFieldValues() {

		SingletonCoordinate s1 = SingletonCoordinate.getInstance();
		SingletonCoordinate s2 = SingletonCoordinate.getInstance();
		
		assertEquals(s1.getLatitude(), s2.getLatitude(),0.00001 );
		assertEquals(s1.getLongitude(), s2.getLongitude(),0.00001);		
	}
	
	@Test
	public void canReturnSameMemoryLocation() {
		
		SingletonCoordinate s1 = SingletonCoordinate.getInstance();
		SingletonCoordinate s2 = SingletonCoordinate.getInstance();

		assertEquals(s1,s2);		
	}

}
