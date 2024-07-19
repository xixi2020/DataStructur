package JavaJdbc.javajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

//用资源绑定器去直接调用propertise配置文件+数据库的删除功能
public class jdbcTest03 {
   public static void main(String[] args) {
	   Connection conn=null;
	   Statement stat=null;
	   //1、注册
	   try {
		//Class.forName("com.mysql.cj.jdbc.Driver");
		//在这里用资源绑定器去读取配置文件当中的数据
		ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
		
	   //2、获取连接
		//在这里最好名字是配置文件中的属性名
		String driver=bundle.getString("driver");
		String url=bundle.getString("url");
		String user=bundle.getString("user");
		String password=bundle.getString("password");
		//在这里driver已经是一个字符串了不用再加""
		//Class.forName("driver");
		Class.forName(driver);
		conn=DriverManager.getConnection(url, user, password);
		System.out.println("数据库为"+conn);
	   //3、获得数据库操作对象
		stat=conn.createStatement();
		int count=stat.executeUpdate("delete from t_student where no=9;");
		System.out.println(count==1?"删除成功":"删除失败");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			if(stat!=null) {
				stat.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null) {
				conn.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
   }
}
