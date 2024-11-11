package human.class1.ajax.pl_spDAO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import human.class1.ajax.pl_spDTO.Plan_ManagementDTO;
import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;


@Repository
public class Specification_ManagementDAOImpl implements Specification_ManagementDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List selectspPage(int start, int end, String search, String optionvalue) {
		Map searchMap = new HashMap();
		searchMap.put("start", start);
		searchMap.put("end", end);
		searchMap.put("search", search);
		searchMap.put("optionvalue", optionvalue);
		List list = sqlSession.selectList("mapper.pl_sp.selectspPage",searchMap);
		return list;
	}
	
	@Override
	public int totalspPage() {
		int result = -1;
		result = sqlSession.selectOne("mapper.pl_sp.totalspPage");
		return result;
	}
	
	@Override
	public int insertSP(Specification_ManagementDTO spDTO) {
		int result = -1;
		result = sqlSession.insert("mapper.pl_sp.insertSP",spDTO);
		return result;
	}
	@Override
	public long selectSequence_sp() {
		long result = -1;
		result = sqlSession.selectOne("mapper.pl_sp.selectSequence_sp");
		return result;
	}
	
	@Override
	public int deleteSP(String[] specification_numbers) {
		int result = -1;
		List<String> sp_numbersAslist = Arrays.asList(specification_numbers);
		
		result = sqlSession.delete("mapper.pl_sp.deleteSP",sp_numbersAslist);
		return result;
	}
	
	@Override
	public List selectsp_detail(String plan_start_date) {
		List list = sqlSession.selectList("mapper.pl_sp.selectsp_datail_Page",plan_start_date);
		return list;
	}
	
	@Override
	public int updateSP(Specification_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.update("mapper.pl_sp.modifySP",dto);
		return result;
	}
	
	@Override
	public Specification_ManagementDTO selectSP_data_one(Specification_ManagementDTO dto) {
		Specification_ManagementDTO spDTO = null;
		spDTO = sqlSession.selectOne("mapper.pl_sp.selectSP_data_one",dto);
		return spDTO;
	}
		
}