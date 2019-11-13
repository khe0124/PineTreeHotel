package kr.co.pinetree.admin;


public class ReserveDTO {
	private String ac_id;
	private String room_id;
	private String cart_date;
	private int cart_op_ad;
	private int cart_op_bb;
	private int cart_op_bed;
	private String cart_chin;
	private String cart_chout;
	private int od_no;
	private String od_now;
	private int od_total;
	private int cart_oprm;
	private int cart_adno;
	private int cart_bbno;
	private int cart_no;
	private int ol_num;
	
	public ReserveDTO() {}

	public String getAc_id() {
		return ac_id;
	}

	public void setAc_id(String ac_id) {
		this.ac_id = ac_id;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getCart_date() {
		return cart_date;
	}

	public void setCart_date(String cart_date) {
		this.cart_date = cart_date;
	}

	public int getCart_op_ad() {
		return cart_op_ad;
	}

	public void setCart_op_ad(int cart_op_ad) {
		this.cart_op_ad = cart_op_ad;
	}

	public int getCart_op_bb() {
		return cart_op_bb;
	}

	public void setCart_op_bb(int cart_op_bb) {
		this.cart_op_bb = cart_op_bb;
	}

	public int getCart_op_bed() {
		return cart_op_bed;
	}

	public void setCart_op_bed(int cart_op_bed) {
		this.cart_op_bed = cart_op_bed;
	}




	public String getCart_chin() {
		return cart_chin;
	}

	public void setCart_chin(String cart_chin) {
		this.cart_chin = cart_chin;
	}

	public String getCart_chout() {
		return cart_chout;
	}

	public void setCart_chout(String cart_chout) {
		this.cart_chout = cart_chout;
	}

	public int getOd_no() {
		return od_no;
	}

	public void setOd_no(int od_no) {
		this.od_no = od_no;
	}

	public String getOd_now() {
		return od_now;
	}

	public void setOd_now(String od_now) {
		this.od_now = od_now;
	}

	public int getOd_total() {
		return od_total;
	}

	public void setOd_total(int od_total) {
		this.od_total = od_total;
	}

	public int getCart_oprm() {
		return cart_oprm;
	}

	public void setCart_oprm(int cart_oprm) {
		this.cart_oprm = cart_oprm;
	}

	public int getCart_adno() {
		return cart_adno;
	}

	public void setCart_adno(int cart_adno) {
		this.cart_adno = cart_adno;
	}

	public int getCart_bbno() {
		return cart_bbno;
	}

	public void setCart_bbno(int cart_bbno) {
		this.cart_bbno = cart_bbno;
	}

	public int getCart_no() {
		return cart_no;
	}

	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}

	public int getOl_num() {
		return ol_num;
	}

	public void setOl_num(int ol_num) {
		this.ol_num = ol_num;
	}

	@Override
	public String toString() {
		return "ReserveDTO [ac_id=" + ac_id + ", room_id=" + room_id + ", cart_date=" + cart_date + ", cart_op_ad="
				+ cart_op_ad + ", cart_op_bb=" + cart_op_bb + ", cart_op_bed=" + cart_op_bed + ", cart_chin="
				+ cart_chin + ", cart_chout=" + cart_chout + ", od_no=" + od_no + ", od_now=" + od_now + ", od_total="
				+ od_total + ", cart_oprm=" + cart_oprm + ", cart_adno=" + cart_adno + ", cart_bbno=" + cart_bbno
				+ ", cart_no=" + cart_no + ", ol_num=" + ol_num + "]";
	}



	
}//class end
