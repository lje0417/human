package human.class1.ajax.PTDAO;

import java.util.List;

import human.class1.ajax.PTDTO.Part_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;

public interface Part_ManagementDAO {

	List selectptPage(int start, int end, String search, String optionvalue);
	int totalptPage();
	int insertPT(Part_ManagementDTO dto);
	long selectSequence();
	int deletePT(String[] part_codes);
	int updatePT(Part_ManagementDTO dto);
	Part_ManagementDTO selectOne(String part_code);
	List selectpt_stockPage(int start, int end, String search, String optionvalue);
}
