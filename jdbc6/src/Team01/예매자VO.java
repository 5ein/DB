package Team01;

public class 예매자VO {
	
	private String 전화번호;
	private String 이메일;
	private String 이름;
	
	public String get전화번호() {
		return 전화번호;
	}
	public void set전화번호(String 전화번호) {
		this.전화번호 = 전화번호;
	}
	public String get이메일() {
		return 이메일;
	}
	public void set이메일(String 이메일) {
		this.이메일 = 이메일;
	}
	public String get이름() {
		return 이름;
	}
	public void set이름(String 이름) {
		this.이름 = 이름;
	}
	
	@Override
	public String toString() {
		return "예매자VO [전화번호=" + 전화번호 + ", 이메일=" + 이메일 + ", 이름=" + 이름 + "]";
	}
	
}
