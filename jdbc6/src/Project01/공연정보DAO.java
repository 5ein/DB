package Project01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class 공연정보DAO {

	// 공연정보 가져오기
	public ArrayList<공연정보VO> list() { // 검색하려면 ()안에 적어주기
		ResultSet rs = null; // 항목명 + 결과데이터를 담고있는 테이블

		// 가방들 넣어줄 큰 컨테이너 역할을 부품이 필요!
		// ArrayList
		ArrayList<공연정보VO> list = new ArrayList<>(); // 앞 꺽쇠에 뭘가져올지 적는것
		// ArrayList<공연정보VO> ==> 공연정보VO만 들어간 arraylist라는 의미

		공연정보VO bag = null;
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
			String sql = "select * from hr.공연정보"; // 조건주지 않고 다 가져옴
			PreparedStatement ps = con.prepareStatement(sql);
			// ps.setString(1, id); //?가 없어졌기 때문에 필요없음 삭제!
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");

			// 4.
			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			while (rs.next()) { // 검색결과가 있는지 여부는 rs.next()
				// true이면 있다라는 의미, false이면 없다라는 의미
				// 1. 검색결과가 있으면,
				// System.out.println("검색결과 있음. 성공.");
				// 2. 각 컬럼에서 가져오자
				String ID = rs.getString(1);
				String 제목 = rs.getString(2);
				String 위치 = rs.getString(3);
				String 가격 = rs.getString(4);
				String 공연시작일 = rs.getString(5);
				String 공연종료일 = rs.getString(6);
				// System.out.println(id2 + " " + pw + " " + name + " " + tel);
				// 검색결과를 검색화면 UI부분에 넣어주어야 함. (여기에jop넣으면 안됨)
				// 3. 가방을 만들자
				bag = new 공연정보VO(); // 가방만들어서
				bag.setID(ID); // 가방에다 쫙 넣자
				bag.set제목(제목);
				bag.set위치(위치);
				bag.set가격(가격);
				;
				bag.set공연시작일(공연시작일);
				;
				bag.set공연종료일(공연종료일);
				;

				// 4. list에 bag을 추가해주자.
				list.add(bag);
			} // while로 바뀌었기 때문에 if-else의 else삭제!
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return id, pw, name, tel은 XXXX! ==> 파이썬만 가능
		// return 뒤에는 반드시 여러 데이터를 묶어서 리턴해주어야 함 ==> 자바는 가방을 만들어줘야함
		// 검색결과가 있을 때는 bag에 데이터가 들어있음.
		// 검색결과가 없을 때는 bag에 무엇이 들어있나? null
		return list;
	}

	// 공연 추가하기 insert
	public int insert(공연정보VO bag) {

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
			String sql = "insert into hr.공연정보 values (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			// 2. 가방에서 값들을 하나씩 꺼내쓰세요.
			ps.setString(1, bag.getID());
			ps.setString(2, bag.get제목());
			ps.setString(3, bag.get위치());
			ps.setString(4, bag.get가격());
			ps.setString(5, bag.get공연시작일());
			ps.setString(6, bag.get공연종료일());

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
	public 공연정보VO one(String ID) {

		ResultSet rs = null; // 항목명 + 결과데이터를 담고있는 테이블

		공연정보VO bag = null;
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
			String sql = "select * from hr.공연정보 where ID = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ID);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");

			// 4.
			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (rs.next()) { // 검색결과가 있는지 여부는 rs.next()
				// true이면 있다라는 의미, false이면 없다라는 의미
				System.out.println("검색결과 있음. 성공.");
				String ID2 = rs.getString(1);
				String 제목 = rs.getString(2);
				String 위치 = rs.getString(3);
				String 가격 = rs.getString(4);
				String 공연시작일 = rs.getString(5);
				String 공연종료일 = rs.getString(6);
				System.out.println(ID2 + " " + 제목 + " " + 위치 + " " + 가격 + " " + 공연시작일 + " " + 공연종료일);
				// 검색결과를 검색화면 UI부분에 넣어주어야 함.
				bag = new 공연정보VO();
				bag.setID(ID2);
				bag.set제목(제목);
				bag.set위치(위치);
				bag.set가격(가격);
				bag.set공연시작일(공연시작일);
				bag.set공연종료일(공연종료일);
			} else {
				System.out.println("검색결과 없음. 성공.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bag;
	}

	// 공연 수정하기 modify
	public int update(공연정보VO bag) {
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
			String sql = "update hr.공연정보 set 제목 = ?, 위치 = ?, 가격 = ?, 공연시작일 = ?, 공연종료일 = ? where ID = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			// 2. 필요할 때 가방에서 값들을 하나씩 꺼내자.
			ps.setString(1, bag.get제목());
			ps.setString(2, bag.get위치());
			ps.setString(3, bag.get가격());
			ps.setString(4, bag.get공연시작일());
			ps.setString(5, bag.get공연종료일());
			ps.setString(6, bag.getID());
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

	// 공연 삭제하기 delete
	public int delete(String ID) {

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
			String sql = "delete from hr.공연정보 where ID = ? "; // 관리자로 바꿔야하나?
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ID);
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
	// 로그인 추가할수있으면..
}
