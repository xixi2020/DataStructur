package designPattern.singletonPattern;

/**
 * 优化：静态内部类的方式
 */
public class StaticLazySingleton {

        private volatile static StaticLazySingleton staticLazySingleton;
        private StaticLazySingleton(){}

    /**
     * JVM在加载外部类的过程中是不会加载静态内部类的,只有内部类的属性方法被调用时才会被加载并初始化其静态属性。
     * 静态属性由于被static修饰，保证只被实例化一次，并且严格保证实例化顺序。
     * 仅能确保线程安全，也能保证Singleton类的唯一性
     */
        public static class SingletonHandler {
            public static final StaticLazySingleton SINGLETON = new StaticLazySingleton();
        }

    public static StaticLazySingleton getStaticLazySingleton() {
        return SingletonHandler.SINGLETON;
    }
}
