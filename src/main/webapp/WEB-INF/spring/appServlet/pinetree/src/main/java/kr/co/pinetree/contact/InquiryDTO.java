package kr.co.pinetree.contact;

import org.springframework.web.multipart.MultipartFile;

public class InquiryDTO {
	private int iq_num;
	private String ac_id;
	private String iq_title;
	private String iq_email;
	private String iq_cont;
	private String iq_passwd;
	private String iq_date;
	private String iq_filename;
	private Long iq_filesize;
	private int iq_grpno;
	private int iq_order;
	private int iq_indent;
	private String iq_ip;
	private String iq_type;
	
	private MultipartFile file;

	public int getIq_num() {
		return iq_num;
	}

	public void setIq_num(int iq_num) {
		this.iq_num = iq_num;
	}

	public String getAc_id() {
		return ac_id;
	}

	public void setAc_id(String ac_id) {
		this.ac_id = ac_id;
	}

	public String getIq_title() {
		return iq_title;
	}

	public void setIq_title(String iq_title) {
		this.iq_title = iq_title;
	}

	public String getIq_email() {
		return iq_email;
	}

	public void setIq_email(String iq_email) {
		this.iq_email = iq_email;
	}

	public String getIq_cont() {
		return iq_cont;
	}

	public void setIq_cont(String iq_cont) {
		this.iq_cont = iq_cont;
	}

	public String getIq_passwd() {
		return iq_passwd;
	}

	public void setIq_passwd(String iq_passwd) {
		this.iq_passwd = iq_passwd;
	}

	public String getIq_date() {
		return iq_date;
	}

	public void setIq_date(String iq_date) {
		this.iq_date = iq_date;
	}

	public String getIq_filename() {
		return iq_filename;
	}

	public void setIq_filename(String iq_filename) {
		this.iq_filename = iq_filename;
	}

	public Long getIq_filesize() {
		return iq_filesize;
	}

	public void setIq_filesize(Long iq_filesize) {
		this.iq_filesize = iq_filesize;
	}

	public int getIq_grpno() {
		return iq_grpno;
	}

	public void setIq_grpno(int iq_grpno) {
		this.iq_grpno = iq_grpno;
	}

	public int getIq_order() {
		return iq_order;
	}

	public void setIq_order(int iq_order) {
		this.iq_order = iq_order;
	}

	public int getIq_indent() {
		return iq_indent;
	}

	public void setIq_indent(int iq_indent) {
		this.iq_indent = iq_indent;
	}

	public String getIq_ip() {
		return iq_ip;
	}

	public void setIq_ip(String iq_ip) {
		this.iq_ip = iq_ip;
	}

	public String getIq_type() {
		return iq_type;
	}

	public void setIq_type(String iq_type) {
		this.iq_type = iq_type;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	
	
	
	
	
}
