package JavaSe.Thread;

//测试 testmain方法必须为public首先Java规定bai了main()方法必须是公共的，
//以便于外du部程序对主方法的访问，zhi因为程序都是从daomain()方法起始的，并且main()方法也必须是静态的，很大程度上这是为了安全性的考虑
public class test_Account{
	public static void main(String[] args){
//		//NEW一个共享账户
//		Account ac1=new Account("ac1",10000);
//		Thread t1=new Thread(new ThreadAccount(ac1,5000));
//		Thread t2=new Thread(new ThreadAccount(ac1,5000));
//		t1.setName("t1");
//		t2.setName("t2");
//		t1.start();//启动线程
//		t2.start();
//		//结果可能为t1取款:5000.0余额5000.0
//		//           t2取款:5000.0余额5000.0
//		//出现错误出现延迟会取 两次5000但是余额仍然为5000

		System.out.println("hello,world");

	}
}