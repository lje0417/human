package human.class1.ajax.shService;

import java.util.List;
import java.util.Map;

import human.class1.ajax.shDTO.Shipping_ManagementDTO;

public interface Shipping_ManagementService {

	Map listsh(String countPerPage, String page, String search, String optionvalue);
	int joinsh(Shipping_ManagementDTO dto);
	int delete(String[] shipping_numbers);
	int modify_sh(Shipping_ManagementDTO dto);
	Shipping_ManagementDTO get_select_data(String shipping_number);
	int modify_sh_status(Shipping_ManagementDTO dto);
	Shipping_ManagementDTO get_complete_data(Shipping_ManagementDTO dto);
	
}
