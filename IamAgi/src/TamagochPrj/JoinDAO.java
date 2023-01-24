package TamagochPrj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class JoinDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	public void getCon() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 이부분 일단 바꾼 오라클 서버에 맞게 바꿔야됩니다 user password도
			String user = "system";
			String password = "12345";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("회원가입 : 데이터베이스 연결 실패");
			e.printStackTrace();
		}
	}

	public void getClose() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public int join(JoinDTO dto) {
		int row = 0;
		Scanner sc = new Scanner(System.in);

		try {
			getCon();
			String sql = "insert into join values (?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getName());
			row = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 전송 실패");
			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;

	}

	public int delete(JoinDTO dto) {
		int row = 0;
		getCon();

		try {
			String sql = "delete from join where name = ? ";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			row = psmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return row;
	}

	public ArrayList<JoinDTO> select() {
		ArrayList<JoinDTO> list = new ArrayList<>();
		getCon();

		try {
			String sql = "select * from join";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				JoinDTO dto = new JoinDTO(id, pw, name);
				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return list;

	}

	public JoinDTO selectOne(JoinDTO dto) {

		getCon();

		try {
			String sql = "select * from join where name = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());

			rs = psmt.executeQuery();

			if (rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				dto = new JoinDTO(id, pw, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}

		return dto;

	}

	public boolean login(JoinDTO dto) {

		getCon();
		boolean result = false;

		try {
			String sql = "select * from join where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			rs = psmt.executeQuery();

			result = rs.next();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			getClose();
		}
		return result;

	}

}
