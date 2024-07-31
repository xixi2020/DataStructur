package JavaSe.juc.rLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 这里演示线程的交替输出
 */
public class outputAlternately{

    public static void main(String[] args) {
        //这里是许可，代表交替输出几次
        AwaitSignal awaitSignal = new AwaitSignal(3);
        Condition condition01 = awaitSignal.newCondition();
        Condition condition02 = awaitSignal.newCondition();
        Condition condition03 = awaitSignal.newCondition();

        new Thread(() -> awaitSignal.print("a", condition01, condition02)).start();
        new Thread(() -> awaitSignal.print("b", condition02, condition03)).start();
        new Thread(() -> awaitSignal.print("c", condition03, condition01)).start();

        //Condition的await()方法让线程等待，使用signal（）方法唤醒线程
        try {

            Thread.sleep(1000);
            awaitSignal.lock();
            //开始唤醒第一个线程，由第一个线程唤醒下一个
            condition01.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            awaitSignal.unlock();
        }

    }

}
class AwaitSignal extends ReentrantLock {
    //获取许可的数量，也就是要交替输出多少次
    private int number;

    public AwaitSignal( int number) {
        this.number = number;
    }

    /**
     * 每个条件变量结束后唤醒下一个
     * @param str 输出的内容
     * @param condition 条件变量
     * @param next 获取下一次的条件变量
     */
    public void print(String str, Condition condition, Condition next){

        for (int i = 0; i < number; i++) {
            lock();
            try {
                condition.await();
                System.out.println(str);
                //唤醒下一个条件变量
                next.signal();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                unlock();
            }
        }

    }
}
