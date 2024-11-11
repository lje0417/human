package human.class1.ajax.pl_spDAO;

import java.util.List;

import human.class1.ajax.pl_spDTO.Plan_ManagementDTO;
import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;


public interface Specification_ManagementDAO {

List selectspPage(int start, int end, String search, String optionvalue);
int totalspPage();
int insertSP(Specification_ManagementDTO spDTO);
long selectSequence_sp();
int deleteSP(String[] specification_numbers);
List selectsp_detail(String plan_start_date);
int updateSP(Specification_ManagementDTO dto);
Specification_ManagementDTO selectSP_data_one(Specification_ManagementDTO dto);
}
