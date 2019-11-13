package kr.co.pinetree.admin;

public class RoomDTO {
	private String room_id;
	private String room_name;
	private String room_price;
	private String cart_date;
	private String od_now;
	
	public RoomDTO() {}

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

	public String getOd_now() {
		return od_now;
	}

	public void setOd_now(String od_now) {
		this.od_now = od_now;
	}

	@Override
	public String toString() {
		return "RoomDTO [room_id=" + room_id + ", room_name=" + room_name + ", room_price=" + room_price
				+ ", cart_date=" + cart_date + ", od_now=" + od_now + "]";
	}
	
}//class end
