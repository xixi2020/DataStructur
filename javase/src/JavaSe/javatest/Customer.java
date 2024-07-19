package JavaSe.javatest;

public class Customer {
	FoodManu foodMenu;
	Customer(){
		
	}
	Customer(FoodManu foodMenu){
		this.foodMenu=foodMenu;
	}
	public void setFoodMenu(FoodManu foodMenu) {
		this.foodMenu=foodMenu;
	}
	 
	public FoodManu getFoodMenu() {
		return this.foodMenu;
	}
	public void order() {
		foodMenu.shizichaodan();
		foodMenu.yuxiangyousi();
	}

}
