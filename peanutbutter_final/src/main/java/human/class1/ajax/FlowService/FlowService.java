package human.class1.ajax.FlowService;

import java.util.List;
import java.util.Map;

import human.class1.ajax.pl_spDTO.Plan_ManagementDTO;
import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;

public interface FlowService {

	Map listfl(String countPerPage, String page, String process_code);
}
