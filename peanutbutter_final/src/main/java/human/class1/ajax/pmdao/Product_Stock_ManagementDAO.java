package human.class1.ajax.pmdao;

import java.util.List;

import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;
import human.class1.ajax.shDTO.Shipping_ManagementDTO;

public interface Product_Stock_ManagementDAO {

	List selectpm_stockPage(int start, int end, String search, String optionvalue);
	int totalpm_stockPage();
	int deletePM_Stock(String[] product_codes);
	int insert_PM_stock(Product_ManagementDTO dto);
	int updatePM_stock(Specification_ManagementDTO dto1);
	int updatePM_status_stock(Shipping_ManagementDTO dto1);
}
