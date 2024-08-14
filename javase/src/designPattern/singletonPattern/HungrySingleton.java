package designPattern.singletonPattern;
/**
 * 单例模式：饿汉式
 * 类加载时就创建唯一的单例实例。空间换时间。
 */
public class HungrySingleton {
    //普通方式
    private static HungrySingleton hungrySingleton = new HungrySingleton();
    private HungrySingleton(){}

    private static HungrySingleton getHungrySingleton(){
        return hungrySingleton;
    }

    //静态代码块方式
    private static HungrySingleton hungrySingleton2 = null;

    //静态代码块
    static {
        hungrySingleton2 = new HungrySingleton();
    }

    private HungrySingleton getHungrySingleton2(){
        return this.getHungrySingleton2();
    }
}
