package JavaSe.JavaWorryTest;
//在这里研究一下形参的调用
public class canshu {
    public int tryChange(int i) {
    	i=i*2;
    	return i;
    }
   /* public void showchange() {
    	//int i=10;//这里规定了i为实参，两个方法无法进行值传递，必须要主函数传值进去
    	 *         //两个参数不互相影响
    	//System.out.println("调用方法之前："+i);
    	tryChange(1);
    	System.out.println("调用方法之后："+i);  	
    }*/
    public static void main(String[] args) {
    	canshu cs=new canshu();
    	System.out.println("调用方法之后："+cs.tryChange(10)); 
    }
}
