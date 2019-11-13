package kr.co.pinetree.member;

public class PointDTO {
	  private int num;
	  private String od_no;
	  private String ac_id;
	  private int ac_acpoint;
	  private int ac_total_acpoint;//총포인트합
	public int getAc_total_acpoint() {
		return ac_total_acpoint;
	}
	public void setAc_total_acpoint(int ac_total_acpoint) {
		this.ac_total_acpoint = ac_total_acpoint;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getOd_no() {
		return od_no;
	}
	public void setOd_no(String od_no) {
		this.od_no = od_no;
	}
	public String getAc_id() {
		return ac_id;
	}
	public void setAc_id(String ac_id) {
		this.ac_id = ac_id;
	}
	public int getAc_acpoint() {
		return ac_acpoint;
	}
	public void setAc_acpoint(int ac_acpoint) {
		this.ac_acpoint = ac_acpoint;
	}
	  
	  
	  
	  
}//
