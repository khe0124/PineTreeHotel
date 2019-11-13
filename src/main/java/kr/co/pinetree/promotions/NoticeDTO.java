package kr.co.pinetree.promotions;

import org.springframework.web.multipart.MultipartFile;

public class NoticeDTO {
	private int nt_num;
	private String nt_title;
	private String nt_cont;
	private String nt_date;
	private int nt_visitnum;
	private String nt_filename;
	private long nt_filesize;
    private MultipartFile file;    
    
	public NoticeDTO() {
	}

	public int getNt_num() {
		return nt_num;
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
	public long getNt_filesize() {
		return nt_filesize;
	}
	public void setNt_filesize(long nt_filesize) {
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
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}	
}
