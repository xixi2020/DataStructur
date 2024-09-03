package designPattern.factoryPattern;

/**
 * 抽象工厂方法设计模式：为了解决工厂方法设计模式一个工厂只创建单个产品的缺点
 * 现咖啡店业务发生改变，不仅要生产咖啡还要生产甜点，如提拉米苏、抹茶慕斯等，要是按照工厂方法模式
 * 需要定义提拉米苏类、抹茶慕斯类、提拉米苏工厂、抹茶慕斯工厂、甜点工厂类，很容易发生类爆炸情况。
 * 其中拿铁咖啡、美式咖啡是一个产品等级，都是咖啡；
 * 提拉米苏、抹茶慕斯也是一个产品等级；
 * 拿铁咖啡和提拉米苏是同一产品族（也就是都属于意大利风味），
 * 美式咖啡和抹茶慕斯是同一产品族（也就是都属于美式风味）。
 *
 */
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractCoffeeStore coffeeStore = new AbstractCoffeeStore(new AmericaFactory());
        coffeeStore.orderCoffee();
        coffeeStore.orderDessert();
    }
}

//咖啡店
class AbstractCoffeeStore{
    private DessertCoffeeFactory factory;

    public AbstractCoffeeStore(DessertCoffeeFactory factory) {
        this.factory = factory;
    }
    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();
        coffee.addMilk();
        coffee.addSuger();
        coffee.getName();
        return coffee;
    }

    public void orderDessert(){
        Dessert dessert = factory.createDessert();
        dessert.show();
    }
}
//工厂实现类：美式风格工厂
class AmericaFactory implements DessertCoffeeFactory{

    @Override
    public Coffee createCoffee() {
        return new AbstractAmerciaCoffee("amerciano");
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}

class ItalyFactory implements DessertCoffeeFactory{

    @Override
    public Coffee createCoffee() {
        return new AbstractLatteCoffee("latte");
    }

    @Override
    public Dessert createDessert() {
        return new Tiramisu();
    }
}
//具体产品类：需要生产的产品
class AbstractAmerciaCoffee implements Coffee{

    String name;

    public AbstractAmerciaCoffee(String name) {
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
class AbstractLatteCoffee implements Coffee{

    String name;

    public AbstractLatteCoffee(String name) {
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
class Tiramisu extends Dessert{

    @Override
    public void show() {
        System.out.println("提拉米苏制作好了");
    }
}
class MatchaMousse extends Dessert{

    @Override
    public void show() {
        System.out.println("抹茶慕斯制作完成");
    }
}