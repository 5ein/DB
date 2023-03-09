package 자바DB연결;

import java.util.Scanner;

public class 게시판글쓰기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("NO/TITLE/CONTENT/WRITER 순서대로 입력하세요.");

		int NO = sc.nextInt(); // NO 가 Int 이기 때문에 nextInt();
		String TITLE = sc.next();
		String CONTENT = sc.next();
		String WRITER = sc.next();

		BbsDAO dao = new BbsDAO();
		dao.insert(NO, TITLE, CONTENT, WRITER);
	}
}
