package JavaSe.thread;
//这个程序演示的是不同方法创建线程
public class threadCreate {
	public static void main(String[] args){
		//MyThread01 t=new MyThread01();//这里是用继承的方法。*/
		//Thread t=new Thread(new MyRunnable());//这里是用实现接口的方法
		// MyRunnable r=new MyRunnable();Thread t=new Thread(r); 


		//3、匿名内部类
		//这个方法直接定义在参数中，这里的new Runnable没有名字
		Thread t=new Thread(new Runnable(){
			public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("线程1"+"---->"+i);
		}
	}});//注意这个括号h
		t.start();//这个方法是开创一个新的分支栈空间，这个方法一开始就立即结束
		          //此时会自动调用t的run方法，run方法在分支栈的底部
		/*t.run();//如果这里不是start方法是调用run方法那么会成为一个单线程*/
	 
		for(int i=0;i<1000;i++) {
			System.out.println("线程2"+"---->"+i);
		}
        		
		
	}
	

}

//1、继承Thread类，只需要new即可
/*class MyThread01 extends Thread{
	public void run() {
		for(int i=0;i<100;i++) {
			System.out.println("线程1"+"---->"+i);
		}
	}
}*/

//2、实现Runnable的接口，这个方法比较常用
/*class MyRunnable implements Runnable{
	public void run() {//这里要重新run方法
		for(int i=0;i<1000;i++) {
			System.out.println("线程1"+"---->"+i);
	}
}}*/
