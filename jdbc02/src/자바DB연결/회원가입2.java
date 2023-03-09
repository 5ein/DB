package 자바DB연결;

import java.util.Scanner;

public class 회원가입2 {
	public static void main(String[] args) {

		// 입력해보자.
		Scanner sc = new Scanner(System.in); // 스캐너 부풍을 사용할때 어디다 사용할지 ()안에 꼭 작성
		System.out.println("id/pw/name/tel 순으로 입력하세요."); // 어떤 형식으로 입력받을지 출력해줌

		String id = sc.next(); // scanner(스캐너)에서 입력받은 값을 string id에 넣어줌
		String pw = sc.next(); // 스캐너에서 입력받은 값을 string pw에 넣어줌
		String name = sc.next(); // 스캐너에서 입력받은 값을 string name에 넣어줌
		String tel = sc.next(); // 스캐너에서 입력받은 값을 string tel에 넣어줌

		MemberDAO2 dao = new MemberDAO2(); // MemberDAO2.java 를 dao로 사용하기 위해 생성
		dao.insert(id, pw, name, tel); // 실행했을때 스캐너로 입력받은 값을 dao로 넣어줌
	}
}
