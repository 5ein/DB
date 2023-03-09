package 자바DB연결;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class 반환값받아오기 {

	public static void main(String[] args) {
//		전화기 tel = 전화기(); //모든기능을 다 사용하는 것은 아님
//		tel.인터넷하다();
//		tel.전화통화하다();
		반환값연습 re = new 반환값연습(); // 메서드 12개
		re.add2(); // 불꺼! 와 동일하게 수행 (void: 반환값없음)

		int result1 = re.add(200, 100); // int 300
		System.out.println("더한 값은 " + result1);

//		String data = JOptionPane.showInputDialog("입력"); //"aaa"
//		String data2 = JOptionPane.showMessageDialog(null, "출력값"); 
//		//void여서 입력값이 없기 때문에 오류남

		double result2 = re.add(22.1, 10);
		System.out.println("더한 값은 " + result2);

		String result3 = re.add("나는 ", "천재");
		System.out.println("더한 값은 " + result3);

		String result4 = re.add(1, "번 천재");
		System.out.println("더한 값은 " + result4);

		int[] result5 = re.add(); // {1, 2, 3}의 주소값이 들어있음
		result5[0] = 100; // result5[0]의 값을 바꿈
		System.out.println(result5[0]);
		System.out.println(result5[1]);
		System.out.println(result5[2]);
		
		Date result6 = re.getDate(); //자바 밑의 util로 불러와야함!
		// 실행했을 때의 년월일시분초요일
		System.out.println(result6.getHours());
		System.out.println(result6.getMinutes());
		System.out.println(result6.getSeconds());
		// 요일 0-일요일, 1-월요일, 2-화요일, ... 
		System.out.println(result6.getDay());
		// ==> 리턴이 없는 값은 프인트 불가!!
		// ==> result6.getHours() 얘내는 리턴이 있어서 프린트 가능!
		
		int result7 = re.getHour();
		System.out.println(result7 + "시 입니다. 수업중.");
		
		int result8 = re.getRandom2();
		System.out.println("랜덤한 정수는 " + result8);
		
		ArrayList result9 = re.getList();
		System.out.println(result9.get(0) + " " + result9.get(1));
		result9.set(0, "양파"); //0번 인덱스의 값 양파로 변경
		System.out.println(result9);
		
		HashSet result10 = re.getSet();
		System.out.println(result10);
		
	}

}
