package Team01;

import java.sql.Date;

public class 공연VO {

	private String 공연ID;
	private String 제목;
	private String 위치;
	private Date 공연시작일;
	private Date 공연종료일;
	private int 가격;

	public String get공연ID() {
		return 공연ID;
	}

	public void set공연ID(String 공연id) {
		공연ID = 공연id;
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

	public Date get공연시작일() {
		return 공연시작일;
	}

	public void set공연시작일(Date 공연시작일) {
		this.공연시작일 = 공연시작일;
	}

	public Date get공연종료일() {
		return 공연종료일;
	}

	public void set공연종료일(Date 공연종료일) {
		this.공연종료일 = 공연종료일;
	}

	public int get가격() {
		return 가격;
	}

	public void set가격(int 가격) {
		this.가격 = 가격;
	}

	@Override
	public String toString() {
		return "공연VO [공연ID=" + 공연ID + ", 제목=" + 제목 + ", 위치=" + 위치 + ", 공연시작일=" + 공연시작일 + ", 공연종료일=" + 공연종료일 + ", 가격="
				+ 가격 + "]";
	}

}
