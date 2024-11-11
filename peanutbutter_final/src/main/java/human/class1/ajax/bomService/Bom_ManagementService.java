package human.class1.ajax.bomService;

import java.util.List;
import java.util.Map;

import human.class1.ajax.bomDTO.Bom_ManagementDTO;
import human.class1.ajax.pl_spDTO.Plan_ManagementDTO;
import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;

public interface Bom_ManagementService {
	
	 Map listbom(String countPerPage, String page, String search, String optionvalue);
	 List getPM_data();
	 List getPT_data();
	 int joinBOM(Bom_ManagementDTO dto);
}
