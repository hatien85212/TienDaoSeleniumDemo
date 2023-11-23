package javaOOP;

final class Vehicle { //can not extend from final class
	protected String brand = "Ford";

	public void honk() {
		System.out.println("Tuut, tuut!");
	}
}

//class Main extends Vehicle {
//	private String modelName = "Mustang";
//
//	public static void main(String[] args) {
//		Main myFastCar = new Main();
//		myFastCar.honk();
//		System.out.println(myFastCar.brand + " " + myFastCar.modelName);
//	}
//}