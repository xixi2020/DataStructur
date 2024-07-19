package JavaSe.Thread;

import java.util.ArrayList;
import java.util.List;
//消费者-生产者线程，交替工作运行，有一个产品生产了就立刻消费
//利用wait()和notify()方法来控制条件，并且这两个方法是所有对象自带的方法
//在这里用线程来模仿工厂模式：消费者生产者模式
public class ThreadFactory {
	public static void main(String[] args) {
		List list=new ArrayList();
		Thread t1=new Thread(new producer(list));
		Thread t2=new Thread(new Customer(list));
		t1.setName("生产者线程");
		t2.setName("消费者线程");
		t1.start();
		t2.start();
		
	}

}
//这里是生产者线程
class producer implements Runnable{
    private List list;
    public producer(List list) {
    	this.list=list;
    }
    
	@Override
	//如果仓库中有产品就不消费
	public void run() {
		//设置一个死循环,表示一直生产
		while(true) {
			//加锁使其占用锁
			synchronized(list){
			if(list.size()>0) {
				try {
					list.wait();//若集合中还有产品用wait来释放锁，进入等待状态
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//若仓库没有满
			Object obj=new Object();
			list.add(obj);
			System.out.println(Thread.currentThread().getName()+"---->"+obj);
			//唤醒消费者消费
			list.notifyAll();
		}
		
	}
	
}
}
//这里是消费者线程
class Customer implements Runnable{
	private List list;
    public Customer(List list) {
    	this.list=list;
    }
	@Override
	public void run() {
		while(true) {
			//加锁使其占用锁
			synchronized(list){
			if(list.size()==0) {
				try {
					list.wait();
			//若集合中没有产品用wait来释放锁，进入等待状态
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//若仓库满了
			Object obj=new Object();
			obj=list.remove(0);//删除第几个下标元素
			System.out.println(Thread.currentThread().getName()+"---->"+obj);
			//唤醒生产者生产
			list.notifyAll();
		}
		
	}		
	}
	
}