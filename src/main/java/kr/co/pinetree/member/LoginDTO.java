package kr.co.pinetree.member;

public class LoginDTO {
	private String ac_id;
	private String ac_passwd;
	private String ac_grade;
	private boolean useCookie;
	
	public LoginDTO() {}

	public String getAc_id() {
		return ac_id;
	}

	public void setAc_id(String ac_id) {
		this.ac_id = ac_id;
	}

	public String getAc_passwd() {
		return ac_passwd;
	}

	public void setAc_passwd(String ac_passwd) {
		this.ac_passwd = ac_passwd;
	}

	public String getAc_grade() {
		return ac_grade;
	}

	public void setAc_grade(String ac_grade) {
		this.ac_grade = ac_grade;
	}

	public boolean isUseCookie() {
		return useCookie;
	}

	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	
}
