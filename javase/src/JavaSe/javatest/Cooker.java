package JavaSe.javatest;

public class Cooker implements FoodManu{
	String cooker;
	Cooker(String cooker){
		this.cooker=cooker;
	}

	public void shizichaodan() {
		System.out.println("this is"+this.cooker+"made");
		
	}

	@Override
	public void yuxiangyousi() {
		System.out.println("this is"+this.cooker+"made");
		
	}
}
class AmericaCooker extends Cooker{

	AmericaCooker(String cook) {
		super(cook);
		// TODO Auto-generated constructor stub
	}
	
}
class ChinaCooker extends Cooker{

	ChinaCooker(String cook) {
		super(cook);
		// TODO Auto-generated constructor stub
	}
	
}