package Project01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class 공연DAO {

	// 공연 추가하기 insert
	public int insert(공연VO bag) {

		int result = 0;

		try {
			// 1.오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");

			// 3. SQL문 부품(객체)으로 만들어주기
			String sql = "insert into hr.공연 values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			// 2. 가방에서 값들을 하나씩 꺼내쓰세요.
			ps.setString(1, bag.get공연ID());
			ps.setString(2, bag.get제목());
			ps.setString(3, bag.get위치());
			ps.setDate(4, (Date) bag.get공연시작일());
			ps.setDate(5, (Date) bag.get공연종료일());
			ps.setInt(6, bag.get가격());

			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			// 4. SQL문 오라클로 보내기
			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("공연 추가 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	// 공연 검색하기 select
	public 공연VO one(String 공연ID) {

		ResultSet rs = null; // 항목명 + 결과데이터를 담고있는 테이블

		공연VO bag = null;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");

			// 3.
			String sql = "select * from hr.공연 where 공연ID = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, 공연ID);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");

			// 4.
			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (rs.next()) { // 검색결과가 있는지 여부는 rs.next()
				// true이면 있다라는 의미, false이면 없다라는 의미
				System.out.println("검색결과 있음. 성공.");
				String 공연ID2 = rs.getString(1);
				String 제목 = rs.getString(2);
				String 위치 = rs.getString(3);
				Date 공연시작일 = rs.getDate(4);
				Date 공연종료일 = rs.getDate(5);
				int 가격 = rs.getInt(6);
				System.out.println(공연ID2 + " " + 제목 + " " + 위치 + " " + 공연시작일 + " " + 공연종료일 + " " + 가격);
				// 검색결과를 검색화면 UI부분에 넣어주어야 함.
				bag = new 공연VO();
				bag.set공연ID(공연ID2);
				bag.set제목(제목);
				bag.set위치(위치);
				bag.set공연시작일(공연시작일);
				bag.set공연종료일(공연종료일);
				bag.set가격(가격);
			} else {
				System.out.println("검색결과 없음. 성공.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bag;
	}

	// 공연 삭제하기 delete
	public int delete(String id) {

		int result = 0;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");

			// 3.
			String sql = "delete from hr.공연 where id = ? "; //관리자로 바꿔야하나?
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");

			// 4.
			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("공연 삭제 성공.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}

	// 공연 수정하기 modify
	public int update(공연VO bag) {
		// 1. 가방을 받아서 저장해두자.
		// 2. 필요할 때 가방에서 값들을 하나씩 꺼내자.

		int result = 0;
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공.");

			// 3.
			String sql = "update hr.공연 set 제목 = ?, 위치 = ?, 공연시작일 = ?, 공연종료일 = ?, 가격 = ? where 공연ID = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			// 2. 필요할 때 가방에서 값들을 하나씩 꺼내자.
			ps.setString(1, bag.get공연ID());
			ps.setString(2, bag.get제목());
			ps.setString(3, bag.get위치());
			ps.setDate(4, (Date) bag.get공연시작일());
			ps.setDate(5, (Date) bag.get공연종료일());
			ps.setInt(6, bag.get가격());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");

			// 4.
			result = ps.executeUpdate(); // sql문 실행결과가 int(실행횟수)
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("공연 수정 성공.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; // result변수를 전달하는 것이 아니고 0 or 1인 값만 전달된거
	}

}
