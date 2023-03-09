package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO2 {
	
	//메서드를 만드는 것 ==> 메서드 정의(define)!
	//메서드를 정의했다고 실행되는 것은 아니다.!
	//메서드를 쓰는 것 => 메서드 호출(call)!

	public void delete(String id) {
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			// DBeaver에서 oracle에 오른쪽마우스 -> edit connection 누르고 정보확인
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			// String data = JOptionPane.showInputDialog("이름");//input을 string 넣어준것처럼 !!
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. 오라클 연결 성공.");

			// 3.
			// ipaddress 의 부품 ==> InetAddress
			// String url = "http://www.naver.com"; 이렇게 해도 url을 부품으로 인식 못합
			// URL u = new URL(url); 이것도 해주어야 부품으로 인식 가능
			// 자바는 부품조립식 이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			// 특정한 부품으로 인식 하려면 그 부품으로 만들어 주어야 한다.
			// SQL부품으로 만들어주어야 함.
			// PreparedStatement 가 SQL부품!!

			String sql = "delete from hr.MEMBER where id = ? ";
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");

			// 4.
			ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공.");

			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(String id, String tel) {
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공.");

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			// DBeaver에서 oracle에 오른쪽마우스 -> edit connection 누르고 정보확인
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			// String data = JOptionPane.showInputDialog("이름");//input을 string 넣어준것처럼 !!
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. 오라클 연결 성공.");

			// 3.
			// ipaddress 의 부품 ==> InetAddress
			// String url = "http://www.naver.com"; 이렇게 해도 url을 부품으로 인식 못합
			// URL u = new URL(url); 이것도 해주어야 부품으로 인식 가능
			// 자바는 부품조립식 이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			// 특정한 부품으로 인식 하려면 그 부품으로 만들어 주어야 한다.
			// SQL부품으로 만들어주어야 함.
			// PreparedStatement 가 SQL부품!!

			String sql = "update hr.MEMBER set tel = ? where id = ? "; // id가 ?인(조건) tel을 ?로 바꾸어라.
			PreparedStatement ps = con.prepareStatement(sql); // PreparedStatement
			ps.setString(1, tel);
			ps.setString(2, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");

			// 4.
			ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공.");

			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public void add2() 형식
	public void insert(String id, String pw, String name, String tel) {
		// 다른곳에서도 사용할수 있도록 static main대신 바꾸어줌.
		// 입력받을 형식과 이름을 정의해줌
		try {
			// 1.오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공."); // 1단계 확인.

			// 2.오라클 11g에 연결해보자.(java --- oracle)
			// DBeaver에서 oracle에 오른쪽마우스 -> edit connection 누르고 정보확인
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			// String data = JOptionPane.showInputDialog("이름");//input을 string 넣어준것처럼 !!
			Connection con = DriverManager.getConnection(url, user, password); // Connection
			System.out.println("2. 오라클 연결 성공."); // 2단계 확인.

			// 3. SQL문 부품(객체)으로 만들어주기
			// ipaddress 의 부품 ==> InetAddress
			// String url = "http://www.naver.com"; 이렇게 해도 url을 부품으로 인식 못합
			// URL u = new URL(url); 이것도 해주어야 부품으로 인식 가능
			// 자바는 부품조립식 이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			// 특정한 부품으로 인식 하려면 그 부품으로 만들어 주어야 한다.
			// SQL부품으로 만들어주어야 함.
			// PreparedStatement 가 SQL부품!!

			// public void insert(String id, String pw, String name, String tel)
			// 위의 순서대로 입력받아온 값을 ?에 차례대로 넣어줌
			String sql = "insert into hr.MEMBER values (?, ?, ?, ?)"; // 물음표 연산자 사용!(따옴표X)
			PreparedStatement ps = con.prepareStatement(sql);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.
			// R뺴고, 인덱스 0부터 시작!!
			// 유일하게 db는 인덱스가 1부터 시작!!
			ps.setString(1, id); // ps의 1번 물음표에서 입력받은 id를 넣어줘 라는 뜻
			ps.setString(2, pw); // ps의 2번 물음표에서 입력받은 pw를 넣어줘 라는 뜻
			ps.setString(3, name);// ps의 2번 물음표에서 입력받은 name를 넣어줘 라는 뜻
			ps.setString(4, tel);// ps의 2번 물음표에서 입력받은 tel를 넣어줘 라는 뜻
			// Int 였다면 ps.setInt(1, no);
			// ==> insert into hr.MEMBER values ('a', 'a', 'a', 'a');

			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공."); // 3단계 확인.

			// 4. SQL문 오라클로 보내기
			ps.executeUpdate(); // insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공."); // 4단계 확인.

			// System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}