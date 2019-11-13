package kr.co.pinetree.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBOpen;
import kr.co.pinetree.reservation.CartDTO;

public class RoomDAO {
	//1) list
	public ArrayList<RoomDTO> list(){
		ArrayList<RoomDTO> list=null;
		try {
			//1.db연결
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" SELECT room_id,room_name,room_info,room_etc,room_price,room_filename,room_filesize,room_date ");
			sql.append(" FROM pn_room ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<RoomDTO>();
				do {
					RoomDTO dto=new RoomDTO();
					dto.setRoom_id(rs.getString("room_id"));
					dto.setRoom_name(rs.getString("room_name"));
					dto.setRoom_info(rs.getString("room_info"));
					dto.setRoom_etc(rs.getString("room_etc"));
					dto.setRoom_price(rs.getInt("room_price"));
					dto.setRoom_filename(rs.getString("room_filename"));
					dto.setRoom_filesize(rs.getInt("room_filesize"));
					dto.setRoom_date(rs.getString("room_date"));
					list.add(dto);
				}while(rs.next());
			}else {
				list=null;
			}//if end
		}catch(Exception e) {
			System.out.println("roomlist실패:"+e);
		}//try end
		return list;
	}//list() end
	
	//2) 객실등록 insert
	public int create(CartDTO dto) {
		int cnt=0;
		try {
			//1.db연결
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" INSERT INTO pn_cart(room_id) ");
			sql.append(" VALUES(?) ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getRoom_id());
			cnt=pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("객실검색실패:"+e);
		}//try end
		return cnt;
	}//create end
	
}//class end
