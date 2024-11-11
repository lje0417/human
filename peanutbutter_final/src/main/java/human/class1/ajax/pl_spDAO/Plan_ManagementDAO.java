package human.class1.ajax.pl_spDAO;

import java.util.List;

import human.class1.ajax.pl_spDTO.Plan_ManagementDTO;
import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;


public interface Plan_ManagementDAO {

	List selectplPage(int start, int end, String search, String optionvalue);
	int totalplPage();
	int insertPL(Plan_ManagementDTO dto);
	long selectSequence();
	List selectPM_data();
	int deletePL(String[] plan_numbers);
	int updatePL(Plan_ManagementDTO dto);
	Plan_ManagementDTO selectOne(String product_code);
	Product_ManagementDTO selectPM_data_one(String product_code);
}
