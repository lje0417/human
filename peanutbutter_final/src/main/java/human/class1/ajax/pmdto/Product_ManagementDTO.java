package human.class1.ajax.pmdto;

public class Product_ManagementDTO {

	private String product_code;
	private String product_name;
	private String product_image;
	private String unit;
	private String standard;
	private Integer lead_time;
	private String barcode;
	private Integer lot_size;
	private String shipping_warehouse;
	
	private int rnum;
	
	public int getRnum() {
		return rnum;
	}
	
	public void setRnum(int rnum) {
		this.rnum = rnum;
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
	public Integer getLead_time() {
		return lead_time;
	}
	public void setLead_time(Integer lead_time) {
		this.lead_time = lead_time;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
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
	@Override
	public String toString() {
		return "Product_ManagementDTO [product_code=" + product_code + ", product_name=" + product_name
				+ ", product_image=" + product_image + ", unit=" + unit + ", standard=" + standard + ", lead_time="
				+ lead_time + ", barcode=" + barcode + ", lot_size=" + lot_size + ", shipping_warehouse="
				+ shipping_warehouse + "]";
	}
	
	

}
