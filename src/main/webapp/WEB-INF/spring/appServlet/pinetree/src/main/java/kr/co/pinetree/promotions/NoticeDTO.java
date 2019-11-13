package kr.co.pinetree.promotions;

import org.springframework.web.multipart.MultipartFile;

public class NoticeDTO {
	private int nt_num;
	private String nt_title;
	private String nt_cont;
	private String nt_date;
	private int nt_visitnum;
	private String nt_filename;
	private int nt_filesize;
	
	
	
	
	//------------------------------------------------
//  스프링 파일 객체 멤버변수
//  <input type='file' name='posterMF'>
    private MultipartFile posterMF;    
//  <input type='file' name='filenameMF'>
    private MultipartFile filenameMF;
//------------------------------------------------
    
    
	public int getNt_num() {
		return nt_num;
	}
	public MultipartFile getPosterMF() {
		return posterMF;
	}
	public void setPosterMF(MultipartFile posterMF) {
		this.posterMF = posterMF;
	}
	public MultipartFile getFilenameMF() {
		return filenameMF;
	}
	public void setFilenameMF(MultipartFile filenameMF) {
		this.filenameMF = filenameMF;
	}
	public void setNt_num(int nt_num) {
		this.nt_num = nt_num;
	}
	public String getNt_title() {
		return nt_title;
	}
	public void setNt_title(String nt_title) {
		this.nt_title = nt_title;
	}
	public String getNt_cont() {
		return nt_cont;
	}
	public void setNt_cont(String nt_cont) {
		this.nt_cont = nt_cont;
	}
	public String getNt_filename() {
		return nt_filename;
	}
	public void setNt_filename(String nt_filename) {
		this.nt_filename = nt_filename;
	}
	public int getNt_filesize() {
		return nt_filesize;
	}
	public void setNt_filesize(int nt_filesize) {
		this.nt_filesize = nt_filesize;
	}
	public String getNt_date() {
		return nt_date;
	}
	public void setNt_date(String nt_date) {
		this.nt_date = nt_date;
	}
	public int getNt_visitnum() {
		return nt_visitnum;
	}
	public void setNt_visitnum(int nt_visitnum) {
		this.nt_visitnum = nt_visitnum;
	}
	
	
	
	
	
}
