package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import 화면DB연결.MemberVO;

public class MemberDAO3 {
	
	// 메서드를 만드는 것 ==> 메서드 정의(define)!
	// 메서드를 정의했다고 실행되는 것은 아니다.!
	// 메서드를 쓰는 것 => 메서드 호출(call)!

	// 여러개 가져오기
	public ArrayList<MemberVO> list() { // 검색하려면 ()안에 적어주기
		ResultSet rs = null; // 항목명 + 결과데이터를 담고있는 테이블

		// 가방들 넣어줄 큰 컨테이너 역할을 부품이 필요!
		// ArrayList
		ArrayList<MemberVO> list = new ArrayList<>(); // 앞 꺽쇠에 뭘가져올지 적는것
		// ArrayList<MemberVO> ==> MemberVO만 들어간 arraylist라는 의미

		MemberVO bag = null;
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
			String sql = "select * from hr.MEMBER"; // 조건주지 않고 다 가져옴
			PreparedStatement ps = con.prepareStatement(sql);
			// ps.setString(1, id); //?가 없어졌기 때문에 필요없음 삭제!
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");

			// 4.
			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			while (rs.next()) { // 검색결과가 있는지 여부는 rs.next()
				// true이면 있다라는 의미, false이면 없다라는 의미
				// 1. 검색결과가 있으면,
				//System.out.println("검색결과 있음. 성공.");
				// 2. 각 컬럼에서 가져오자
				String id2 = rs.getString(1); // id
				String pw = rs.getString(2); // pw
				String name = rs.getString(3); // name
				String tel = rs.getString(4); // tel
				//System.out.println(id2 + " " + pw + " " + name + " " + tel);
				// 검색결과를 검색화면 UI부분에 넣어주어야 함. (여기에jop넣으면 안됨)
				// 3. 가방을 만들자
				bag = new MemberVO(); // 가방만들어서
				bag.setId(id2); // 가방에다 쫙 넣자
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);

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

	// 검색
	public MemberVO one(String id) {

		ResultSet rs = null; // int를 -> ResultSet로 바꿈, 0 -> null로 바꿈
		// 항목명 + 결과데이터를 담고있는 테이블
		// 기본형 정수/실수/문자/논리만 값으로 초기화
		// 나머지 데이터형(참조형) 주소가 들어있음.
		// 참조형 변수를 초기화 할 때는 null(주소가 없다는 의미)

		MemberVO bag = null;
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
			String sql = "select * from hr.MEMBER where id = ? "; // *를 뺴면 sql문법에러가 난다.
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");

			// 4.
			rs = ps.executeQuery(); // select문 전송시 정수X,테이블O executeUpdate 대신 executeQuery
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (rs.next()) { // 검색결과가 있는지 여부는 rs.next()
				// true이면 있다라는 의미, false이면 없다라는 의미
				System.out.println("검색결과 있음. 성공.");
				String id2 = rs.getString(1); // id
				String pw = rs.getString(2); // pw
				String name = rs.getString(3); // name
				String tel = rs.getString(4); // tel
				System.out.println(id2 + " " + pw + " " + name + " " + tel);
				// 검색결과를 검색화면 UI부분에 넣어주어야 함. (여기에jop넣으면 안됨)
				bag = new MemberVO();
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
			} else {
				System.out.println("검색결과 없음. 성공.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return id, pw, name, tel은 XXXX! ==> 파이썬만 가능
		// return 뒤에는 반드시 여러 데이터를 묶어서 리턴해주어야 함 ==> 자바는 가방을 만들어줘야함
		// 검색결과가 있을 때는 bag에 데이터가 들어있음.
		// 검색결과가 없을 때는 bag에 무엇이 들어있나? null
		return bag;
	}

	// 탈퇴
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
			String sql = "delete from hr.MEMBER where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");

			// 4.
			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) { // 원래 delete는 성공하면 1이나 1보다 큰수가 나올수도 있다. 그럴떄는 >= 1
				System.out.println("탈퇴 성공.");
			}
		} catch (Exception e) { // 얘일때는 result가 그대로 0
			e.printStackTrace();
		}
		System.out.println(result);
		return result; // result변수를 전달하는 것이 아니고 0 or 1인 값만 전달된거
	}

	// 수정
	public int update(MemberVO bag) {
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
			String sql = "update hr.MEMBER set tel = ? where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			// 2. 필요할 때 가방에서 값들을 하나씩 꺼내자.
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getTel());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");

			// 4.
			result = ps.executeUpdate(); // sql문 실행결과가 int(실행횟수)
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("수정 성공.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; // result변수를 전달하는 것이 아니고 0 or 1인 값만 전달된거
	}

	// 가입
	public int insert(MemberVO bag) {
		// 1. 가방을 받아서 변수에 넣어주세요.

		// 다른곳에서도 사용할수 있도록 static main대신 바꾸어줌.
		// 입력받을 형식과 이름을 정의해줌
		int result = 0; // 자신을 포함하는 가로에서 사용가능

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
			String sql = "insert into hr.MEMBER values (?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			// 2. 가방에서 값들을 하나씩 꺼내쓰세요.
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());
			ps.setString(3, bag.getName());
			ps.setString(4, bag.getTel());

			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			// 4. SQL문 오라클로 보내기
			result = ps.executeUpdate(); // 성공하면 1이 나옴 //result를 이미 밖에서 선언 해줌, 값에 넣기만 하면됨
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) {
				System.out.println("회원가입 성공!");
			}
		} catch (Exception e) {
			// insert가 제대로 안된 경우, 위험한 상황이라 판단하고
			// catch가 실행된다.
			// 실행된 Row수가 없으므로 Result에 0을 넣어주자.
			// result = 0; //이미 밖에서 선언 해줌
			e.printStackTrace(); // 에러를 프린트해라
		}
		System.out.println(result); // result 값 찍어보기
		return result; // void도 바꿔줘야함
		// result변수를 전달하는 것이 아니고 0 or 1인 값만 전달된거
	}

	// 로그인
	public int login(MemberVO bag) {
		// 1. 가방을 받아서 변수에 넣어주세요.

		int result = 0; // 없는 경우

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
			String sql = "select * from hr.MEMBER where id = ? and pw = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			// 2. 가방에서 값들을 하나씩 꺼내쓰세요.
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공.");

			// 4. SQL문 오라클로 보내기
			ResultSet rs = ps.executeQuery(); // 성공하면 1이 나옴 //result를 이미 밖에서 선언 해줌, 값에 넣기만 하면됨
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (rs.next()) {
				System.out.println("로그인 성공!");
				result = 1;
			}
			ps.close();
			con.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	} // login

}