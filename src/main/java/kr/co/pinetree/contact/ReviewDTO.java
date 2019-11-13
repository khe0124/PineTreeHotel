package kr.co.pinetree.contact;

import org.springframework.web.multipart.MultipartFile;

public class ReviewDTO {
	
	private int re_num;
	private String ac_id;
	private String re_title;
	private String re_cont;
	private String re_date;
	private String re_passwd;
	private int re_visitnum;
	private String re_filename;
	private Long re_filesize;
	
	private MultipartFile file;
	public int getRe_num() {
		return re_num;
	}
	public void setRe_num(int re_num) {
		this.re_num = re_num;
	}
	public String getAc_id() {
		return ac_id;
	}
	public void setAc_id(String ac_id) {
		this.ac_id = ac_id;
	}
	public String getRe_title() {
		return re_title;
	}
	public void setRe_title(String re_title) {
		this.re_title = re_title;
	}
	public String getRe_cont() {
		return re_cont;
	}
	public void setRe_cont(String re_cont) {
		this.re_cont = re_cont;
	}
	public String getRe_date() {
		return re_date;
	}
	public void setRe_date(String re_date) {
		this.re_date = re_date;
	}
	public String getRe_passwd() {
		return re_passwd;
	}
	public void setRe_passwd(String re_passwd) {
		this.re_passwd = re_passwd;
	}
	public int getRe_visitnum() {
		return re_visitnum;
	}
	public void setRe_visitnum(int re_visitnum) {
		this.re_visitnum = re_visitnum;
	}
	public String getRe_filename() {
		return re_filename;
	}
	public void setRe_filename(String re_filename) {
		this.re_filename = re_filename;
	}
	public Long getRe_filesize() {
		return re_filesize;
	}
	public void setRe_filesize(Long re_filesize) {
		this.re_filesize = re_filesize;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
}//
