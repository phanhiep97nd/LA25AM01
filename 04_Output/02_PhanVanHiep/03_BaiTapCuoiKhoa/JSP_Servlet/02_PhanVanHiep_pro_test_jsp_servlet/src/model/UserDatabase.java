/**
 * Copyright(C) 2020  Luvina Software
 * UserDatabase.java, Jun 16, 2020 Phan Van Hiep
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Description:  
 * @author Phan Van Hiep
 */
public class UserDatabase {
	/**
	 * Lấy ra tất cả CD
	 * 
	 * @return Trả về danh sách tìm kiếm được!
	 * @throws SQLException
	 */
	public static ArrayList<User> getAll() throws SQLException {
		PreparedStatement pstm = null;
		Connection conn = null;
		ArrayList<User> lstUser = new ArrayList<User>();
		try {
			conn = ConnectionDB.openConnection();
			if (conn != null) {
				String SQL = "select * from user";
				pstm = (PreparedStatement) conn.prepareStatement(SQL);
				ResultSet rs = pstm.executeQuery(SQL);
				while (rs.next()) {
					User user = new User();
					user.setId(Integer.parseInt(rs.getString("id")));
					user.setName(rs.getString("name"));
					user.setBirthday(rs.getString("birthday"));
					user.setBirthPlace(rs.getString("birthplace"));
					lstUser.add(user);
				}
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			ConnectionDB.closeConnection(conn, pstm);
			return lstUser;
		}
	}
}
