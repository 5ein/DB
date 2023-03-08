package 자바DB연결;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

public class 반환값연습 {
	// 부품은 기능을 처리하기 위해서 만든 부품.
	// ex)휴대폰의 기능 ==> 함수(메서드)
	// 자동완성 ==> 컨트롤 + 스페이스바
	public void add2() {
		System.out.println("더하기 기능을 수행합니다.");
	}

	public int add(int x, int y) {
		return x + y; // x + y 결과값은 int 이기 때문에 뒤에 public옆에 int 적기
	}

	// 자바는 입력값이 다르다면, 메서드이름을 동일하게 사용할 수 있다.
	public double add(double x, int y) {
		return x + y; // 자바에서는 하나라도 double이면 결과는 무조건 double!!
	}

	public String add(String x, String y) {
		return x + y; // +연산자인 경우 하나라도 String이면 결과는 무조건 String!!
	}

	public String add(int x, String y) {
		return x + y; // +연산자인 경우 하나라도 String이면 결과는 무조건 String!!
	}

	public int[] add() {
		int[] x = { 1, 2, 3 };
		return x; // x앖에 있는 타입(int[])을 써준다.
	}

	public Date getDate() {
		Date date = new Date(); // import java.until.Date;
		return date; // 실행했을 때: 년월일시분초요일 ==> Date로 넘김
	}

	public int getHour() {
		Date date = new Date(); // import java.until.Date;
		return date.getHours(); // 시 11 만 넘김 ==> int로 넘김
	}

	public Random getRandom() {
		Random r = new Random();
		return r; // r을 리턴하니까 r 앞에있는 Random을 public 옆에 써줌
	}

	public int getRandom2() {
		Random r = new Random();
		return r.nextInt(); // -21억~21억
		// r.nextInt() 을 리턴하니까 결과인 int를 public 옆에 써줌
	}

	public ArrayList getList() {
		ArrayList list = new ArrayList();
		list.add("감자");
		list.add("고구마");
		return list; // list를 리턴하니까 list 앞에있는 ArrayList를 public 옆에 써줌
	}

	public HashSet getSet() {
		HashSet bag = new HashSet();
		bag.add("휴지");
		bag.add("펜");
		return bag; // bag을 리턴하니까 bag 앞에있는 HashSet을 public 옆에 써줌
	}

//	public Connection getConnection(String url, String user, String password) {
//	//연결처리..
//	Connection con = 연결처리하는 커넥션..;
//	return con;
//}

}
