package human.class1.ajax.PTDAO;

import java.util.List;

import human.class1.ajax.PTDTO.Part_ManagementDTO;
import human.class1.ajax.stDTO.Stocking_ManagementDTO;

public interface Part_Stock_ManagementDAO {

	List selectpt_stockPage(int start, int end, String search, String optionvalue);
	int totalpt_stockPage();
	int deletePT_Stock(String[] part_codes);
	int insert_PT_stock(Part_ManagementDTO dto);
	int updatePT_stock(Stocking_ManagementDTO dto1);
}
