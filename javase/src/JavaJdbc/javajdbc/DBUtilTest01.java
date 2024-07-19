package JavaJdbc.javajdbc;

import java.sql.Connection;
//这里要导入工具类
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

//这里用一个模糊测试来测试工具类
public class DBUtilTest01 {
	public static void main(String[] args) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
    String url=bundle.getString("url");
	String user=bundle.getString("user");
	String password=bundle.getString("password");
    //1、注册连接
    conn=DBUtil.getConnection(url,user,password);
    System.out.println("数据库："+conn);
    //2、执行sql语句
    String sql="select name from t_student where name like ?";//模糊查询是用like
    try {
		ps=conn.prepareStatement(sql);
		//模糊查询第二个字母为a的名字
		//查询语句要用rs接收
		ps.setString(1, "_a%");
		rs=ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("name"));
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    DBUtil.close(conn, ps, rs);
	}
    
}
