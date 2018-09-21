package builderPatternConcept;

public class Address {
	private final int houseNumber;
	private final String street;
	private final String city;
	private final String state;
	private final int zipcode;
	
	private Address(Builder builder) {
		this.houseNumber = builder.houseNumber;
		this.street = builder.street;
		this.city = builder.city;
		this.state = builder.state;
		this.zipcode = builder.zipcode;		
	}
	
	@Override
	public String toString() {
		return "Address info : \n" + this.getHouseNumber() + " " + this.getStreet() + " " + 
			   this.getCity() + " " + this.getState() + " " + this.getZipcode()+ "\n";
	}
	
	
	
	/**
	 * @return the houseNumber
	 */
	public int getHouseNumber() {
		return houseNumber;
	}




	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}




	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}




	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}




	/**
	 * @return the zipcode
	 */
	public int getZipcode() {
		return zipcode;
	}




	public static class Builder{

		private int houseNumber;
		private String street;
		private String city;
		private String state;
		private int zipcode;
		
		public Builder houseNumber(final int houseNumber) {
			this.houseNumber = houseNumber;
			return this;
		}
		
		public Builder street(final String street) {
			this.street = street;
			return this;
		}
		
		public Builder city(final String city) {
			this.city = city;
			return this;
		}
		
		public Builder  state(final String state) {
			this.state = state;
			return this;
		}
		
		public Builder zipcode(final int zipcode) {
			this.zipcode = zipcode;
			return this;
		}
		
		public Address build() {
			return new Address(this);
		}
		
	}
	
}
