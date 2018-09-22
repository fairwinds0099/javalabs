package builderPatternConcept;

public class Car {
	private final int year;
	private final String model;
	private final String make;
	
	
	private Car(Builder builder) {
		this.year = builder.year;
		this.model = builder.model;
		this.make = builder.make;
		
	}

	@Override
	public String toString() {
		return "Car info: \n" + this.getYear() + " " + this.getMake() + " " + this.getModel() + "\n";
		//return  this.getYear() + " " + this.getMake() + " " + this.getModel();
	}	
	
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}


	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}


	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}



	public static class Builder{
		private int year;
		private String model;
		private String make;

		
		public Builder year(final int year) {
			this.year = year;
			return this;
		}
		
		public Builder model(final String model) {
			this.model = model;
			return this;
		}
		
		public Builder make(final String make) {
			this.make = make;
			return this;
		}
		
		public Car build() {
			return new Car(this);
		}
	}
}
