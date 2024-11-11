package human.class1.ajax.stService;

import java.util.List;
import java.util.Map;

import human.class1.ajax.poDTO.Purchase_Order_ManagementDTO;
import human.class1.ajax.shDTO.Shipping_ManagementDTO;
import human.class1.ajax.stDTO.Stocking_ManagementDTO;

public interface Stocking_ManagementService {

	Map listst(String countPerPage, String page, String search, String optionvalue);
	int joinst(Stocking_ManagementDTO dto);
	List getPO_data();
	int delete(String[] stocking_numbers);
	int modify_st(Stocking_ManagementDTO dto);
	Stocking_ManagementDTO get_select_data(String stocking_number);
	Stocking_ManagementDTO get_complete_data(Stocking_ManagementDTO dto);
	int modify_st_status(Stocking_ManagementDTO dto);
}
