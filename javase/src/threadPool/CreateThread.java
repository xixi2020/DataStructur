package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 这里使用线程池来创建线程：本质是runnable
 */
public class CreateThread {
    public static void main(String[] args) {
        //固定线程个数的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        //分配线程
        for (int i = 0; i < 3; i++) {
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 3; j++) {
                        System.out.println(Thread.currentThread().getName() + ":" + j);
                    }

                }
            });
        }
        threadPool.shutdown();

    }
}
