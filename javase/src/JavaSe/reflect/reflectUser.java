package JavaSe.reflect;
//反射机制中的newinstance来反射方法的构造方法
public class reflectUser{
	public reflectUser(){
		System.out.println("hello world");
	}
	//反射机制中的静态代码块
	//静态代码块会在类加载的时候就执行
	static {
		System.out.println("静态方法执行了");
	}
}
