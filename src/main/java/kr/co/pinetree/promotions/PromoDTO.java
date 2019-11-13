package kr.co.pinetree.promotions;


import org.springframework.web.multipart.MultipartFile;

public class PromoDTO {
	private int pm_num;
	private String pm_title;
	private String pm_cont;
	private String pm_date;
	private int pm_visitnum; 
	private String pm_filename;
	private Long pm_filesize;
	
	//file-----------------
	private MultipartFile file;

	public int getPm_num() {
		return pm_num;
	}

	public void setPm_num(int pm_num) {
		this.pm_num = pm_num;
	}

	public String getPm_title() {
		return pm_title;
	}

	public void setPm_title(String pm_title) {
		this.pm_title = pm_title;
	}

	public String getPm_cont() {
		return pm_cont;
	}

	public void setPm_cont(String pm_cont) {
		this.pm_cont = pm_cont;
	}

	public String getPm_date() {
		return pm_date;
	}

	public void setPm_date(String pm_date) {
		this.pm_date = pm_date;
	}

	public String getPm_filename() {
		return pm_filename;
	}

	public void setPm_filename(String pm_filename) {
		this.pm_filename = pm_filename;
	}

	public int getPm_visitnum() {
		return pm_visitnum;
	}

	public void setPm_visitnum(int pm_visitnum) {
		this.pm_visitnum = pm_visitnum;
	}

	public Long getPm_filesize() {
		return pm_filesize;
	}

	public void setPm_filesize(Long pm_filesize) {
		this.pm_filesize = pm_filesize;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
}
