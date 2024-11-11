package human.class1.ajax.shDAO;

import java.util.List;

import human.class1.ajax.pmdto.Product_ManagementDTO;
import human.class1.ajax.shDTO.Shipping_ManagementDTO;

public interface Shipping_ManagementDAO {

	List selectshPage(int start, int end, String search, String optionvalue);
	int totalshPage();
	int insertSH(Shipping_ManagementDTO dto);
	long selectSequence();
	int deleteSH(String[] shipping_numbers);
	int updateSH(Shipping_ManagementDTO dto);
	Shipping_ManagementDTO selectOne(String shipping_number);
	int updateSH_status(Shipping_ManagementDTO dto);
	Shipping_ManagementDTO selectSH_data_one(Shipping_ManagementDTO dto);
	
}
