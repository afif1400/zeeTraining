
public abstract class AbstractDemo 
implements Interface1, Interface2, Interface3
{
 // common required implementation 
	// we can write it inside the abstract class
	// uncommon one ===> don't override them ? bcoz that impl will be 
	// done by the respective child class
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("hello from method1");
	}
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("method 2 called");
	}
	
	public static void main(String[] args) {
		
		Interface1 interface1 = new Demo2();
		Interface3 interface3 = new Demo2();
		interface1.method1();
		interface3.method1();
	}
}
// AbstractDemo demo = new Demo();

class Demo2 extends AbstractDemo {
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("hello from method1");
	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method5() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method6() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method7() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method8() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method9() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method10() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void method12() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method13() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method14() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method15() {
		// TODO Auto-generated method stub
		
	}
	
}
class Demo extends AbstractDemo{

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method4() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method5() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method6() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method7() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method8() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method9() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method10() {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void method12() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method13() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method14() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method15() {
		// TODO Auto-generated method stub
		
	}
	
}
