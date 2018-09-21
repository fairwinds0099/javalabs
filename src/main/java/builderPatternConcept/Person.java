package builderPatternConcept;

public class Person {
	String firstname;
	String lastname;
	int ssn;
	Car car;
	Address address;
	
	private Person(Builder builder) {
		this.firstname = builder.firstname;
		this.lastname = builder.lastname;
		this.ssn = builder.ssn;
		this.car = builder.car;
		this.address = builder.address;		
	}
	
	@Override
	public String toString() {
		return "Personal Info:\n"+ this.getFirstname()+ " " + this.getLastname() + " " + this.getSsn() + "\n"
				+ this.getCar() + this.getAddress();
	}
	
	
	
	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}




	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}




	/**
	 * @return the ssn
	 */
	public int getSsn() {
		return ssn;
	}




	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}




	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}




	public static class Builder {
		String firstname;
		String lastname;
		int ssn;
		Car car;
		Address address;

		public Builder firstname(final String firstname) {
			this.firstname= firstname;
			return this;
		}
		
		public Builder lastname(final String lastname) {
			this.lastname = lastname;
			return this;
		}
		
		public Builder ssn(final int ssn) {
			this.ssn = ssn;
			return this;
		}
		
		public Builder address(final Address address) {
			this.address = address;
			return this;
		}
		
		public Builder car(final Car car) {
			this.car = car;
			return this;
		}
		
		public Person build() {
			return new Person(this);
		}
	}

}
