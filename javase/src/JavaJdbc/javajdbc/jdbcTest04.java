package JavaJdbc.javajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

//在这里演示jdbc数据库的查询
public class jdbcTest04 {
    public static void main(String[] args) {
    	//用资源绑定器去获取配置信息
    	ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
    	//通过key获取value值
    	String driver=bundle.getString("driver");
    	String url=bundle.getString("url");
    	String user=bundle.getString("user");
    	String password=bundle.getString("password");
    	Connection conn=null;
    	Statement stat=null;
    	ResultSet res=null;
    	//1、注册
    	try {
			Class.forName(driver);
		//2、获取连接
		   conn= DriverManager.getConnection(url,user,password);
		//3、获取数据库操作对象
		   stat=conn.createStatement();
		   //executeQuery(String sql) 执行给定的SQL语句，该语句返回单个 ResultSet对象。
		   //表示数据库结果集的数据表，通常通过执行查询数据库的语句生成。
		   //ResultSet对象保持一个光标指向其当前的数据行。 最初，光标位于第一行之前。 next方法将光标移动到下一行
	    //4、执行sql语句
		   res=stat.executeQuery("Select * from t_student;");
		//5、处理查询结果集 
		  while(res.next()) {
			   int no=res.getInt("no");//这里也可以用int no=res.getInt(1);
			   String name=res.getString("name");
			   String sex=res.getString("sex");
			   String classno=res.getString("classno");
			   String birth=res.getString("birth");
			   System.out.println("no: "+no+"  name: "+name+"  sex:"+sex+"  classno: "+classno+"  birth: "+birth);
		   }
		   /*while(res.next()) {
			   int no=res.getInt(1);//这里也可以用数字的形式，这里的数字表示表的列号，是从1开始
			   String name=res.getString(2);
			   String sex=res.getString(3);
			   String classno=res.getString(4);
			   String birth=res.getString(5);
			   System.out.println("no: "+no+"  name: "+name+"  sex:"+sex+"  classno: "+classno+"  birth: "+birth);
		   }*/
		   //System.out.println("no:"+no+"name:"+name+"sex:"+sex+"classno"+classno+"birth:"+birth);
		   //while里面也是局部变量
		} catch(ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			//每个连接都要try一下
			try{
				if(res!=null) {
					res.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			try{
				if(stat!=null) {
					stat.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			try{
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
    	
    	

    }
}
