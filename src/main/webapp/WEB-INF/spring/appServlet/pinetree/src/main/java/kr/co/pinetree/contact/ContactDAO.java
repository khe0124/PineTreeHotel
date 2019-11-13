package kr.co.pinetree.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import DBPKG.DBOpen;

public class ContactDAO {
	
//-----------------------------review--------------------------------------------------------------------------------
	
	//추가
	public int re_create(ReviewDTO dto) {
		int cnt=0;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" INSERT INTO pn_review(ac_id, re_title,re_cont,re_date,re_passwd,re_filename,re_filesize) ");
			sql.append(" VALUES(?,?,?,NOW(),?,?,?) ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getAc_id());
			pstmt.setString(2, dto.getRe_title());
			pstmt.setString(3, dto.getRe_cont());
			pstmt.setString(4, dto.getRe_passwd());
			pstmt.setString(5, dto.getRe_filename());
			pstmt.setLong(6, dto.getRe_filesize());
			
			cnt=pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try

		return cnt;
	}//re_create
	
	//목록
	public ArrayList<ReviewDTO> re_list() {
		ArrayList<ReviewDTO> list=null;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" SELECT re_num,ac_id, re_title,re_cont,re_date,re_passwd,re_filename,re_filesize ");
			sql.append(" FROM pn_review ");
			sql.append(" ORDER BY re_num DESC ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<ReviewDTO>();
				do {
					ReviewDTO dto=new ReviewDTO();
					dto.setRe_num(rs.getInt("re_num"));
					dto.setAc_id(rs.getString("ac_id"));
					dto.setRe_title(rs.getString("re_title"));
					dto.setRe_cont(rs.getString("re_cont"));
					dto.setRe_date(rs.getString("re_date"));
					dto.setRe_passwd(rs.getString("re_passwd"));
					dto.setRe_filename(rs.getString("re_filename"));
					dto.setRe_filesize(rs.getLong("re_filesize"));
					list.add(dto);
				}while(rs.next());
				
			}else {
				list=null;
			}
			
			
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try
		
		return list;
	}//re_list
	
	//상세보기
	public ReviewDTO re_read(int re_num) {
		ReviewDTO dto=null;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" SELECT re_num,ac_id, re_title,re_cont,re_date,re_passwd,re_filename,re_filesize ");
			sql.append(" FROM pn_review ");
			sql.append(" WHERE re_num=? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, re_num);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new ReviewDTO();
				dto.setRe_num(rs.getInt("re_num"));
				dto.setAc_id(rs.getString("ac_id"));
				dto.setRe_title(rs.getString("re_title"));
				dto.setRe_cont(rs.getString("re_cont"));
				dto.setRe_date(rs.getString("re_date").substring(0,10));
				dto.setRe_passwd(rs.getString("re_passwd"));
				dto.setRe_filename(rs.getString("re_filename"));
				dto.setRe_filesize(rs.getLong("re_filesize"));
			}else {
				dto=null;
			}//if
			
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try
		
		return dto;
	}//re_read
	
	
	
