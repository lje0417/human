package human.class1.ajax.apDTO;

import java.sql.Date;

public class APDTO {

	private String specification_number;
	private String product_code;	
	private String product_name;
	private Date plan_start_date;
	private Date plan_end_date;
	private Date plan_reg_date;
	private Integer plan_amount;
	private String specification_status;
	private int rnum;
	
	public String getSpecification_number() {
		return specification_number;
	}
	public void setSpecification_number(String specification_number) {
		this.specification_number = specification_number;
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
	public Date getPlan_reg_date() {
		return plan_reg_date;
	}
	public void setPlan_reg_date(Date plan_reg_date) {
		this.plan_reg_date = plan_reg_date;
	}
	public Integer getPlan_amount() {
		return plan_amount;
	}
	public void setPlan_amount(Integer plan_amount) {
		this.plan_amount = plan_amount;
	}
	public String getSpecification_status() {
		return specification_status;
	}
	public void setSpecification_status(String specification_status) {
		this.specification_status = specification_status;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	@Override
	public String toString() {
		return "Specification_ManagementDTO [specification_number=" + specification_number + ", product_code="
				+ product_code + ", product_name=" + product_name + ", plan_start_date=" + plan_start_date
				+ ", plan_end_date=" + plan_end_date + ", plan_reg_date=" + plan_reg_date + ", plan_amount="
				+ plan_amount + ", specification_status=" + specification_status + ", rnum=" + rnum + "]";
	}
	
}
