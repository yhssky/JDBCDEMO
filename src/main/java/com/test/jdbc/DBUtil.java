package com.test.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL="jdbc:mysql://127.0.0.1:3306/immooc?serverTimezone=UTC&useSSL=true";//必须要指定时区和是否使用SSL
	private static final String USER="root";
	private static final String PASSWORD="wxzd1234";
	private static Connection conn=null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 conn=DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2获得数据库的连接
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return conn;
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//1加载驱动
		//JDBC连接Mysql5 com.mysql.jdbc.Driver:JDBC连接Mysql6 com.mysql.cj.jdbc.Driver， 需要指定时区serverTimezone
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2获得数据库的连接
		Connection conn=DriverManager.getConnection(URL, USER, PASSWORD);
        //3通过数据库的连接操作，实现对数据库的增删改查
		java.sql.Statement stmt=conn.createStatement();//Statement 是 Java 执行数据库操作的一个重要接口，用于在已经建立数据库连接的基础上，向数据库发送要执行的SQL语句
		//结果集 rs查询结果的存放对象
        ResultSet rs=stmt.executeQuery("select user_name,age from imooc_goddess");
        while(rs.next()){
    	   System.out.println(rs.getString("user_name")+","+rs.getInt("age"));//rs.get获得相应的查询结果的方法
    	   //System.out.println(rs);
    	   System.out.println("恭喜大王，连接成功！");
       }
       
	}

}
