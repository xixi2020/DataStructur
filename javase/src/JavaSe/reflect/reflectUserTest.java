package JavaSe.reflect;
//这里使用newinstance方法来反射某个类的构造方法
//forName（）方法会导致类加载，把类加载到jvm中去
public class reflectUserTest {
    public static void main(String[] args) {
    	try {
    	    Class c=Class.forName("reflect.reflectUser");
    	    //具有灵活性，把此路径变为属性文件.properties的地址
    	    //这样就可以不用改代码就将其构造函数反射出
				Object obj=c.newInstance();
				//这个方法会调用此reflectUser类的无参构造，有参方法会报错
				//所以一般的构造方法最好有一个无参构造
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
    	    }catch(ClassNotFoundException e) {
    		    e.printStackTrace();
    	    //拿到一个文件的绝对路径
    		//当前线程的类加载器对象
        String pathName=Thread.currentThread().getContextClassLoader()
        	//当前线程的类加载器对象的方法加载当前类加载器以及父类加载器所在路径的资源文件
        		.getResource("user.properties").getPath();
    /*这里getResource("user.properties")不可以为getResources
     getResource:加载当前类加载器以及父类加载器所在路径的资源文件，将遇到的第一个资源文件直接返回！！！
          比如当前工程类路径有conf/demo.properties文件,引入的第三方jar包也有这个文件，返回的是当前工程下的这个
          资源文件。
     getResources：遇到的所有资源文件全部返回！比如当前工程类路径有conf/demo.properties文件,引入的
          第三方jar包也有这个文件全部返回*/
    	}
    }
}
