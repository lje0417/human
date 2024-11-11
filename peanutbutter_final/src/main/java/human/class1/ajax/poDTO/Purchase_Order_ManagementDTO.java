package human.class1.ajax.poDTO;

import java.sql.Date;

public class Purchase_Order_ManagementDTO {

	private String purchase_order_number;
	private Date purchase_order_date;
	private Date warehousing_duedate;
	private String purchase_order_partner;
	private String purchase_order_currency;
	private Integer purchase_order_amount;
	private String purchase_order_warehouse;
	private String part_code;
	private String part_modelname;
	private int rnum;
	public String getPurchase_order_number() {
		return purchase_order_number;
	}
	public void setPurchase_order_number(String purchase_order_number) {
		this.purchase_order_number = purchase_order_number;
	}
	public Date getPurchase_order_date() {
		return purchase_order_date;
	}
	public void setPurchase_order_date(Date purchase_order_date) {
		this.purchase_order_date = purchase_order_date;
	}
	public Date getWarehousing_duedate() {
		return warehousing_duedate;
	}
	public void setWarehousing_duedate(Date warehousing_duedate) {
		this.warehousing_duedate = warehousing_duedate;
	}
	public String getPurchase_order_partner() {
		return purchase_order_partner;
	}
	public void setPurchase_order_partner(String purchase_order_partner) {
		this.purchase_order_partner = purchase_order_partner;
	}
	public String getPurchase_order_currency() {
		return purchase_order_currency;
	}
	public void setPurchase_order_currency(String purchase_order_currency) {
		this.purchase_order_currency = purchase_order_currency;
	}
	public Integer getPurchase_order_amount() {
		return purchase_order_amount;
	}
	public void setPurchase_order_amount(Integer purchase_order_amount) {
		this.purchase_order_amount = purchase_order_amount;
	}
	public String getPurchase_order_warehouse() {
		return purchase_order_warehouse;
	}
	public void setPurchase_order_warehouse(String purchase_order_warehouse) {
		this.purchase_order_warehouse = purchase_order_warehouse;
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
		return "Purchase_Order_ManagementDTO [purchase_order_number=" + purchase_order_number + ", purchase_order_date="
				+ purchase_order_date + ", warehousing_duedate=" + warehousing_duedate + ", purchase_order_partner="
				+ purchase_order_partner + ", purchase_order_currency=" + purchase_order_currency
				+ ", purchase_order_amount=" + purchase_order_amount + ", purchase_order_warehouse="
				+ purchase_order_warehouse + ", part_code=" + part_code + ", part_modelname=" + part_modelname
				+ ", rnum=" + rnum + "]";
	}
	
}
