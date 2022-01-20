import java.util.Scanner;

public class ExceptionDemo1 {

	public static int div(int a , int b) {
		int c =0;
		try {
			c = a / b;
			
			String s = null;// it is not ref any object
			// s.length()===> NPE 
			System.out.println(s.length()); // NPE object
			// NPE will be raised
			return c;
			// inside the try or catch block then 
			// before returning the value it will execute the finally block 
			// and then it will return the value.
		}
		
		catch (ArithmeticException e) {
			// can u write a code which will work only for non zero value 
			// acceptance?
			System.out.println("enter the value for b again");
			Scanner scanner = new Scanner(System.in);
			
			int d = scanner.nextInt();
			
			c  = a/ d;
			return c;
		}
		catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("npe caught");
		}
		catch (Exception e) {
			// TODO: handle exception
			if(e instanceof NullPointerException) {
				
			}
			if (e instanceof ArithmeticException ) {
				
			}
			System.out.println("any exception can be handled by this handler");
		}
		finally {
		System.out.println("hello from Zee");
		// 
		}
		return c;
		
		
	}
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			System.out.println("enter the number");
			int a = scanner.nextInt();
			System.out.println("enter the value for b");
			int b = scanner.nextInt();
			
			int result = div(a, b);
			System.out.println(result);
		} catch (ArithmeticException e) {
			// TODO Auto-generated catch block
			System.out.println("inside the catch block");
			e.printStackTrace();
		}
		
		System.out.println("hello from abhi");
	}
}
