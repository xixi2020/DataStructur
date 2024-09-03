package designPattern.singletonPattern;

/**
 * 单例模式：懒加载
 * 被外部类调用的时候内部类才会加载
 */
public class LazySingleton {
    //普通懒加载单例模式:多线程模式下会得到多个实例
    public static LazySingleton lazySingleton;
    public LazySingleton(){}

    //两个线程同时运行GetInstance方法时
    // 此时两个线程判断(uniqueInstance ==null)这个条件时都返回真，此时两个线程就都会创建Singleton的实例
    public static LazySingleton getLazySingleton(){
        if (lazySingleton == null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
//这里实现线程安全的懒加载:双重检查锁
class SynLazySingleton{
    //这里用volatile修饰
    public static volatile SynLazySingleton synLazySingleton;
    private SynLazySingleton(){}

    public static SynLazySingleton getSynLazySingleton(){
        //第一重检查
        if (synLazySingleton == null){
            synchronized (SynLazySingleton.class){
                if (synLazySingleton == null){
                    synLazySingleton = new SynLazySingleton();
                }

            }
        }
        return synLazySingleton;
    }
}

/**
 * 优化：懒汉式内部类单例模式
 * 静态内部类单例模式中实例由内部类创建，
 * 由于JVM在加载外部类的过程中是不会加载静态内部类的，只有内部类的属性方法被调用时才会被加载并初始化其静态属性。
 * 静态属性由于被static修饰，保证只被实例化一次，并且严格保证实例化顺序。
 */
class InnerLazyStaticSingleton{
    private volatile static InnerLazyStaticSingleton singleton;
    private InnerLazyStaticSingleton(){}
    //第一次加载Singleton类时不会去初始化INSTANCE，只有第一次调用getInstance
    //虚拟机加载SingletonHolder并初始化INSTANCE，这样不仅能确保线程安全，也能保证Singleton类的唯一性。
    public static class Singlton{
        public static final InnerLazyStaticSingleton SINGLETON = new InnerLazyStaticSingleton();
    }
    //对外提供获取静态内部类的方法
    public InnerLazyStaticSingleton getSingleton(){
        return Singlton.SINGLETON;
    }
}

