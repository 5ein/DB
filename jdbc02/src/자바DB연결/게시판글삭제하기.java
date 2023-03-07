package 자바DB연결;

import java.util.Scanner;

public class 게시판글삭제하기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("삭제 할 NO 입력하세요.");

		int NO = sc.nextInt(); // NO 가 Int 이기 때문에 nextInt();

		BbsDAO dao = new BbsDAO();
		dao.delete(NO);
	}
}
