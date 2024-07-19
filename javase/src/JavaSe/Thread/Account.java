package JavaSe.Thread;
//这里模拟两个账户同时取款过程中的建立账户
public class Account {
    private String Ac;
    private double balance;
    public Account() {}//构造方法
    //账户中有两个属性
    public Account(String Ac, double balance) {
    	this.Ac=Ac;
    	this.balance=balance;
    }
    //获取账户的账户和存款数额
    public String getAc() {
    	return Ac;
    	
    }
    public void setAc(String Ac) {//更新数据
    	this.Ac=Ac;
    }
    public double getBalance() {
    	return balance;
    }
    public void setBalance(double balance) {//更新余额
    	this.balance=balance;
    }
   //取款的方法
    public void withdraw(double out_balance) {
    	//存款余额
    	//double before=this.balance;这里不可为this.balance因为此时为初始赋值
    	//使用代码块使线程进入同步等待
    	synchronized(this){ 
    	//（）中的参数一定是所需要同步的线程所共享的对象，在此处为账户对象即this
    		
    	//synchronized("avbc")这里为字符串对象是整个范围，所以包括任何线程对象
    		double before=this.getBalance();
    	//取款后余额
    	    double after=before-out_balance;
    	//有一种情况一定会出错
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    	    this.setBalance(after);//更新取款后的余额
    	}
    }
}
