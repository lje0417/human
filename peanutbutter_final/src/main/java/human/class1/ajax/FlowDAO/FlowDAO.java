package human.class1.ajax.FlowDAO;

import java.util.List;

import human.class1.ajax.pl_spDTO.Plan_ManagementDTO;
import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;


public interface FlowDAO {

	List selectflPage(int start, int end, String process_code);
	int totalflPage();
}
