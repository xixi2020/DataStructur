package designPattern.factoryPattern;
//抽象工厂：甜品工厂可以生产一系列产品
public interface DessertCoffeeFactory {
    Coffee createCoffee();
    Dessert createDessert();
}
