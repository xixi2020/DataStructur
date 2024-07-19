package JavaJdbc.javajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

//在这里封装一个jdbc工具类，将六步封装起来。使代码简便
public class DBUtil {
	//注册只需要一次所以用静态代码块，类加载的时候就使用且只加载一次
	//这里依然用资源绑定器
    /* 工具类中的构造方法是私有的。
           因为工具类中的方法都是静态的，直接通过类名去调即可。
     */
	private DBUtil(){}//若这里的修饰符是public就可以用 实例化，否则方法必须为静态的
	//1、注册
	static {
	ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
	String driver=bundle.getString("driver");
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	//2、获取连接
	public static Connection getConnection(String url,String user,String password) {
		Connection conn = null;
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
   //3、获取数据库连接对象

    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
