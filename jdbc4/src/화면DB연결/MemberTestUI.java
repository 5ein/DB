package 화면DB연결;

import javax.swing.JOptionPane;

import 자바DB연결.MemberDAO3;

public class MemberTestUI {

	public static void main(String[] args) {
		String id = JOptionPane.showInputDialog("아이디 입력");
		String pw = JOptionPane.showInputDialog("패스워드 입력");
		
		MemberDAO3 dao = new MemberDAO3();
		
		//보내는 쪽
		//1. 가방만들기
		MemberVO bag = new MemberVO();
		//2. 가방에 입력값 넣기 (set() 이용)
		bag.setId(id);
		bag.setPw(pw);
			//name, tel은 null이 들어가있는 상태
		//3. 가방을 DAO에 전달하기
		int result = dao.login(bag);
		if (result == 1) { //1:성공, 0:실패
			JOptionPane.showMessageDialog(null, "로그인 성공");
			BbsUI bbs = new BbsUI();
			bbs.open();
		}else {
			JOptionPane.showMessageDialog(null, "로그인실패");
			MemberUI2 member = new MemberUI2();
			member.open();
		} 
		
		
		
		
		
	}

}
