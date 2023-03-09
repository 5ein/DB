package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

//테이블 하나당 DAO하나! ==> CUD를 완성!!
public class BbsDAO {

	public void delete(int NO) {
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. 오라클 연결 성공.");

			// 3.SQL문 부품(객체)으로 만들어주기
			// 물음표 연산자 사용!(따옴표X)
			String sql = "delete from hr.BBS2 where NO = ? "; // NO가 ?인(조건)것 삭제
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement 가 SQL부품!!
			ps.setInt(1, NO); // 만약 NO가 String이면: ps.setString(1, NO);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");

			// 4.SQL문 오라클로 보내기
			ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공.");

			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(int NO, String CONTENT) {
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. 오라클 연결 성공.");

			// 3.SQL문 부품(객체)으로 만들어주기
			// 물음표 연산자 사용!(따옴표X)
			String sql = "update hr.BBS2 set CONTENT = ? where NO = ? "; // NO가 ?인(조건) CONTENT를 ?로 바꾸어라.
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement 가 SQL부품!!
			ps.setString(1, CONTENT); // string일때는 ps.setString(1, CONTENT);
			ps.setInt(2, NO); // int 일때는 ps.setInt(2, NO);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			// 4.SQL문 오라클로 보내기
			ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공.");

			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(int NO, String TITLE, String CONTENT, String WRITER) {

		try {
			// 1.오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. 오라클 연결 성공.");

			// 3. SQL문 부품(객체)으로 만들어주기
			// 물음표 연산자 사용!(따옴표X)
			String sql = "insert into hr.BBS2 values (?, ?, ?, ?)"; // 순서대로 입력받아온 값을 ?에 차례대로 넣어줌
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement 가 SQL부품!!
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.
			// R뺴고, 인덱스 0부터 시작!!
			// 유일하게 db는 인덱스가 1부터 시작!!
			ps.setInt(1, NO);
			ps.setString(2, TITLE);
			ps.setString(3, CONTENT);
			ps.setString(4, WRITER);
			// Int일때: ps.setInt(1, no);
			// String일때: ps.setString(1, no);

			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			// 4. SQL문 오라클로 보내기
			ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공.");

			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}