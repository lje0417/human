package human.class1.ajax.pmdto;

import java.sql.Date;

public class Product_Stock_ManagementDTO {

	private String product_code;
	private String product_name;
	private String product_image;
	private String unit;
	private String standard;
	private Integer lot_size;
	private String shipping_warehouse;
	private String barcode;
	private Integer stock_amount;
	private Date latest_stock_date;
	private String product_status;
	private int rnum;
	private int return_amount;

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

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public Integer getLot_size() {
		return lot_size;
	}

	public void setLot_size(Integer lot_size) {
		this.lot_size = lot_size;
	}

	public String getShipping_warehouse() {
		return shipping_warehouse;
	}

	public void setShipping_warehouse(String shipping_warehouse) {
		this.shipping_warehouse = shipping_warehouse;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public Integer getStock_amount() {
		return stock_amount;
	}

	public void setStock_amount(Integer stock_amount) {
		this.stock_amount = stock_amount;
	}

	public Date getLatest_stock_date() {
		return latest_stock_date;
	}

	public void setLatest_stock_date(Date latest_stock_date) {
		this.latest_stock_date = latest_stock_date;
	}

	public String getProduct_status() {
		return product_status;
	}

	public void setProduct_status(String product_status) {
		this.product_status = product_status;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getReturn_amount() {
		return return_amount;
	}

	public void setReturn_amount(int return_amount) {
		this.return_amount = return_amount;
	}

	@Override
	public String toString() {
		return "Product_Stock_ManagementDTO [product_code=" + product_code + ", product_name=" + product_name
				+ ", product_image=" + product_image + ", unit=" + unit + ", standard=" + standard + ", lot_size="
				+ lot_size + ", shipping_warehouse=" + shipping_warehouse + ", barcode=" + barcode + ", stock_amount="
				+ stock_amount + ", latest_stock_date=" + latest_stock_date + ", product_status=" + product_status
				+ ", rnum=" + rnum + ", return_amount=" + return_amount + "]";
	}
	
}
