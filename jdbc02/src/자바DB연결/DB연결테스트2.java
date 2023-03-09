package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB연결테스트2 {

	public static void main(String[] args) {
		
		try {
			// 1.오라클 11g와 연결한 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공."); //1단계  확인.
			
			
			// 2.오라클 11g에 연결해보자.(java --- oracle) 
			// DBeaver에서 oracle에 오른쪽마우스 -> edit connection 누르고 정보확인
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			//String data = JOptionPane.showInputDialog("이름");//input을 string 넣어준것처럼 !!
			Connection con = DriverManager.getConnection(url, user, password); //Connection
			System.out.println("2. 오라클 연결 성공."); //2단계  확인.
			
			
			// 3. 
			//ipaddress 의 부품 ==> InetAddress
			//String url = "http://www.naver.com"; 이렇게 해도 url을 부품으로 인식 못합 
			//URL u = new URL(url); 이것도 해주어야 부품으로 인식 가능
			//자바는 부품조립식 이여서, String에 넣은 문자열을 특정한 부품으로 인식하지 못함.
			//특정한 부품으로 인식 하려면 그 부품으로 만들어 주어야 한다.
			//SQL부품으로 만들어주어야 함.
			//PreparedStatement 가 SQL부품!!
			
			String sql = "insert into hr.BBS values ('7', '화요일2', '일주 중2번째 날', 'win')";
			PreparedStatement ps = con.prepareStatement(sql);
			//con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.
			System.out.println("3. SQL문 부품(객체)으로 만들어주기."); //3단계  확인.
			
			
			//4. 
			ps.executeUpdate(); //insert, update, delete문만!! sql문 실행결과가 int
			System.out.println("4. SQL문 오라클로 보내기 성공."); //4단계  확인.
			
			//System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}