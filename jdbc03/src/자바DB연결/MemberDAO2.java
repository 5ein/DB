package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDAO2 {

	// 메서드를 만드는 것 ==> 메서드 정의(define)!
	// 메서드를 정의했다고 실행되는 것은 아니다.!
	// 메서드를 쓰는 것 => 메서드 호출(call)!

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
			if (result == 1) { //원래 delete는 성공하면 1이나 1보다 큰수가 나올수도 있다. 그럴떄는 >= 1
				System.out.println("탈퇴 성공.");
			}
		} catch (Exception e) { //얘일때는 result가 그대로 0
			e.printStackTrace();
		}
		System.out.println(result);
		return result; //result변수를 전달하는 것이 아니고 0 or 1인 값만 전달된거 
	}

	// 수정
	public int update(String id, String tel) {
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
			ps.setString(1, tel);
			ps.setString(2, id);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기.");

			// 4.
			result = ps.executeUpdate(); //sql문 실행결과가 int(실행횟수)
			System.out.println("4. SQL문 오라클로 보내기 성공.");
			if (result == 1) { //원래 delete는 성공하면 1이나 1보다 큰수가 나올수도 있다. 그럴떄는 >= 1
				System.out.println("탈퇴 성공.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; //result변수를 전달하는 것이 아니고 0 or 1인 값만 전달된거 
	}

	// 가입
	public int insert(String id, String pw, String name, String tel) {
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
			ps.setString(1, id); 
			ps.setString(2, pw); 
			ps.setString(3, name);
			ps.setString(4, tel);

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
		//result변수를 전달하는 것이 아니고 0 or 1인 값만 전달된거 

	}

}