//package javajdbc.javajdbc;
//
//import java.sql.Connection;
//import java.sql.Driver;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
////jdbc是一套接口用来连接数据库和程序
//
//public class jdbcTest01 {
//    public static void main(String[] args) {
//    	Connection conn=null;
//    	Statement stat=null;
//    	//1、先注册
//    	try {
//    		//这里的Driver是接口，后面的
//			Driver driver=new com.mysql.cj.jdbc.Driver();
//			//这里不是com.mysql.jdbc.Driver()
//			//加载类'com.mysql.jdbc.Driver' 已经过时了。新的驱动类是“com.mysql.cj.jdbc.Driver”。
//			//驱动程序通过SPI自动注册，而手动加载类通常是不必要的。
//			//Driver作为父接口，多态，父类引用指向子类
//			DriverManager.registerDriver(driver);
//			//2、获取连接getConnection(String url, String user, String password) 静态方法
//			//String url="jdbc:mysql://127.0.0.1/bjpowernode";
//			String url="jdbc:mysql://127.0.0.1/bjpowernode?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
//			//这里有个时差问题
//			String user="root";
//			String password="root";
//			conn=DriverManager.getConnection(url, user, password);//多态
//			System.out.println("连接的数据库为"+conn);
//			//这里报错java.sql.SQLException: The server time zone value '?й???????' is unrecognized or represents more ...
//			//java.sql.SQL异常:服务器时区价值”й׼ʱ”无法识别或代表多个时区。如果您想利用时区支持，您必须配置服务器或JDBC驱动程序(通过“serverTimezone”配置属性)来使用更具体的时区值。
//
//            //3、获取数据库操作对象
//			stat=conn.createStatement();
//			//Statement createStatement()创建一个Statement对象，用于将SQL语句发送到数据库。
//            //4、执行sql语句
//			int count=stat.executeUpdate("insert into t_student(no,name,sex,classno,birth) values(9,'lijq','1','class 2','1990-02-09');");
//            //executeUpdate(sql)执行给定的SQL语句，这可能是 INSERT ， UPDATE ，或 DELETE语句，或者不返回任何内容，如SQL DDL语句的SQL语句。
//			//返回值是影响数据库中的记录条数，返回int
//			System.out.println(count==1?"修改成功":"修改失败");
//			//5、处理sql查询结果集
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			//6、释放资源
//			//从小到大释放
//			if(stat!=null) {
//				try {
//					stat.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			//必须要放两次，因为try语句中如果第一个语句有异常，第二个语句就不会执行
//			if(conn!=null) {
//				try {
//					conn.close();
//				}catch(SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//    }
//}
