package human.class1.ajax.bomDAO;

import java.util.List;

import human.class1.ajax.bomDTO.Bom_ManagementDTO;
import human.class1.ajax.pl_spDTO.Plan_ManagementDTO;
import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;


public interface Bom_ManagementDAO {

	List selectbomPage(int start, int end, String search, String optionvalue);
	int totalbomPage();
	List selectPM_data();
	List selectPT_data();
	int insertBOM(Bom_ManagementDTO dto);
	long selectSequence();
}
