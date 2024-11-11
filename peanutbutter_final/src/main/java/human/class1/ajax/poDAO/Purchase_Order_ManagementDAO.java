package human.class1.ajax.poDAO;

import java.util.List;

import human.class1.ajax.pmdto.Product_ManagementDTO;
import human.class1.ajax.poDTO.Purchase_Order_ManagementDTO;
import human.class1.ajax.shDTO.Shipping_ManagementDTO;

public interface Purchase_Order_ManagementDAO {

	List selectpoPage(int start, int end, String search, String optionvalue);
	int totalpoPage();
	int insertPO(Purchase_Order_ManagementDTO dto);
	long selectSequence();
	List selectPT_data();
	int deletePO(String[] purchase_order_numbers);
	int updatePO(Purchase_Order_ManagementDTO dto);
	Purchase_Order_ManagementDTO selectOne(String purchase_order_number);
}
