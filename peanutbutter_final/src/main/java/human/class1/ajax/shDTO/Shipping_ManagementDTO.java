package human.class1.ajax.shDTO;

import java.sql.Date;

public class Shipping_ManagementDTO {

	private String shipping_number;
	private Date shipping_date;
	private String shipping_arrival;
	private String shipping_currency;
	private Integer shipping_amount;
	private String shipping_warehouse;
	private String shipping_status;
	private String product_code;
	private String product_name;
	private int rnum;
	
	public String getShipping_status() {
		return shipping_status;
	}
	public void setShipping_status(String shipping_status) {
		this.shipping_status = shipping_status;
	}
	public String getShipping_number() {
		return shipping_number;
	}
	public void setShipping_number(String shipping_number) {
		this.shipping_number = shipping_number;
	}
	public Date getShipping_date() {
		return shipping_date;
	}
	public void setShipping_date(Date shipping_date) {
		this.shipping_date = shipping_date;
	}
	public String getShipping_arrival() {
		return shipping_arrival;
	}
	public void setShipping_arrival(String shipping_arrival) {
		this.shipping_arrival = shipping_arrival;
	}
	public String getShipping_currency() {
		return shipping_currency;
	}
	public void setShipping_currency(String shipping_currency) {
		this.shipping_currency = shipping_currency;
	}
	public Integer getShipping_amount() {
		return shipping_amount;
	}
	public void setShipping_amount(Integer shipping_amount) {
		this.shipping_amount = shipping_amount;
	}
	public String getShipping_warehouse() {
		return shipping_warehouse;
	}
	public void setShipping_warehouse(String shipping_warehouse) {
		this.shipping_warehouse = shipping_warehouse;
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
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	@Override
	public String toString() {
		return "Shipping_ManagementDTO [shipping_number=" + shipping_number + ", shipping_date=" + shipping_date
				+ ", shipping_arrival=" + shipping_arrival + ", shipping_currency=" + shipping_currency
				+ ", shipping_amount=" + shipping_amount + ", shipping_warehouse=" + shipping_warehouse
				+ ", shipping_status=" + shipping_status + ", product_code=" + product_code + ", product_name="
				+ product_name + ", rnum=" + rnum + "]";
	}
	
}
