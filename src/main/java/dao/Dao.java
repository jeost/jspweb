package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
	protected Connection con;
	protected PreparedStatement ps;
	protected ResultSet rs;
	public Dao() {
		//jdbc : 자바 DB 연동
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jspweb?serverTimezone=UTC","root","1234");
		System.out.println("sql 연동 성공");
		}catch(Exception e) {System.out.println("sql 연동 에러 "+e);}
	}
}
