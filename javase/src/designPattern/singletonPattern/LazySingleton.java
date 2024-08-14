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



