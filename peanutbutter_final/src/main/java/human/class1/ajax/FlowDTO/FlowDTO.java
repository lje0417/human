package human.class1.ajax.FlowDTO;

import java.sql.Date;

public class FlowDTO {

	private String underprocess;
	private String process_code;
	private String processname2;
	private String image;
	private String productcontent;
	private int rnum;
	public String getUnderprocess() {
		return underprocess;
	}
	public void setUnderprocess(String underprocess) {
		this.underprocess = underprocess;
	}
	public String getProcess_code() {
		return process_code;
	}
	public void setProcess_code(String process_code) {
		this.process_code = process_code;
	}
	public String getProcessname2() {
		return processname2;
	}
	public void setProcessname2(String processname2) {
		this.processname2 = processname2;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getProductcontent() {
		return productcontent;
	}
	public void setProductcontent(String productcontent) {
		this.productcontent = productcontent;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	@Override
	public String toString() {
		return "FlowDTO [underprocess=" + underprocess + ", process_code=" + process_code + ", processname2="
				+ processname2 + ", image=" + image + ", productcontent=" + productcontent + ", rnum=" + rnum + "]";
	}
}
