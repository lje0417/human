package human.class1.ajax.pmservice;

import java.util.List;
import java.util.Map;

import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;
import human.class1.ajax.shDTO.Shipping_ManagementDTO;

public interface Product_ManagementService {

	Map listpm(String countPerPage, String page, String search, String optionvalue);
	int joinPM(Product_ManagementDTO dto);
	int delete(String[] product_codes);
	int modify(Product_ManagementDTO dto);
	Product_ManagementDTO get(String product_code);
	Map listpm_stock(String countPerPage, String page, String search, String optionvalue);
	int delete_pmstock(String[] product_codes);
	int modify_pmstock(Specification_ManagementDTO dto1);
	int modify_status_pmstock(Shipping_ManagementDTO dto1);
}
