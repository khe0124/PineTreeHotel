package kr.co.pinetree.contact;

import org.springframework.web.multipart.MultipartFile;

public class EmailDTO {
	private int em_num;
	private String em_name;
	private String em_title;
	private String em_cont;
	private String em_email;
	private String em_phone;
	private String em_filename;
	private Long em_filesize;
	private String em_date;
	private String em_check;
	
	public String getEm_check() {
		return em_check;
	}
	public void setEm_check(String em_check) {
		this.em_check = em_check;
	}
	private MultipartFile file;
	
	public int getEm_num() {
		return em_num;
	}
	public void setEm_num(int em_num) {
		this.em_num = em_num;
	}
	public String getEm_name() {
		return em_name;
	}
	public void setEm_name(String em_name) {
		this.em_name = em_name;
	}
	public String getEm_title() {
		return em_title;
	}
	public void setEm_title(String em_title) {
		this.em_title = em_title;
	}
	public String getEm_cont() {
		return em_cont;
	}
	public void setEm_cont(String em_cont) {
		this.em_cont = em_cont;
	}
	public String getEm_email() {
		return em_email;
	}
	public void setEm_email(String em_email) {
		this.em_email = em_email;
	}
	public String getEm_phone() {
		return em_phone;
	}
	public void setEm_phone(String em_phone) {
		this.em_phone = em_phone;
	}
	public String getEm_filename() {
		return em_filename;
	}
	public void setEm_filename(String em_filename) {
		this.em_filename = em_filename;
	}
	public Long getEm_filesize() {
		return em_filesize;
	}
	public void setEm_filesize(Long em_filesize) {
		this.em_filesize = em_filesize;
	}
	public String getEm_date() {
		return em_date;
	}
	public void setEm_date(String em_date) {
		this.em_date = em_date;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	
	
}//