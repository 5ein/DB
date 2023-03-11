package Project01;


public class 공연정보VO {

	private String ID;
	private String 제목;
	private String 위치;
	private String 가격;
	private String 공연시작일;
	private String 공연종료일;

	public String getID() {
		return ID;
	}

	
	public void setID(String ID) {
		this.ID = ID;
	}

	public String get제목() {
		return 제목;
	}

	public void set제목(String 제목) {
		this.제목 = 제목;
	}

	public String get위치() {
		return 위치;
	}

	public void set위치(String 위치) {
		this.위치 = 위치;
	}

	public String get가격() {
		return 가격;
	}

	public void set가격(String 가격) {
		this.가격 = 가격;
	}

	public String get공연시작일() {
		return 공연시작일;
	}

	public void set공연시작일(String 공연시작일) {
		this.공연시작일 = 공연시작일;
	}

	public String get공연종료일() {
		return 공연종료일;
	}

	public void set공연종료일(String 공연종료일) {
		this.공연종료일 = 공연종료일;
	}

	@Override
	public String toString() {
		return "공연정보VO [ID=" + ID + ", 제목=" + 제목 + ", 위치=" + 위치 + ", 가격=" + 가격 + ", 공연시작일=" + 공연시작일 + ", 공연종료일=" + 공연종료일
				+ "]";
	}

}
