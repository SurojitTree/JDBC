package com.example.jdbc.code;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jdbc.util.DbUtil;

public class DbOperations {

	public Statement getStatement() throws SQLException {
		Connection con = DbUtil.getConnection();
		Statement stmt = con.createStatement();
		return stmt;
	}

	public boolean insertCategory(String type) throws SQLException {
		int count = 0;
		Statement smt = getStatement();

		String sql1 = "insert into category (type) values ('" + type + "')";
		count = smt.executeUpdate(sql1);
		if (count > 0) {
			return true;

		} else {
			return false;
		}
	}

	public ArrayList getCategoryById(int id) throws SQLException {
		String sql = "select * from  category where id = " + id + "";
		Statement smt = getStatement();
		ArrayList lt = new ArrayList();
		ResultSet rset = smt.executeQuery(sql);
		while (rset.next()) {
			int id1 = rset.getInt(1);
			lt.add(id1);
			String catrgory = rset.getString(2);
			lt.add(catrgory);
		}
		return lt;
	}

	public ResultSet getAllCategory() throws SQLException {
		String sql = "select * from  category";
		Statement smt = getStatement();
		ResultSet rset = smt.executeQuery(sql);
		return rset;
	}

	public boolean insertProduct(String name, float price, String type) throws SQLException {

		int count = 0;
		Statement smt = getStatement();
		String sql = "select id from category where type= '" + type + "'";
		ResultSet rset = smt.executeQuery(sql);
		rset.next();
		int catId = rset.getInt(1);

		String sql1 = "insert into product (name,price,category_id) values ('" + name + "'," + price + "," + catId
				+ ")";
		count = smt.executeUpdate(sql1);
		if (count > 0) {
			return true;

		} else {
			return false;
		}
	}

	public ArrayList getProductById(int id) throws SQLException {
		Statement smt = getStatement();
		ArrayList lt = new ArrayList();
		String sql = "select * from product where id = " + id + "";
		ResultSet rset = smt.executeQuery(sql);
		while (rset.next()) {
			int id1 = rset.getInt(1);
			lt.add(id1);
			String name = rset.getString(2);
			lt.add(name);
			float price = rset.getInt("price");
			lt.add(price);
			int category_id = rset.getInt(4);
			lt.add(category_id);
		}
		return lt;
	}

	public ResultSet getAllProduct() throws SQLException {

		String sql = "select * from  product";
		Statement smt = getStatement();
		ResultSet rset = smt.executeQuery(sql);
		return rset;
	}

	public boolean insertOrder(String product_name, Date date) throws SQLException {
		int count = 0;
		Statement smt = getStatement();

		String sql = "select id from product where name= '" + product_name + "'";
		ResultSet rset = smt.executeQuery(sql);
		rset.next();
		int productId = rset.getInt(1);

		String sql1 = "insert into orders (product_id,order_date) values (" + productId + ",'" + date + "')";
		count = smt.executeUpdate(sql1);

		if (count > 0) {
			return true;

		} else {
			return false;
		}

	}

	public ArrayList getOrderById(int id) throws SQLException {
		ArrayList lt = new ArrayList();
		Statement smt = getStatement();
		String sql = "select * from orders where  id = " + id + "";
		ResultSet rset = smt.executeQuery(sql);
		while (rset.next()) {
			int id1 = rset.getInt(1);
			lt.add(id1);
			int prdId = rset.getInt(2);
			lt.add(prdId);
			Date date= rset.getDate(3);
			lt.add(date);
		}
		return lt;
	}

	public ResultSet getAllOrder() throws SQLException {
		String sql = "select * from  orders";
		Statement smt = getStatement();
		ResultSet rset = smt.executeQuery(sql);
		return rset;
	}
}
