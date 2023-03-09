package 자바DB연결;

public class 회원가입 {
	public static void main(String[] args) {

		MemberDAO dao = new MemberDAO();
		// 1. MemberDAO.java 에서 적어준 win6 만들기 실행
		// 2. MemberDAO.java 에서 바꿔준 win7 만들기 실행
		dao.insert();
	}
}
