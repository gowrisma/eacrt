package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.DBConnection.DBCon;
import com.user.UserDTO;

public class UserDao {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static Statement stmt = null;

	public  static boolean createuser(UserDTO user) {
		boolean iscreated = false;

		try {
			conn = DBCon.getconnection();
			stmt = conn.createStatement();
			
			String insert = user.getName() + "'" + "," + "'" + user.getEmail_id() + "'" + "," + "'"
					+ user.getPassword();
			System.out.println(insert);
			iscreated = stmt.execute("INSERT INTO user_data (Name,Email_id,Password) " + "VALUES ('" + insert + "')");

			System.out.println("isCreated....." + iscreated);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return iscreated;

	}

	public static UserDTO getUser(String email, String pwd) {
		// TODO Auto-generated method stub

		String SQL_GET_USER = "select * from user_data where Email_id = " + "'" + email + "'" + " and  Password = "	+ "'" + pwd + "'";
		
		System.out.println(SQL_GET_USER);

		UserDTO user = null;

		try {
			conn = DBCon.getconnection();
			/*
			 * ps = conn.prepareStatement(SQL_GET_USER); rs = ps.executeQuery();
			 */

			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_GET_USER);
			while (rs.next()) {
				user = new UserDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}
}
