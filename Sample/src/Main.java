
public class Main {

	public static final int a =100;
	// to declare the constants .
	
	public static void main(String[] args) {
		
		//Employee employee = new Employee("ab001", "abhi", "chivate", 123.0f);
		Employee manager = new Manager("Zee", 1000.0f);
		
		System.out.println(manager);
		System.out.println(manager.calculateSalary());
		
		
	}
}
