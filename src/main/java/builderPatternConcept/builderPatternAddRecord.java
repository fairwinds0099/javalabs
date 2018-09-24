package builderPatternConcept;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class builderPatternAddRecord {

	public static void main(String[] args) throws FileNotFoundException {
		
		String filePath = new File("").getAbsolutePath();
		File file = new File(filePath + "\\src\\main\\java\\builderPatternConcept\\Test.txt");
		
		if ( !file.exists() ) {
			System.out.println(file.getName()+ " does not exist");
			System.exit(1);			
		}
		
		ArrayList<Person> arraylist = new ArrayList<Person>(1); 

		Scanner input = new Scanner(file);	
		
		while(input.hasNextLine()) {
			String record = input.nextLine().trim();
			String [] array = record.split(";");
			
			
			String firstname = array[0];
			String lastname = array[1];
			int ssn = Integer.parseInt(array[2].trim());
			int housenumber = Integer.parseInt(array[3].trim());
			String streetname = array[4];
			String cityname = array[5];
			String state = array[6];
			int zipcode = Integer.parseInt(array[7].trim());
			int modelyear = Integer.parseInt(array[8].trim());
			String make = array[9];
			String model = array[10];
			
			
			
			Car car = new Car.Builder().year(modelyear)
									   .make(make)
									   .model(model)
									   .build();
			
			Address addres = new Address.Builder().houseNumber(housenumber)
												  .street(streetname)
												  .city(cityname)
												  .state(state)
												  .zipcode(zipcode)
												  .build();
			
			Person person = new Person.Builder().firstname(firstname)
												.lastname(lastname)
												.ssn(ssn).car(car)
												.address(addres)
												.build();
	
			arraylist.add(person);
			
			person = null;		
		
		}
		
	System.out.println("List of People: ");
	
	int i = 0;
	for (Person element:arraylist) {
		System.out.println("" + ++i +"  "+  element);
		
	}
		
		
		
	 input.close();

	} // main
	

	

} // class
