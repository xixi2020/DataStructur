package JavaSe.thread;

public class ThreadAccount implements Runnable{
	//两个线程共享一个账户
    // Account act1=new Account();这里不需要new一个对象 而是直接一个“类型”
    private Account ac1;
    private double money;
    public ThreadAccount(Account ac1,double money) {//构造方法传递参数,账户和取款金额
    	this.ac1=ac1;
    	this.money=money;
	}
     
	@Override
	//多线程并发取钱方法
	public void run() {
		// TODO Auto-generated method stub
	ac1.withdraw(money);
	System.out.println(Thread.currentThread().getName()+"取款:"+this.money+"余额"+ac1.getBalance());
	}

}