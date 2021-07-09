package JavaSessions;

interface FirstInterface {
	public void myMethod(); // interface method
}

interface SecondInterface {
	public void myOtherMethod(); // interface method
}

class DemoClass implements FirstInterface, SecondInterface {
	public void myMethod() {
		System.out.println("Some text... from FirstInterface - myMethod() method");
	}

	public void myOtherMethod() {
		System.out.println("Some other text...from SecondInterface - myOtherMethod() method");
	}
}

class InterfaceMultiple {
	public static void main(String[] args) {
		DemoClass myObj = new DemoClass();
		myObj.myMethod();
		myObj.myOtherMethod();
	}
}
