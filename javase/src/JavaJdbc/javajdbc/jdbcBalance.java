package JavaJdbc.javajdbc;
/*
jdbc中事务自动提交机制：只要执行任意一条DML语句，就会自动提交一次
但一般开发中，是由多条DML语句捆绑一起开发进行，若DML语句提交了改变了数据库硬盘的数据，后面执行的语句会出错，不符合要求。
*/
//这里是模拟银行账户
/*主要为经典三步
 * 1、开启事务 conn.setAutoCommit(false)关闭自动提交机制
 * 2、提交事务 conn.commit()
 * 3、异常回滚 conn.rollback();
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

////在这里模拟银行账户
//public class jdbcBalance {
//	public static void main(String[] args) {
//		ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
//		String driver=bundle.getString("driver");
//		String url=bundle.getString("url");
//		String user=bundle.getString("user");
//		String password=bundle.getString("password");
//		Connection conn=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		try {
//			//注册
//			Class.forName(driver);
//			//连接
//			conn=DriverManager.getConnection(url, user, password);
//			//在这里将自动提交变为手动提交
//			//开启事务
//			conn.setAutoCommit(false);
//			//获取数据库操作对
//			String sql="update t_act set balance=? where actno=?";
//			ps=conn.prepareStatement(sql);
//			ps.setDouble(1, 10000);
//			ps.setInt(2, 111);
//			int count=ps.executeUpdate();
//			//来表示执行了多少次操作，来判断错误
//			//在这里模拟一个空指针异常，来表示语句执行错误对后面代码的影响
//            /*String s = null;
//            s.toString();
//            */
//			//这里出现异常了但是银行账户的钱仍然被改变了
//			//后面的步骤没有执行：要关掉jdbc的自动提交机制
//			ps.setDouble(1, 10000);
//			ps.setInt(2, 222);
//			count+=ps.executeUpdate();
//			System.out.println(count==2?"转账成功":"转账失败");
//			//能到这里说明没有异常，提交事务
//			conn.commit();
//		} catch(Exception e) {//这里的异常语句需要重新写，变成自定义
//			//遇到异常回滚
//			if(conn!=null) {
//				try {
//					conn.rollback();
//				}catch(SQLException throwables) {
//					throwables.printStackTrace();
//				}
//			}
//		}
//
//    	/*catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		*/finally {
//			try {
//				ps.close();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				conn.close();
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//	}
//}
