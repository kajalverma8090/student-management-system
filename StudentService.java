
package schooldata.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import schooldata.entity.Sudent;

public class StudentService {

	private static Connection con;
	private static String url = "jdbc:postgresql://localhost:5432/shashanka?user=postgres&password=123";
	static {

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int save(Sudent s) {
		int res = 0;
		String sql = "INSERT into student values(?,?,?)";

		try {
			PreparedStatement psmt = con.prepareStatement(sql);

			psmt.setInt(1, s.getId());
			psmt.setString(2, s.getName());
			psmt.setInt(3, s.getAge());

			res = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public int update(Sudent st) {
		int res = 0;
		String sql = "UPDATE student set age=?,name=? where id=?";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, st.getAge());
			psmt.setString(2, st.getName());
			psmt.setInt(3, st.getId());
			res = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public List<Sudent> getAll() {
		List<Sudent> list = new ArrayList<Sudent>();
		String sql = "SELECT * from student";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			ResultSet resultSet = psmt.executeQuery();
			while (resultSet.next()) {
				System.out.println("data fetched");
				list.add(new Sudent(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int delete(int id) {
		int res = 0;
		String sql = "DELETE from student where id=?";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);
			res = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public boolean exit() {
		boolean flag = false;
		try {
			con.close();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
