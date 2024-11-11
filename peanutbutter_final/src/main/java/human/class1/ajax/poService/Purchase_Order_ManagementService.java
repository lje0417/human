package human.class1.ajax.poService;

import java.util.List;
import java.util.Map;

import human.class1.ajax.poDTO.Purchase_Order_ManagementDTO;
import human.class1.ajax.shDTO.Shipping_ManagementDTO;

public interface Purchase_Order_ManagementService {

	Map listpo(String countPerPage, String page, String search, String optionvalue);
	int joinpo(Purchase_Order_ManagementDTO dto);
	List getPT_data();
	int delete(String[] purchase_order_numbers);
	int modify_po(Purchase_Order_ManagementDTO dto);
	Purchase_Order_ManagementDTO get_select_data(String purchase_order_number);
}
