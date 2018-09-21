package builderPatternConcept;

import static org.junit.Assert.*;
import org.junit.Test;

public class PersonTest {
	
	
	
	@Test
	public void canCreateCar() {
		Car car1 = new Car.Builder().year(2010)
                .make("Toyota")
                .model("Corolla")
                .build();		
	
		assertEquals(2010, car1.getYear());
		assertEquals("Toyota", car1.getMake());
		assertEquals("Corolla", car1.getModel());
	
	}
	
	
	
	@Test 
	public void canCreateAddress() {
		Address homeaddress = new Address.Builder().houseNumber(2222)
				   .street("Grand Ave.")
				   .city("Kansas City")
				   .state("KS")
				   .zipcode(66666)
				   .build();
		
		assertEquals(2222, homeaddress.getHouseNumber());
		assertEquals("Grand Ave.", homeaddress.getStreet());
		assertEquals("Kansas City", homeaddress.getCity());
		assertEquals("KS", homeaddress.getState());
		assertEquals(66666, homeaddress.getZipcode());
	
	}
	
	
	
	@Test
	public void canCreatePerson() {

		Car car1 = new Car.Builder().year(2010)
                .make("Toyota")
                .model("Corolla")
                .build();		

		Address homeaddress = new Address.Builder().houseNumber(2222)
												   .street("Grand Ave.")
												   .city("Kansas City")
												   .state("KS")
												   .zipcode(66666)
												   .build();	
		
		Person person = new Person.Builder().firstname("Alex")
											.lastname("Rolex")
											.ssn(11111111)
											.car(car1)
											.address(homeaddress)
											.build();
		
		assertEquals("Alex", person.getFirstname());
		assertEquals("Rolex", person.getLastname());
		assertEquals(11111111, person.getSsn());
		assertEquals(car1,person.getCar());
		assertEquals(homeaddress, person.getAddress());	
	}
	


}
