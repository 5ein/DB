package 자바DB연결;

import java.util.Scanner;

public class 게시판수정하기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("NO/수정 할 CONTENT 순으로 입력하세요.");

		int NO = sc.nextInt(); // NO 가 Int 이기 때문에 nextInt();
		String CONTENT = sc.next();

		BbsDAO dao = new BbsDAO();
		dao.update(NO, CONTENT);
	}
}
