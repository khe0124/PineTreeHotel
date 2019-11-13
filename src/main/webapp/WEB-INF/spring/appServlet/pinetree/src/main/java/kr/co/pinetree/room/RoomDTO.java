package kr.co.pinetree.room;

public class RoomDTO {
	  private String room_id;
	  private String room_name;
	  private String room_info;
	  private String room_etc;
	  private int room_price;
	  private String room_filename;
	  private int room_filesize;
	  private String room_date;
	  
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

	public int getRoom_price() {
		return room_price;
	}

	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}

	public String getRoom_filename() {
		return room_filename;
	}

	public void setRoom_filename(String room_filename) {
		this.room_filename = room_filename;
	}

	public int getRoom_filesize() {
		return room_filesize;
	}

	public void setRoom_filesize(int room_filesize) {
		this.room_filesize = room_filesize;
	}

	public String getRoom_date() {
		return room_date;
	}

	public void setRoom_date(String room_date) {
		this.room_date = room_date;
	}

	@Override
	public String toString() {
		return "RoomDTO [room_id=" + room_id + ", room_name=" + room_name + ", room_info=" + room_info + ", room_etc="
				+ room_etc + ", room_price=" + room_price + ", room_filename=" + room_filename + ", room_filesize="
				+ room_filesize + ", room_date=" + room_date + "]";
	}
	  
	
}//class end
