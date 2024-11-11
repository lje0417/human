package human.class1.ajax.PTservice;

import java.util.List;
import java.util.Map;

import human.class1.ajax.PTDTO.Part_ManagementDTO;
import human.class1.ajax.stDTO.Stocking_ManagementDTO;

public interface Part_ManagementService {

	Map listpt(String countPerPage, String page, String search, String optionvalue);
	int joinPT(Part_ManagementDTO dto);
	int delete(String[] part_codes);
	int modify_pt(Part_ManagementDTO dto);
	Part_ManagementDTO get_pt(String part_code);
	Map listpt_stock(String countPerPage, String page, String search, String optionvalue);
	int delete_ptstock(String[] part_codes);
	int modify_ptstock(Stocking_ManagementDTO dto1);
}
