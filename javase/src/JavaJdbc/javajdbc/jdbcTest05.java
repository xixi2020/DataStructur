package JavaJdbc.javajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

//在这里实现perparedStement的增删改
public class jdbcTest05 {
     public static void main(String[] args) {
    	ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
    	String driver=bundle.getString("driver");
    	String url=bundle.getString("url");
    	String user=bundle.getString("user");
    	String password=bundle.getString("password");
    	Connection conn=null;
    	PreparedStatement ps=null;
    	try {
        	//1、注册
			Class.forName(driver);
			//2、获取连接
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("获取的数据库为："+conn);
			//3、获取数据库操作对象
			//先预编译
			String sql="delete from t_student where no=?";
			//4、执行sql语句：传入数据
			ps=conn.prepareStatement(sql);
			/*stat=conn.createStatement();这是不用perparedStement的时候
			 * res=stat.executeQuery("Select * from t_student;");
			 * 不同为一个要先传入sql，再获取数据库操作对象，即预编译
			 */
			ps.setInt(1, 10);
			int count=ps.executeUpdate();
			System.out.println(count==1?"删除成功":"删除失败");
			//这里为删除。增和改步骤一样。
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				ps.close();
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
