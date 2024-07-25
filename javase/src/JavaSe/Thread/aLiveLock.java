package JavaSe.thread;

/**
 * 这里来解决死锁问题
 */
public class aLiveLock {

    //创建两个互斥的资源
    static Object resource01 = new Object() ;
    static Object resource02 = new Object();

    public static void main(String[] args) {

        new Thread(new Thread(() -> {
            synchronized (resource01){

                try {
                    System.out.println("线程1获取了资源1");
                    Thread.sleep(2000);
                    synchronized (resource02){
                        System.out.println("线程1获取了资源2");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        })).start();

        new Thread(new Thread(() -> {
            synchronized (resource01){

                try {
                    System.out.println("线程2获取了资源1");
                    Thread.sleep(2000);
                    synchronized (resource02){
                        System.out.println("线程2获取了资源2");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        })).start();
    }
}
