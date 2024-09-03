package designPattern.factoryPattern;

/**
 * 工厂方法模式：解决简单工厂模式需要增加新产品时还要修改工厂类的代码，违反开闭原则的问题
 * 使用 '简单工厂模式' 来设计一个咖啡店点餐系统。设计一个咖啡类 (Coffee) ，并定义其两个子类 (美式咖啡AmericanCoffee 和 拿铁咖啡LatteCoffee)，
 * 再设计一个咖啡店类 (CoffeeStore)，咖啡店具有点咖啡的功能。
 *
 * 每一种产品都设置一个相对应的工厂，具体实现放在实现的子类中中完成
 */
public class FactoryMethodPattern {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore(new LatteCoffeeFactory());
        coffeeStore.orderCoffee();
    }
}
//咖啡店
class CoffeeStore{
    private CoffeeFactory coffeeFactory;

    public CoffeeStore(CoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }
    public Coffee orderCoffee() {
        Coffee coffee = coffeeFactory.createCoffee();
        coffee.addMilk();
        coffee.addSuger();
        coffee.getName();
        return coffee;
    }
}

//实现抽象工厂中的抽象方法，完成具体产品的创建
class LatteCoffeeFactory implements CoffeeFactory{

    @Override
    public Coffee createCoffee() {
        return new LatteCoffee("latte");
    }
}

class AmericanoCoffeeFactory implements CoffeeFactory{

    @Override
    public Coffee createCoffee() {
        return new AmerciaCoffee("amerciano");
    }
}


//具体产品类：需要生产的产品
class AmerciaCoffee implements Coffee{

    String name;

    public AmerciaCoffee(String name) {
        this.name = name;
    }

    @Override
    public void getName() {
        System.out.println("咖啡:"+ name);
    }

    @Override
    public void addMilk() {
        System.out.println("美式建议不加奶");
    }

    @Override
    public void addSuger() {
        System.out.println("美式建议不加糖");
    }
}
class LatteCoffee implements Coffee{

    String name;

    public LatteCoffee(String name) {
        this.name = name;
    }

    @Override
    public void getName() {
        System.out.println("咖啡:"+ name);;
    }

    @Override
    public void addMilk() {
        System.out.println("拿铁加奶");
    }

    @Override
    public void addSuger() {
        System.out.println("拿铁可加糖");
    }
}