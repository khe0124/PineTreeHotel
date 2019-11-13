package kr.co.pinetree.promotions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBOpen;

public class PromoDAO {
	// ----------------------------notice

	// List
	public ArrayList<NoticeDTO> nt_list() {
		ArrayList<NoticeDTO> list = null;

		try {
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();

			sql.append(" SELECT nt_num, nt_title, nt_cont, nt_date, nt_visitnum, nt_filename, nt_filesize");
			sql.append(" FROM pn_notice ");
			sql.append(" ORDER BY nt_num DESC ");
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				list = new ArrayList<NoticeDTO>();
				do {
					NoticeDTO dto = new NoticeDTO();
					dto.setNt_num(rs.getInt("nt_num"));
					dto.setNt_title(rs.getString("nt_title"));
					dto.setNt_cont(rs.getString("nt_cont"));
					dto.setNt_date(rs.getString("nt_date"));
					dto.setNt_visitnum(rs.getInt("nt_visitnum"));
					dto.setNt_filename(rs.getString("nt_filename"));
					dto.setNt_filesize(rs.getInt("nt_filesize"));
					list.add(dto);
				} while (rs.next());
			} else {
				list = null;

			}
		} catch (Exception e) {
			System.out.println("목록 보기 실패: " + e);
		}
		return list;
	}

	// Create

	public int nt_create(NoticeDTO dto) {
		int cnt = 0;

		try {
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO pn_notice(nt_num, nt_title, nt_cont, nt_filename, nt_filesize )");
			sql.append(" VALUES( (SELECT IFNULL(MAX(nt_num),0 )+1 FROM pn_notice), ?,?,?,? ");
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getNt_title());
			pstmt.setString(2, dto.getNt_cont());
			pstmt.setString(3, dto.getNt_filename());
			pstmt.setInt(4, dto.getNt_filesize());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Create failed: " + e);
		} // try end

		return cnt;
	}// nt_create end

	// Read

	public NoticeDTO nt_read(int nt_num) {
		NoticeDTO dto = null;

		try {
			Connection con = DBOpen.getConnetion();
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT nt_num, nt_title, nt_cont, nt_date, nt_visitnum, nt_filename, nt_filesize");
			sql.append(" FROM pn_notice ");
			sql.append(" WHERE nt_num=? ");
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, nt_num);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new NoticeDTO();
				dto.setNt_num(rs.getInt("nt_num"));
				dto.setNt_title(rs.getString("nt_title"));
				dto.setNt_cont(rs.getString("nt_cont"));
				dto.setNt_date(rs.getString("nt_date").substring(0, 10));
				dto.setNt_visitnum(rs.getInt("nt_visitnum"));
				dto.setNt_filename(rs.getString("nt_filename"));
				dto.setNt_filesize(rs.getInt("nt_filesize"));
			} else {
				dto=null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Read Failed: "+e);
		}//try end
		return dto;
	}//nt_read() end
	
	//------------Promotions------------
	
	//pm_list
	 
	
	
	 
}
