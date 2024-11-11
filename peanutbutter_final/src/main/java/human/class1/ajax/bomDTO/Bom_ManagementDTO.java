package human.class1.ajax.bomDTO;

public class Bom_ManagementDTO {

	private String bom_number;
	private String product_code; 
	private String product_name; 
	private String part_code; 
	private String part_name; 
	private String part_modelname; 
	private String part_standard; 
	private String part_unit; 
	private String part_amount_str;
	private Integer part_amount; 
	private String part_vendors;
	private int rnum;
	public String getBom_number() {
		return bom_number;
	}
	public void setBom_number(String bom_number) {
		this.bom_number = bom_number;
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
	public String getPart_code() {
		return part_code;
	}
	public void setPart_code(String part_code) {
		this.part_code = part_code;
	}
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	public String getPart_modelname() {
		return part_modelname;
	}
	public void setPart_modelname(String part_modelname) {
		this.part_modelname = part_modelname;
	}
	public String getPart_standard() {
		return part_standard;
	}
	public void setPart_standard(String part_standard) {
		this.part_standard = part_standard;
	}
	public String getPart_unit() {
		return part_unit;
	}
	public void setPart_unit(String part_unit) {
		this.part_unit = part_unit;
	}
	public String getPart_amount_str() {
		return part_amount_str;
	}
	public void setPart_amount_str(String part_amount_str) {
		this.part_amount_str = part_amount_str;
	}
	public Integer getPart_amount() {
		return part_amount;
	}
	public void setPart_amount(Integer part_amount) {
		this.part_amount = part_amount;
	}
	public String getPart_vendors() {
		return part_vendors;
	}
	public void setPart_vendors(String part_vendors) {
		this.part_vendors = part_vendors;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	@Override
	public String toString() {
		return "Bom_ManagementDTO [bom_number=" + bom_number + ", product_code=" + product_code + ", product_name="
				+ product_name + ", part_code=" + part_code + ", part_name=" + part_name + ", part_modelname="
				+ part_modelname + ", part_standard=" + part_standard + ", part_unit=" + part_unit
				+ ", part_amount_str=" + part_amount_str + ", part_amount=" + part_amount + ", part_vendors="
				+ part_vendors + ", rnum=" + rnum + "]";
	}
		
}
