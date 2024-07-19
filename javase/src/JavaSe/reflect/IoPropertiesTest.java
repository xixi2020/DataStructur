package JavaSe.reflect;

import java.io.FileReader;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

//用流的方式直接返回
public class IoPropertiesTest {
    public static void main(String[] args) throws Exception{

       /* // 获取一个文件的绝对路径了！！！！！
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("classinfo2.properties").getPath();
        FileReader reader = new FileReader(path);*/

        // 直接以流的形式返回。
        InputStream reader = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("user.properties");
        //用资源绑定器来获取配置文件中的内容
        //java.util.ResourceBundle;
        //"user.properties"为错误的名字，需要将properties去除,不然会报错
        ResourceBundle bundle=ResourceBundle.getBundle("user");
        //用资源绑定器来获取文件不需要文件的读写关闭了
        System.out.println(bundle.getString("password1"));//通过key来获取value
        /*Properties pro = new Properties();
        pro.load(reader);
        reader.close();
        // 通过key获取value
        String className = pro.getProperty("password1");//用key来得到value的值
        System.out.println(className);*/
    }
}