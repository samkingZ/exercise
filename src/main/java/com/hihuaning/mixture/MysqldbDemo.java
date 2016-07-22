package com.hihuaning.mixture;

import java.sql.*;

public class MysqldbDemo {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/askexpert";
		String user = "root";
		String psd = "";
		// 加载驱动程序
		Class.forName(driver);
		System.out.println("hi");
		// 连续数据库
		try{
			Connection conn = DriverManager.getConnection(url, user,psd);
	  	         /*   Statement stmt = conn.createStatement();//创建语句对象，用以执行sql语言
	  	            ResultSet rs = stmt.executeQuery("select * from student");

	  	             //处理结果集
	  	            while (rs.next())
	  	            {
	  	              String name = rs.getString("name");
	  	              System.out.println(name);
	  	            }*/

			if(!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			else
				System.out.println("failed");
			System.out.println("hello");
			conn.close();
		}
		catch(SQLException e){
			System.out.println("连接错误");
			e.printStackTrace();
		}
		System.out.println("hello");
	}
}
