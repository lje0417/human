package human.class1.ajax.pl_spDTO;

import java.sql.Date;

public class Plan_ManagementDTO {

	private String plan_number;
	private String product_code;
	private String product_name;
	private Date plan_start_date;
	private Date plan_end_date;
	private Integer plan_amount;
	private String plan_remarks;
	private int rnum;
	
	
	public String getPlan_number() {
		return plan_number;
	}
	public void setPlan_number(String plan_number) {
		this.plan_number = plan_number;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Date getPlan_start_date() {
		return plan_start_date;
	}
	public void setPlan_start_date(Date plan_start_date) {
		this.plan_start_date = plan_start_date;
	}
	public Date getPlan_end_date() {
		return plan_end_date;
	}
	public void setPlan_end_date(Date plan_end_date) {
		this.plan_end_date = plan_end_date;
	}
	public Integer getPlan_amount() {
		return plan_amount;
	}
	public void setPlan_amount(Integer plan_amount) {
		this.plan_amount = plan_amount;
	}
	public String getPlan_remarks() {
		return plan_remarks;
	}
	public void setPlan_remarks(String plan_remarks) {
		this.plan_remarks = plan_remarks;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
	@Override
	public String toString() {
		return "Plan_ManagementDTO [plan_number=" + plan_number + ", product_code=" + product_code + ", product_name="
				+ product_name + ", plan_start_date=" + plan_start_date + ", plan_end_date=" + plan_end_date
				+ ", plan_amount=" + plan_amount + ", plan_remarks=" + plan_remarks + ", rnum=" + rnum + "]";
	}
	
}
