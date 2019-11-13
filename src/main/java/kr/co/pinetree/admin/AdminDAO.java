package kr.co.pinetree.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBPKG.DBOpen;
import kr.co.pinetree.reservation.OrderDTO;
import kr.co.pinetree.reservation.OrderlistDTO;

public class AdminDAO {
	// 1) Reservation List
	public ArrayList<ReserveDTO> reservelist() {
		ArrayList<ReserveDTO> reservelist = null;
		try {
			// db�뿰寃�
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT DISTINCT O.ol_num, O.od_no, O.room_id, O.cart_date, C.ac_id ");
			sql.append(" FROM pn_orderlist O join pn_cart C ");
			sql.append(" 	on O.room_id=C.room_id ");
			sql.append(" 	GROUP BY ol_num, ac_id ");
			sql.append(" 	ORDER BY cart_date DESC ");

			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				reservelist = new ArrayList<ReserveDTO>();
				do {
					ReserveDTO dto = new ReserveDTO();
					dto.setOl_num(rs.getInt("ol_num"));
					dto.setAc_id(rs.getString("ac_id"));
					dto.setRoom_id(rs.getString("room_id"));
					dto.setCart_date(rs.getString("cart_date"));
					dto.setOd_no(rs.getInt("od_no"));
					reservelist.add(dto);
				} while (rs.next());
			} else {
				reservelist = null;
			} // if end
		} catch (Exception e) {
			System.out.println("Reservation List Failed : " + e);
		} // try end
		return reservelist;
	}// list() end

	// 2) Reservation Read
	public ReserveDTO read(int ol_num) {
		ReserveDTO dto = null;
		try {
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT ol_num,ac_id,room_id,cart_date,cart_op_ad,cart_op_bb,cart_no,cart_op_bed,cart_adno,cart_bbno,cart_chin,cart_chout,od_no,od_now,od_total ");
            sql.append(" FROM( ");
            sql.append("     SELECT L.ol_num, A.* ");
            sql.append("     FROM( ");
            sql.append("         SELECT C.ac_id,C.cart_no,C.room_id,C.cart_date,C.cart_op_ad,C.cart_op_bb,C.cart_op_bed,C.cart_adno,C.cart_bbno,C.cart_chin,C.cart_chout,O.od_no,O.od_total,O.od_now ");
            sql.append("         FROM pn_cart C JOIN pn_order O ");
            sql.append("         ON C.ac_id=O.ac_id) A JOIN pn_orderlist L ");
            sql.append("     ON A.room_id=L.room_id) B ");
            sql.append(" WHERE ol_num=? ");
            sql.append(" ORDER BY cart_date DESC ");
			
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, ol_num);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new ReserveDTO();
				dto.setAc_id(rs.getString("ac_id"));
				dto.setRoom_id(rs.getString("room_id"));
				dto.setCart_date(rs.getString("cart_date"));
				dto.setCart_op_ad(rs.getInt("cart_op_ad"));
				dto.setCart_op_bb(rs.getInt("cart_op_bb"));
				dto.setCart_no(rs.getInt("cart_no"));
				dto.setCart_op_bed(rs.getInt("cart_op_bed"));
				dto.setCart_adno(rs.getInt("cart_adno"));
				dto.setCart_bbno(rs.getInt("cart_bbno"));
				dto.setCart_chin(rs.getString("cart_chin"));
				dto.setCart_chout(rs.getString("cart_chout"));
				dto.setOd_no(rs.getInt("od_no"));
				dto.setOl_num(rs.getInt("ol_num"));
				dto.setOd_total(rs.getInt("od_total"));
				dto.setOd_now(rs.getString("od_now"));
			} else {
				dto = null;
			} // if end
		} catch (Exception e) {
			System.out.println("Reservation Read Failed : " + e);
		} // try end
		return dto;
	}// read() end

	// 3) Reservation Update
	public int update(ReserveDTO dto) {
		int cnt = 0;
		try {
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE pn_cart ");
			sql.append(
					" SET room_id=?,cart_chin=?,cart_chout=?,cart_op_ad=?,cart_op_bb=?,cart_oprm=?,cart_adno=?,cart_bbno=?,cart_op_bed=? ");
			sql.append(" WHERE cart_no=? ");

			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getRoom_id());
			pstmt.setString(2, dto.getCart_chin());
			pstmt.setString(3, dto.getCart_chout());
			pstmt.setInt(4, dto.getCart_op_ad());
			pstmt.setInt(5, dto.getCart_op_bb());
			pstmt.setInt(6, dto.getCart_oprm());
			pstmt.setInt(7, dto.getCart_adno());
			pstmt.setInt(8, dto.getCart_bbno());
			pstmt.setInt(9, dto.getCart_op_bed());
			pstmt.setInt(10, dto.getCart_no());

			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Reservation Update Failed : " + e);
		} // try end
		return cnt;
	}// update() end

	// 4) Reservation Create
	public int create(ReserveDTO dto) {
		int cnt = 0;
		try {
			// db connection
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO pn_cart(ac_id,cart_no,cart_date,room_id,cart_chin,cart_chout,cart_op_ad,cart_op_bb,cart_oprm,cart_bbno,cart_adno,cart_op_bed) ");
			sql.append(" VALUES('MASTER',(SELECT IFNULL(MAX(cart_no),0)+1 FROM pn_cart ALIAS_FOR_SUBQUERY),NOW(),?,?,?,?,?,?,?,?,?) ");

			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getRoom_id());
			pstmt.setString(2, dto.getCart_chin());
			pstmt.setString(3, dto.getCart_chout());
			pstmt.setInt(4, dto.getCart_op_ad());
			pstmt.setInt(5, dto.getCart_op_bb());
			pstmt.setInt(6, dto.getCart_oprm());
			pstmt.setInt(7, dto.getCart_bbno());
			pstmt.setInt(8, dto.getCart_adno());
			pstmt.setInt(9, dto.getCart_op_bed());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Reservation Create Failed : " + e);
		} // try end
		return cnt;
	}// insert() end

	/* Insert Order */ //오토인크리먼트
	public int orderinsert(OrderDTO dto) {
		int pcnt = 0;
		try {
			// 1. DB연결
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();
			// 2. Insert SQL문 작성
			sql.append(" INSERT INTO pn_order ( od_no, ac_id, cart_date, od_card, od_card_no, od_card_date, od_discount, ");
			sql.append(" od_name_kor, od_name_eng, od_phone, cp_no, od_point, od_total ) ");
			sql.append(" VALUES( (select ifnull(max(od_no),0)+1 from pn_order as od_no ) ");
			sql.append(",'MASTER' ,now() , 'C_VISA', '1032126324581230', '2205', NULL,'마스터' ,'MASTER','01012341234' , NULL, 0, 656400  ) ");
			// 3. SQL문 변환
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			// 4. Value값 불러오기
				
			// 5. 실행
			pcnt = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("1실패:" + e);
			}
			return pcnt;
		}
	
	
	/* Insert Olistinsert */
	  public int olistinsert(OrderlistDTO ldto) {
		int count = 0;
			try {
				// 1. DB연결
				Connection con = DBOpen.getConnetion();
				StringBuilder sql = new StringBuilder();
				// 2. Insert SQL문 작성
				sql.append(" INSERT INTO pn_orderlist ( ol_num, od_no, room_id, cart_date ) ");
				sql.append(" VALUES ( (select ifnull(max(ol_num),0)+1 from pn_orderlist as ol_num ) ");
				sql.append(" ,? ,? ,? ) ");
				// 3. SQL문 변환
				PreparedStatement pstmt = con.prepareStatement(sql.toString());
				// 4. Value값 불러오기
				pstmt.setInt(1, ldto.getOd_no());
				pstmt.setString(2, ldto.getRoom_id());
				pstmt.setString(3, ldto.getCart_date());
				// 5. 실행
				count = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("실패:" + e);
		}
			return count;
	}
	
	// 5) Reservation Delete
	public int delete(int ol_num) {
		int cnt = 0;
		try {
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();
			sql.append(" DELETE FROM pn_orderlist ");
			sql.append(" WHERE ol_num=? ");

			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, ol_num);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Reservation Delete Failed : " + e);
		} // try end
		return cnt;
	}// delete() end

	/* Account */
	// 1) Account List
	public ArrayList<AccountDTO> accountlist() {
		ArrayList<AccountDTO> accountlist = null;
		try {
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT ac_id,ac_name_kor,ac_name_eng,ac_passwd,ac_phone,ac_email,ac_grade,ac_stay,ac_date,ac_logindate ");
			sql.append(" FROM pn_account ");

			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				accountlist = new ArrayList<AccountDTO>();
				do {
					AccountDTO dto = new AccountDTO();
					dto.setAc_id(rs.getString("ac_id"));
					dto.setAc_name_kor(rs.getString("ac_name_kor"));
					dto.setAc_name_eng(rs.getString("ac_name_eng"));
					dto.setAc_passwd(rs.getString("ac_passwd"));
					dto.setAc_phone(rs.getString("ac_phone"));
					dto.setAc_email(rs.getString("ac_email"));
					dto.setAc_grade(rs.getString("ac_grade"));
					dto.setAc_stay(rs.getInt("ac_stay"));
					dto.setAc_date(rs.getString("ac_date"));
					dto.setAc_logindate(rs.getString("ac_logindate"));
					accountlist.add(dto);
				} while (rs.next());
			} else {
				accountlist = null;
			} // if end
		} catch (Exception e) {
			System.out.println("Account List Failed : " + e);
		} // try end
		return accountlist;
	}// list() end

	// 1-1) last login List
	public ArrayList<AccountDTO> loginlist(String ac_logindate) {
		ArrayList<AccountDTO> loginlist = null;
		try {
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT ac_logindate ");
			sql.append(" FROM pn_account ");

			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				loginlist = new ArrayList<AccountDTO>();
				do {
					AccountDTO dto = new AccountDTO();
					dto.setAc_logindate(rs.getString("ac_logindate"));
					loginlist.add(dto);
				} while (rs.next());
			} else {
				loginlist = null;
			} // if end
		} catch (Exception e) {
			System.out.println("lastlogin Failed : " + e);
		} // try end
		return loginlist;
	}// list() end
	
	// 2) Account Read
	public AccountDTO accountread(String ac_id) {
		AccountDTO dto = null;
		try {
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();

			sql.append(
					" SELECT ac_id,ac_name_kor,ac_name_eng,ac_passwd,ac_phone,ac_email,ac_grade,ac_stay,ac_date,ac_logindate ");
			sql.append(" FROM pn_account ");
			sql.append(" WHERE ac_id = ? ");

			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, ac_id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new AccountDTO();
				dto.setAc_id(rs.getString("ac_id"));
				dto.setAc_name_kor(rs.getString("ac_name_kor"));
				dto.setAc_name_eng(rs.getString("ac_name_eng"));
				dto.setAc_passwd(rs.getString("ac_passwd"));
				dto.setAc_phone(rs.getString("ac_phone"));
				dto.setAc_email(rs.getString("ac_email"));
				dto.setAc_grade(rs.getString("ac_grade"));
				dto.setAc_stay(rs.getInt("ac_stay"));
				dto.setAc_date(rs.getString("ac_date"));
				dto.setAc_logindate(rs.getString("ac_logindate"));
			} else {
				dto = null;
			} // if end
		} catch (Exception e) {
			System.out.println("Reservation Read Failed : " + e);
		} // try end
		return dto;
	}// read() end

	// 3) Account Update
	public int accountupdate(AccountDTO dto) {
		int cnt = 0;
		try {
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE pn_account ");
			sql.append(" SET ac_phone=?, ac_stay=?, ac_grade=? ");
			sql.append(" WHERE ac_id=? ");

			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getAc_phone());
			pstmt.setInt(2, dto.getAc_stay());
			pstmt.setString(3, dto.getAc_grade());
			pstmt.setString(4, dto.getAc_id());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Account Update Failed : " + e);
		} // try end
		return cnt;
	}// accountupdate() end

	// 4) Account Delete
	public int accountdelete(String ac_id) {
		int cnt = 0;
		try {
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();
			sql.append(" DELETE FROM pn_account ");
			sql.append(" WHERE ac_id=? ");

			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, ac_id);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Account Delete Failed : " + e);
		} // try end
		return cnt;
	}// delete() end

	// 5) //////// Stay Count ////////
	public void incrementCnt(int cart_no) {
		try {
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE tb_bbs ");
			sql.append(" SET readcnt=readcnt+1 ");
			sql.append(" WHERE bbsno=? ");

			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Stay Count Failed : " + e);
		} // try end
	}// incrementCnt() end

	/* 3) Room */
	// 1) count
	public int rooms() {
		int x = 0;
		try {
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();
			PreparedStatement pstmt = con.prepareStatement("SELECT COUNT(*) FROM pn_room");
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				x = rs.getInt(1);
			}
		} catch (Exception e) {
			System.out.println("error" + e);
		} // try

		return x;
	}// re_getArticleCount

	// 2) list + paging
	public List roomlist(int start, int end) {
		List roomlist = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT room_id, room_name, room_price, od_now, cart_date ");
		sql.append(" FROM(	 ");
		sql.append(" 	SELECT R.room_id,R.room_name,R.room_price,A.od_now,A.cart_date ");
		sql.append(" 	FROM( ");
		sql.append(" 		SELECT C.ac_id,C.room_id,O.od_now,C.cart_date ");
		sql.append(" 		FROM pn_cart C INNER JOIN pn_order O ");
		sql.append(" 		ON C.ac_id=O.ac_id) A RIGHT JOIN pn_room R ");
		sql.append(" 	ON A.room_id=R.room_id) B ");
		sql.append(" GROUP BY room_id ");
		sql.append(" ORDER BY cart_date DESC ");
		sql.append(" LIMIT ?, 20 ");

		try {
			Connection con = DBOpen.getConnetion();
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				roomlist = new ArrayList(end);
				do {
					RoomDTO dto = new RoomDTO();
					dto.setRoom_id(rs.getString("room_id"));
					dto.setRoom_name(rs.getString("room_name"));
					dto.setRoom_price(rs.getString("room_price"));
					dto.setOd_now(rs.getString("od_now"));
					dto.setCart_date(rs.getString("cart_date"));
					roomlist.add(dto);
				} while (rs.next());
			} // if

		} catch (Exception e) {
			System.out.println("error" + e);
		} // try
		return roomlist;
	}// re_getArticles

}
