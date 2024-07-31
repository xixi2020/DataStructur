package JavaSe.juc.rLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 等待停止机制：JUC.Condition.await
 */
public class ConditionAwait {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("a开始被阻塞啦");
                try {
                    lock.lock();
                    condition.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally {
                    lock.unlock();
                }
                System.out.println("A被B唤醒");
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                condition.signal();
                System.out.println("B开始唤醒A");
                lock.unlock();
            }
        },"B").start();

    }
}
