package kr.co.pinetree.reservation;
import org.springframework.web.multipart.MultipartFile;

public class CartDTO {
	 private int cart_no;
	 private String ac_id;
	 private String room_id;
	 private String room_name;
	 private String room_price;
	 private String cart_date;
	 private int cart_op_ad;
	 private int cart_op_bb;
	 private int cart_op_bed;
	 private int cart_oprm;
	 private int cart_adno;
	 private int cart_bbno;
	 private String cart_chin;
	 private String cart_chout;
	 
		 
	public CartDTO() {}
	
	public int getCart_no() {
		return cart_no;
	}
	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}
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
	
	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getRoom_price() {
		return room_price;
	}

	public void setRoom_price(String room_price) {
		this.room_price = room_price;
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
	
	@Override
	public String toString() {
		return "Pn_cartDTO [cart_no=" + cart_no + ", ac_id=" + ac_id + ", room_id=" + room_id + ", cart_date="
				+ cart_date + ", cart_op_ad=" + cart_op_ad + ", cart_op_bb=" + cart_op_bb + ", cart_op_bed="
				+ cart_op_bed + ", cart_chin=" + cart_chin + ", cart_chout=" + cart_chout + "]";
	}
}
