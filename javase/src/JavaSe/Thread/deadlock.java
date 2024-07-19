package JavaSe.Thread;
//在这里试着写一个死锁
//死锁是指不出现异常和报错，但是程序一直僵持在那里，无法解锁
public class deadlock {
	public static void main(String[] args) {
		//两个线程共同使用o1,o2两个对象资源
		Object o1=new Object();
		Object o2=new Object();
		//创建两个线程
		Thread t1=new Thread();
		Thread t2=new Thread();
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	
	}

}
//第一个线程
class MyThread01 extends Thread{
	private Object o1;
	private Object o2;
	//构造方法传入两个对象参数
	public MyThread01(Object o1,Object o2) {
		this.o1=o1;
		this.o2=o2;	}
	//创建死锁，用嵌套synchronized
	public void run(){
	synchronized(o1) {
		
		synchronized(o2) {
			System.out.println("02的对象");
		}
	}
	}
	}
//第二个线程
class MyThread02 extends Thread{
	private Object o1;
	private Object o2;
	//构造方法传入两个对象参数
	public MyThread02(Object o1,Object o2) {
		this.o1=o1;
		this.o2=o2;	
	}
	public void run(){
		synchronized(o2) {
			synchronized(o1) {
				System.out.println("01的对象");
			}
		}
		}
}