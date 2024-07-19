package JavaJdbc.javajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

//在这里模拟一个登录验证功能
public class jdbcLogin {
	public static void main(String[] args) {
		//这里就是一个登录的初始界面
		//用map去接收登录传入的信息,因为Map有key
	    Map<String,String>userloginInfo=initUI();
	    //判断传入的密码是否正确
	    boolean userLoginSuccess=login(userloginInfo);
	    System.out.println(userLoginSuccess?"登录成功":"登录失败");
	}

	private static boolean login(Map<String, String> userloginInfo) {
		//这里为jdbc的操作：这里还是使用资源绑定器
		boolean userLoginSuccess=false;//在这里先列一个flag
		ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
		String driver=bundle.getString("driver");//通过key来找到value
		String url=bundle.getString("url");
		String user=bundle.getString("user");
		String password=bundle.getString("password");
        Connection conn=null;
        PreparedStatement prestat=null;
        ResultSet res=null;
		try {
			//1、注册
			Class.forName(driver);
			//2、获取连接
			conn=DriverManager.getConnection(url, user, password);
			System.out.println("连接的数据库为："+conn);
			//3、获取数据库操作对象
			/* 将Statement改变成为preparedStatement
		       PreparedStatement子接口属于预编译的数据库操作对象
		             原理为：预先对sql语句的框架进行编译，再给sql语句传值*/
			String sql="select * from t_user where loginName=? and loginPwd=?";
			//这里的？为占位符，一个占位符接受一个值，不可以用''修饰,如果加了''就不是占位符了，预编译。
			prestat=conn.prepareStatement(sql);//这里不是prepared
			//4、执行sql语句,查询语句用quary
			/* 在这里会出现字符串的拼接问题用'+"  "+'		
			String sql="select * from t_user where loginName='"+userloginInfo.get("userName")+"' and loginPwd='"+userloginInfo.get("userPassword")+"'";
			 * 这里会出现sql注入的问题
		     * 因为jdbc存在自动提交机制，它会先执行sql语句
			 * 用户提供的信息中即使含有sql语句关键字，但是关键字没有参加：所以这里要改变jdbc的自动提交机制
			 * 即：将执行语句的Statement改为预编译的preparedStstemrnt
			 */
			//res=prostat.executeQuery(sql);
			//对sql语句进行传值，setString(int parameterIndex, String x) 前面为要赋值的位置
			prestat.setString(1,userloginInfo.get("userName"));
			prestat.setString(2,userloginInfo.get("userPassword"));
			//5、处理结果集
			//执行sql语句
			res=prestat.executeQuery();
			if(res.next()) {
			   userLoginSuccess=true;//当数据库中有这条语句的时候返回成功
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//6、释放资源
			try {
				if(res!=null) {
					res.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try {
				if(prestat!=null) {
					prestat.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try {
				if(conn!=null) {
					conn.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return userLoginSuccess;
	}

	private static Map<String, String> initUI() {
		//这里为接收用户传入的登录信息
		Scanner in=new Scanner(System.in);
		System.out.println("输入用户名：");
		String userName=in.nextLine();
		System.out.println("输入密码：");
		String userPassword=in.nextLine();
		//用map集合来存储信息
		Map<String,String>userLoginInfo=new HashMap<String,String>();
		userLoginInfo.put("userName", userName);
		userLoginInfo.put("userPassword",userPassword);
		return userLoginInfo;//返回一个集合
	}
}