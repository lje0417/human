package human.class1.ajax.pl_spService;

import java.util.List;
import java.util.Map;

import human.class1.ajax.pl_spDTO.Plan_ManagementDTO;
import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;

public interface Plan_ManagementService {

	Map listpl(String countPerPage, String page, String search, String optionvalue);
	int joinPL(Plan_ManagementDTO dto);
	List getPM_data();
	int delete(String[] plan_numbers);
	int modify(Plan_ManagementDTO dto);
	Plan_ManagementDTO get(String plan_number);
	Product_ManagementDTO getPM_data_one(String product_code);
	Map listsp(String countPerPage, String page, String search, String optionvalue);
	int delete_sp(String[] specification_numbers);
	List listsp_detail(String plan_start_date);
	int modify_sp(Specification_ManagementDTO dto);
	Specification_ManagementDTO get_complete_data(Specification_ManagementDTO dto);
}
