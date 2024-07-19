package JavaJdbc.javajdbc;
import java.sql.*;
public class jdbcTest02 {
	public static void main(String[] args) {
		Connection conn=null;
		Statement stat=null;
		//1、注册
		try {
			//另一种驱动方式：一般常用这种方式
			//Driver()底层是用静态代码块实现了，所以直接类加载就可以
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//DriverManager.deregisterDriver(new com.mysql.cj.jdbc.Driver());
		//2、获取连接
			String url="jdbc:mysql://127.0.0.1/bjpowernode?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
			String user="root";
			String password="root";
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("获取的数据库为"+conn);
		//3、获取数据库操作对象
			stat=conn.createStatement();
		//4、执行sql语句
			int count=stat.executeUpdate("delete from t_student where name='lisi';");
			//在这里执行删除操作
			System.out.println(count==1?"删除成功":"删除失败");
		//5、处理sql查询结果
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
		//6、释放资源
			try {
				if(conn!=null) {
					conn.close();
				}
			}catch(SQLException e) {
					e.printStackTrace();
				}
			try {
				if(stat!=null) {
					stat.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			}
		}
	}

