package com.example.jdbc.util;
import java.sql.*;
public class DbUtil {

	private static String DB_URL = "jdbc:mysql://localhost:3306/grocery";
	private static String USERNAME = "root";
	private static String PASSWORD = "1234";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (Exception e) {

		}
	}
}
