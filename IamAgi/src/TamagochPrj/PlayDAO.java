package TamagochPrj;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PlayDAO {
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	public int play(int growth, int boring) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@gjaischool-b.ddns.net:1525:xe";
			String user = "campus_d_0120_3";
			String password = "smhrd3";
			
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("데이터베이스 연결 실패");
			e.printStackTrace();
		}
		
		
		
		
		
		return 0;
		
		
	}
}
