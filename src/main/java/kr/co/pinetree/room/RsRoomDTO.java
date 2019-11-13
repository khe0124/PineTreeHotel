package kr.co.pinetree.room;

public class RsRoomDTO {
	  private String room_id;
	  private String room_name;
	  private String room_info;
	  private String room_etc;
	  private String room_price;	  
	  private String od_no;
	  private String od_now;
	  private String cart_date;	  
	  private int cart_oprm;
	  private int cart_adno;
	  private int cart_bbno;
	  private String cart_chin;
	  private String cart_chout;
	  
	  public RsRoomDTO() {}

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
			
	public String getRoom_info() {
		return room_info;
	}

	public void setRoom_info(String room_info) {
		this.room_info = room_info;
	}

	public String getRoom_etc() {
		return room_etc;
	}

	public void setRoom_etc(String room_etc) {
		this.room_etc = room_etc;
	}

	public String getRoom_price() {
		return room_price;
	}

	public void setRoom_price(String room_price) {
		this.room_price = room_price;
	}

	public String getOd_no() {
		return od_no;
	}

	public void setOd_no(String od_no) {
		this.od_no = od_no;
	}

	public String getOd_now() {
		return od_now;
	}

	public void setOd_now(String od_now) {
		this.od_now = od_now;
	}

	public String getCart_date() {
		return cart_date;
	}

	public void setCart_date(String cart_date) {
		this.cart_date = cart_date;
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
		return "RsRoomDTO [room_id=" + room_id + ", od_no=" + od_no + ", od_now=" + od_now + ", cart_date=" + cart_date
				+ ", cart_chin=" + cart_chin + ", cart_chout=" + cart_chout + "]";
	}
	  
}//class end
