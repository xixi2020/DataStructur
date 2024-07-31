package JavaSe.juc.rLock;

/**
 * 使用Object.wait()/notify()来实现一个等待唤醒机制
 * 获取对象锁后才可以调用 `锁对象.wait()`，notify 随机唤醒一个线程，notifyAll 唤醒所有线程去竞争 CPU
 */
public class ObjectWait {
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("a开始被阻塞了");
                synchronized (o){
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("A被B唤醒");
            }
        },"A").start();

//        try {
//            Thread.sleep(2000);
//            System.out.println("wait 2000ms");
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B开始唤醒A");
                synchronized (o){
                    o.notify();
                }
            }
        },"B").start();
    }
}
