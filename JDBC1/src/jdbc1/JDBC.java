package jdbc1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 데이터 반영이 안되면 mysql에서 conneciton연결이 끊긴거니까 다시 켜서 하기
public class JDBC {

	public static void main(String[] args) {

		// 1. JDBC Driver Loading
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 클래스 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 2. DBMS연결(Connection 객체 생성)
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/world?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8"
					, "ssafy", "ssafy");
			// 3. SQL 실행 준비. (Statement, PreparedStatement 생성) => sql 명령 준비 완료
			pstmt = conn.prepareStatement("select id,name from city where id=20001");
			// 4. sql 명령 보내기
			rs = pstmt.executeQuery();
			
			// rs.next() - 데이터가 들어있으면 true값 반환
			// 여러 행의 경우
			while(rs.next()) {
				// 한 행에 대한 데이터 처리
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.println("id : " + id + ", name : " + name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 5. DBMS 연결 끊기.
			close(rs, pstmt, conn); // 닫을 때는 반대로 (최근에 연 것 부터)
		}
	}
	
	// 자원 반납
	public static void close(AutoCloseable ...resources) { // ... 매개변수 여러개일수 있으니
		for(AutoCloseable  resource : resources) {
			if(resource != null)
				try {
					resource.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
	}

}
