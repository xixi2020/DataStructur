package JavaJdbc.javajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;
/*PreparedStatement与Ststement区别
 *在mysql语言中有一个机制：只要sql语句与已执行过的语句语法完全相同，那么它不会再次编译，是直接显示结果
 *语法规则：ps会在编译阶段做类型安全检查，会要求数据类型
 *所以几乎都用ps，除非业务要求sql注入或者sql语句需要拼接
 */
//这个是模拟必须要用sql注入的情况
public class jdbcTest06 {
	public static void main(String[] args) {
    	ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
    	String driver=bundle.getString("driver");
    	String url=bundle.getString("url");
    	String user=bundle.getString("user");
    	String password=bundle.getString("password");
    	Connection conn=null;
    	Statement st=null;
    	ResultSet rs=null;
    	Scanner in=new Scanner(System.in);
    	System.out.println("输入desc or asc：");
    	String keyword=in.nextLine();
    	try {
    	 	//注册
			Class.forName(driver);
			//获取连接
			conn=DriverManager.getConnection(url, user, password);
		    System.out.println("连接的数据库是："+conn);
			//获取操作对象
		    st=conn.createStatement();
		    //sql语句执行
		    String sql ="select name from t_student order by name "+keyword;//这里的空格没有会报错
		    //在这里如果使用PerparedStement会自动变成'desc'不符合sql语句格式
		    rs=st.executeQuery(sql);
		    while(rs.next()) {
		    	System.out.println(rs.getString("name"));
		    }
		    
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
    	
    }
}
