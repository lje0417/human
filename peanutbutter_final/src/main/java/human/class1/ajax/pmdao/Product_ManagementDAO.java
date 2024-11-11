package human.class1.ajax.pmdao;

import java.util.List;

import human.class1.ajax.pmdto.Product_ManagementDTO;

public interface Product_ManagementDAO {

	List selectpmPage(int start, int end, String search, String optionvalue);
	int totalpmPage();
	int insertPM(Product_ManagementDTO dto);
	long selectSequence();
	int deletePM(String[] product_codes);
	int updatePM(Product_ManagementDTO dto);
	Product_ManagementDTO selectOne(String product_code);
	List selectpm_stockPage(int start, int end, String search, String optionvalue);
}
