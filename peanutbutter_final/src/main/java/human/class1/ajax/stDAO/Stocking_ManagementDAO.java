package human.class1.ajax.stDAO;

import java.util.List;

import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;
import human.class1.ajax.poDTO.Purchase_Order_ManagementDTO;
import human.class1.ajax.shDTO.Shipping_ManagementDTO;
import human.class1.ajax.stDTO.Stocking_ManagementDTO;

public interface Stocking_ManagementDAO {

	List selectstPage(int start, int end, String search, String optionvalue);
	int totalstPage();
	int insertST(Stocking_ManagementDTO dto);
	long selectSequence();
	List selectPO_data();
	int deleteST(String[] stocking_numbers);
	int updateST(Stocking_ManagementDTO dto);
	Stocking_ManagementDTO selectOne(String stocking_number);
	Stocking_ManagementDTO selectST_data_one(Stocking_ManagementDTO dto);
	int updateST_status(Stocking_ManagementDTO dto);
}
