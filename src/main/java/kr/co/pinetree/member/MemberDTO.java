package kr.co.pinetree.member;

public class MemberDTO {
	private String ac_id;
	private String ac_name_kor;
	private String ac_name_eng;
	private String ac_passwd;
	private String ac_phone;
	private String ac_email;
	private String ac_grade;
	private int ac_stay;
	private String ac_date;
	private String ac_logindate;
	
	public MemberDTO() {}

	public String getAc_id() {
		return ac_id;
	}

	public void setAc_id(String ac_id) {
		this.ac_id = ac_id;
	}

	public String getAc_name_kor() {
		return ac_name_kor;
	}

	public void setAc_name_kor(String ac_name_kor) {
		this.ac_name_kor = ac_name_kor;
	}

	public String getAc_name_eng() {
		return ac_name_eng;
	}

	public void setAc_name_eng(String ac_name_eng) {
		this.ac_name_eng = ac_name_eng;
	}

	public String getAc_passwd() {
		return ac_passwd;
	}

	public void setAc_passwd(String ac_passwd) {
		this.ac_passwd = ac_passwd;
	}

	public String getAc_phone() {
		return ac_phone;
	}

	public void setAc_phone(String ac_phone) {
		this.ac_phone = ac_phone;
	}

	public String getAc_email() {
		return ac_email;
	}

	public void setAc_email(String ac_email) {
		this.ac_email = ac_email;
	}
	
	public String getAc_grade() {
		return ac_grade;
	}

	public void setAc_grade(String ac_grade) {
		this.ac_grade = ac_grade;
	}

	public int getAc_stay() {
		return ac_stay;
	}

	public void setAc_stay(int ac_stay) {
		this.ac_stay = ac_stay;
	}

	public String getAc_date() {
		return ac_date;
	}

	public void setAc_date(String ac_date) {
		this.ac_date = ac_date;
	}

	public String getAc_logindate() {
		return ac_logindate;
	}

	public void setAc_logindate(String ac_logindate) {
		this.ac_logindate = ac_logindate;
	}

	@Override
	public String toString() {
		return "MemberDTO [ac_id=" + ac_id + ", ac_name=" + ac_name_kor + ", ac_name_eng=" + ac_name_eng + ", ac_passwd="
				+ ac_passwd + ", ac_phone=" + ac_phone + ", ac_email=" + ac_email + ", ac_grade=" + ac_grade
				+ ", ac_stay=" + ac_stay + ", ac_date=" + ac_date + ", ac_logindate=" + ac_logindate + "]";
	}
	
}
