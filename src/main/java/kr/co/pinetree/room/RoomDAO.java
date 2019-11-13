package kr.co.pinetree.room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBOpen;
import kr.co.pinetree.reservation.CartDTO;

public class RoomDAO {
	/* 1) Room List */
	public ArrayList<RoomDTO> list(){
		ArrayList<RoomDTO> list=null;
		try {
			//1.db connection
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
			System.out.println("roomlist�떎�뙣:"+e);
		}//try end
		return list;
	}//list() end
	
	/* 2) Room Read */
	public RoomDTO read(String room_id) {
		RoomDTO dto = null;
		try {
			// 1. DB연결: DBOpen.java와 연결한다.
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();

			// 2. Select SQL문 작성
			sql.append(" SELECT room_id, room_name, room_info, room_etc, room_price ");
			sql.append(" FROM pn_room ");
			sql.append(" WHERE room_id=? ");

			// 3. SQL문 변환
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, room_id); // ?순서와 ?에 들어갈 자료형 주의

			// 4. 결과를 rs에 저장
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				do {
					dto = new RoomDTO(); // 한 줄씩 저장하기
					dto.setRoom_id(rs.getString("room_id"));
					dto.setRoom_name(rs.getString("room_name"));
					dto.setRoom_info(rs.getString("room_info"));
					dto.setRoom_etc(rs.getString("room_etc"));
					dto.setRoom_price(rs.getInt("room_price"));
				} while (rs.next());
			} else {
				dto = null;
			} // if end
		} catch (Exception e) {
			System.out.println("정보 열람실패:" + e);
		}
		return dto;
	}
	
	/* 3) Cart Data Insert */
	public int create(CartDTO dto) {
		int cnt=0;
		try {
			//1.db connection
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" INSERT INTO pn_cart(room_id) ");
			sql.append(" VALUES(?) ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getRoom_id());
			cnt=pstmt.executeUpdate();
		}catch (Exception e) {
			System.out.println("媛앹떎寃��깋�떎�뙣:"+e);
		}//try end
		return cnt;
	}//create end
		
	
	/* 4) Room Search */
	public ArrayList<RsRoomDTO> roomSearch (String chin, String chout, String rt, int cart_oprm) {
		ArrayList<RsRoomDTO> list = null;
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();
							
			sql.append(" SELECT COUNT(PR.room_id) AS cnt , PR.room_id, PR.room_name, PR.room_info, PR.room_etc, PR.room_price ");
			sql.append(" FROM pn_room as PR LEFT JOIN ( SELECT AA.room_id,PC.cart_chin, PC.cart_chout FROM ");
			sql.append(" 	( SELECT PL.od_no, PL.room_id, PO.od_now, PL.cart_date ");
			sql.append(" 	FROM pn_orderlist as PL JOIN pn_order as PO ");
			sql.append(" 		 on PL.od_no = PO.od_no ) as AA ");
			sql.append(" 		JOIN pn_cart AS PC ON AA.cart_date = PC.cart_date ");
			sql.append(" 		WHERE PC.cart_chin >='" + chin + "' " );
			sql.append(" 		AND PC.cart_chout <='" + chout + "' " );
			sql.append(" 	) AS BB on PR.room_id = BB.room_id  " );
			sql.append(" 	WHERE BB.room_id IS NULL " );
									
			String word = "";
			if(rt.trim().length() >= 1) {
				if (rt.equals("SU")) {
					rt = "R_A";
					word += "AND PR.room_id LIKE '%" + rt + "%' ";
				} else if (rt.equals("DE")) {
					rt = "R_B";
					word += "AND PR.room_id LIKE '%" + rt + "%' ";
				} else if (rt.equals("ST")) {
					rt = "R_C";
					word += "AND PR.room_id LIKE '%" + rt + "%' ";
				}				
			}// if end
			sql.append(word);			
			sql.append(" GROUP BY PR.room_name " );	
			sql.append(" HAVING cnt >= " + cart_oprm );	
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<RsRoomDTO>();
				do {
					RsRoomDTO dto=new RsRoomDTO();
					dto.setRoom_id(rs.getString("room_id"));
					dto.setRoom_name(rs.getString("room_name"));					
					dto.setRoom_info(rs.getString("room_info"));					
					dto.setRoom_etc(rs.getString("room_etc"));					
					dto.setRoom_price(rs.getString("room_price"));					
					list.add(dto);
				}while(rs.next());
			}else {
				list=null;
			}//if end
		}catch(Exception e) {
			System.out.println("Room Search Failed:"+e );
		}//try end
		return list;
	}//list() end
				
}//class end
