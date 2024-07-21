package JavaSe.thread;
//这个程序演示守护线程（后台线程）
//由两个线程组成，一个主线程，一个守护进程
//即使是死循环也会等到主线程结束，守护线程才结束
public class Thread_shouhu {
	public static void main(String[] args) {
		Thread t1=new Thread(new MyThread_Shou() );
		t1.setName("备份线程");
		//只需要调用线程的这个方法就可以
		t1.setDaemon(true);
		//主线程输出
		t1.start();
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName()+"---->"+i);
			//这一句必放在for中这样才能确保都执行一次
		try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		}
	    
		//将t1设为守护线程
		
	}

}
class MyThread_Shou implements Runnable{
    
	@Override
	public void run() {
		//创建一个死循环
		int i=0;
		while(true) {
			System.out.println(Thread.currentThread().getName()+"---->"+(++i));
			//这一句必放在循环中这样才能确保都执行一次
			 try {
		            Thread.sleep(1000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		}
	   
		
	}
	
	
}