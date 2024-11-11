package human.class1.ajax.stDTO;

import java.sql.Date;

public class Stocking_ManagementDTO {

	private String stocking_number;
	private Date stocking_date;
	private String stocking_partner;
	private String stocking_currency;
	private Integer stocking_amount;
	private String stocking_warehouse;
	private String stocking_status;
	private String part_code;
	private String part_modelname;
	private int rnum;
	public String getStocking_number() {
		return stocking_number;
	}
	public void setStocking_number(String stocking_number) {
		this.stocking_number = stocking_number;
	}
	public Date getStocking_date() {
		return stocking_date;
	}
	public void setStocking_date(Date stocking_date) {
		this.stocking_date = stocking_date;
	}
	public String getStocking_partner() {
		return stocking_partner;
	}
	public void setStocking_partner(String stocking_partner) {
		this.stocking_partner = stocking_partner;
	}
	public String getStocking_currency() {
		return stocking_currency;
	}
	public void setStocking_currency(String stocking_currency) {
		this.stocking_currency = stocking_currency;
	}
	public Integer getStocking_amount() {
		return stocking_amount;
	}
	public void setStocking_amount(Integer stocking_amount) {
		this.stocking_amount = stocking_amount;
	}
	public String getStocking_warehouse() {
		return stocking_warehouse;
	}
	public void setStocking_warehouse(String stocking_warehouse) {
		this.stocking_warehouse = stocking_warehouse;
	}
	public String getStocking_status() {
		return stocking_status;
	}
	public void setStocking_status(String stocking_status) {
		this.stocking_status = stocking_status;
	}
	public String getPart_code() {
		return part_code;
	}
	public void setPart_code(String part_code) {
		this.part_code = part_code;
	}
	public String getPart_modelname() {
		return part_modelname;
	}
	public void setPart_modelname(String part_modelname) {
		this.part_modelname = part_modelname;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	@Override
	public String toString() {
		return "Stocking_Management_DTO [stocking_number=" + stocking_number + ", stocking_date=" + stocking_date
				+ ", stocking_partner=" + stocking_partner + ", stocking_currency=" + stocking_currency
				+ ", stocking_amount=" + stocking_amount + ", stocking_warehouse=" + stocking_warehouse
				+ ", stocking_status=" + stocking_status + ", part_code=" + part_code + ", part_modelname="
				+ part_modelname + ", rnum=" + rnum + "]";
	}
	
}
