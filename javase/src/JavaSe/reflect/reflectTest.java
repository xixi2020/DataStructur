package JavaSe.reflect;
//在这里实现是三种反射机制的类的获取方式
public class reflectTest {
    public static void main(String[] args) {
    	//Class c1=null;
    	//在这里就为全局变量了，在后面就可以调用c1了
    	//
    try {
    	//获取类型的名字
    	//这里的c1为局部变量
    	//try 块是一个小的作用域，在try块中定义的变量都是局部变量，出了这个域则无法调用。
    	//try块的内外均使用同一个变量，需要将变量定义为全局变量，在try块外声明即可
		Class c1=Class.forName("java.lang.String");
		System.out.println(c1);
		Class c3 = Class.forName("java.lang.Integer");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    //第二种方法：对象的getClass方法
    //System.out.println(c1);这里的c1无法被调用
    //
    String s="abc";
    Class c2=s.getClass();
    System.out.println();
    //第三种方法：任何一种类型都有.class属性
    Class c4=String.class;
    System.out.println(c2==c4);
    }
}