//-----------------------------inquiry--------------------------------------------------------------------------------
	
	
	//추가
	public int iq_create(InquiryDTO dto) {
		int cnt=0;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" INSERT INTO pn_inquiry (iq_num,ac_id, iq_title, iq_email, iq_cont, iq_passwd,iq_filename,iq_filesize,iq_grpno,iq_ip,iq_type) ");
			sql.append(" VALUES((SELECT IFNULL(MAX(iq_num),0)+1 FROM pn_inquiry pn_iq),?,?,?,?,?,?,?,(SELECT IFNULL(MAX(iq_num),0)+1 FROM pn_inquiry pn_iq),?,?) ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getAc_id());
			pstmt.setString(2,dto.getIq_title());
			pstmt.setString(3,dto.getIq_email() );
			pstmt.setString(4,dto.getIq_cont());
			pstmt.setString(5, dto.getIq_passwd());
			pstmt.setString(6, dto.getIq_filename());
			pstmt.setLong(7, dto.getIq_filesize());
			pstmt.setString(8,dto.getIq_ip());
			pstmt.setString(9,dto.getIq_type());
			
			cnt=pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try

		return cnt;
	}//iq_create
		
	public ArrayList<InquiryDTO> iq_list() {
		ArrayList<InquiryDTO> list=null;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" SELECT iq_num, ac_id, iq_title,iq_email,iq_cont,iq_passwd,iq_date,iq_filename,iq_filesize,iq_grpno,iq_order,iq_indent,iq_ip,iq_type ");
			sql.append(" FROM pn_inquiry ");
			sql.append(" ORDER BY iq_num DESC ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<InquiryDTO>();
				do {
					InquiryDTO dto=new InquiryDTO();
					dto.setIq_num(rs.getInt("iq_num"));
					dto.setAc_id(rs.getString("ac_id"));
					dto.setIq_title(rs.getString("iq_title"));
					dto.setIq_email(rs.getString("iq_email"));
					dto.setIq_cont(rs.getString("iq_cont"));
					dto.setIq_passwd(rs.getString("iq_passwd"));
					dto.setIq_date(rs.getString("iq_date"));
					dto.setIq_filename(rs.getString("iq_filename"));
					dto.setIq_filesize(rs.getLong("iq_filesize"));
					dto.setIq_grpno(rs.getInt("iq_grpno"));
					dto.setIq_order(rs.getInt("iq_order"));
					dto.setIq_indent(rs.getInt("iq_indent"));
					dto.setIq_ip(rs.getString("iq_ip"));
					dto.setIq_type(rs.getString("iq_type"));
					list.add(dto);
				}while(rs.next());
				
			}else {
				list=null;
			}
			
			
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try
		
		return list;
	}//iq_list
	
	//상세보기
	public InquiryDTO iq_read(int iq_num,String iq_passwd) {
		InquiryDTO dto=null;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" SELECT iq_num, ac_id, iq_title,iq_email,iq_cont,iq_passwd,iq_date,iq_filename,iq_filesize,iq_grpno,iq_order,iq_ip,iq_type ");
			sql.append(" FROM pn_inquiry ");
			sql.append(" WHERE iq_num=? AND iq_passwd=? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, iq_num);
			pstmt.setString(2, iq_passwd);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new InquiryDTO();
				dto.setIq_num(rs.getInt("iq_num"));
				dto.setAc_id(rs.getString("ac_id"));
				dto.setIq_title(rs.getString("iq_title"));
				dto.setIq_email(rs.getString("iq_email"));
				dto.setIq_cont(rs.getString("iq_cont"));
				dto.setIq_passwd(rs.getString("iq_passwd"));
				dto.setIq_date(rs.getString("iq_date").substring(0,10));
				dto.setIq_filename(rs.getString("iq_filename"));
				dto.setIq_filesize(rs.getLong("iq_filesize"));
				dto.setIq_grpno(rs.getInt("iq_grpno"));
				dto.setIq_order(rs.getInt("iq_order"));
				dto.setIq_ip(rs.getString("iq_ip"));
				dto.setIq_type(rs.getString("iq_type"));
			}else {
				dto=null;
			}//if
			
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try
		
		return dto;
	}//iq_read	

	
	
	
	
//-----------------------------faq--------------------------------------------------------------------------------
	
	//추가
	public int fq_create(FaqDTO dto) {
		int cnt=0;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" INSERT INTO pn_faq(fq_num,fq_title,fq_cont,fq_type) ");
			sql.append(" VALUES((SELECT IFNULL(MAX(fq_num),0)+1 FROM pn_faq a),?,?,?) ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getFq_title());
			pstmt.setString(2, dto.getFq_cont());
			pstmt.setString(3, dto.getFq_type());

			cnt=pstmt.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try

		return cnt;
	}//fq_create
	
	//목록
	public ArrayList<FaqDTO> fq_list() {
		ArrayList<FaqDTO> list=null;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" SELECT fq_num,fq_title,fq_cont,fq_date,fq_visitnum,fq_type ");
			sql.append(" FROM pn_faq ");
			sql.append(" ORDER BY fq_num DESC ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<FaqDTO>();
				do {
					FaqDTO dto=new FaqDTO();
					dto.setFq_num(rs.getInt("fq_num"));
					dto.setFq_title(rs.getString("fq_title"));
					dto.setFq_cont(rs.getString("fq_cont"));
					dto.setFq_date(rs.getString("fq_date").substring(0,10));
					dto.setFq_visitnum(rs.getInt("fq_visitnum"));
					dto.setFq_type(rs.getString("fq_type"));
					list.add(dto);
				}while(rs.next());
				
			}else {
				list=null;
			}
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try
		
		return list;
	}//fq_list
	
	//상세보기
	public FaqDTO fq_read(int fq_num) {
		FaqDTO dto=null;
		
		try {
			Connection con=DBOpen.getConnetion();
			StringBuilder sql=new StringBuilder();
			sql.append(" SELECT fq_num,fq_title,fq_cont,fq_date,fq_visitnum,fq_type ");
			sql.append(" FROM pn_faq ");
			sql.append(" WHERE fq_num=? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, fq_num);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new FaqDTO();
				dto.setFq_num(rs.getInt("fq_num"));
				dto.setFq_title(rs.getString("fq_title"));
				dto.setFq_cont(rs.getString("fq_cont"));
				dto.setFq_date(rs.getString("fq_date").substring(0,10));
				dto.setFq_visitnum(rs.getInt("fq_visitnum"));
				dto.setFq_type(rs.getString("fq_type"));
			}else {
				dto=null;
			}//if
			
			
		}catch (Exception e) {
			System.out.println("error"+e);
		}//try
		
		return dto;
	}//fq_read		
	
}//end
