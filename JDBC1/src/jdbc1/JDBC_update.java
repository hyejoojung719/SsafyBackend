package jdbc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_update {
	public static void main(String[] args) {
		// 1. JDBC Driver Loading
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println("드라이버 클래스 로딩 성공");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				try {
					// 2. DBMS연결(Connection 객체 생성)
					Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/world?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8"
							, "ssafy", "ssafy");
					// 3. SQL 실행 준비. (Statement, PreparedStatement 생성) => sql 명령 준비 완료
//					PreparedStatement pstmt = conn.prepareStatement("insert into city(id,name,countrycode) values (20000, 'aaa', 'PSE')");
					PreparedStatement pstmt = conn.prepareStatement("insert into city (id,name,countrycode) values (?,?,?)");
					pstmt.setInt(1, 20002);
					pstmt.setString(2, "abc");
					pstmt.setString(3, "PSE");
					
					// 4. sql 명령 보내기 - excudeUpdate() : 영향을 받은 행의 수
					int cnt = pstmt.executeUpdate();
					
					if(cnt==1) {
						// 잘 수행 된 것
						System.out.println("추가 성공");
					}else {
						System.out.println("추가 실패");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
	}
	
}
