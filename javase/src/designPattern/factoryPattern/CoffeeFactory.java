package designPattern.factoryPattern;
//提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法来创建产品
public interface CoffeeFactory {
    Coffee createCoffee();
}
