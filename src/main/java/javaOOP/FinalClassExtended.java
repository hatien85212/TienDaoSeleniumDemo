package javaOOP;

public class FinalClassExtended extends Vehicle { // can not subclass from final class
	private String modelName = "Mustang";

	public static void main(String[] args) {
		FinalClassExtended myFastCar = new FinalClassExtended();
		
		myFastCar.honk(); // method inheritance
		System.out.println(myFastCar.brand + " " + myFastCar.modelName); //
		
		Vehicle vehicle = new Vehicle();
		vehicle.honk();
		String a = vehicle.brand;
	}

}
