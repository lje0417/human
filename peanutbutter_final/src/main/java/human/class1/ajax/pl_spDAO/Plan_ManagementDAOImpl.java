package human.class1.ajax.pl_spDAO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import human.class1.ajax.pl_spDTO.Plan_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;


@Repository
public class Plan_ManagementDAOImpl implements Plan_ManagementDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List selectplPage(int start, int end, String search, String optionvalue) {
		Map searchMap = new HashMap();
		searchMap.put("start", start);
		searchMap.put("end", end);
		searchMap.put("search", search);
		searchMap.put("optionvalue", optionvalue);
		List list = sqlSession.selectList("mapper.pl_sp.selectplPage",searchMap);
		return list;
	}
	
	@Override
	public int totalplPage() {
		int result = -1;
		result = sqlSession.selectOne("mapper.pl_sp.totalplPage");
		return result;
	}
	
	@Override
	public int insertPL(Plan_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.insert("mapper.pl_sp.insertPL",dto);
		return result;
	}
	@Override
	public long selectSequence() {
		long result = -1;
		result = sqlSession.selectOne("mapper.pl_sp.selectSequence");
		return result;
	}
	@Override
	public List selectPM_data() {
		List list = sqlSession.selectList("mapper.pl_sp.selectPM_data");
		return list;
	}
	@Override
	public int deletePL(String[] plan_numbers) {
		int result = -1;
		List<String> plan_numbersAslist = Arrays.asList(plan_numbers);
		
		result = sqlSession.delete("mapper.pl_sp.deletePL",plan_numbersAslist);
		return result;
	}
	@Override
	public int updatePL(Plan_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.update("mapper.pl_sp.modifyPL",dto);
		return result;
	}
	@Override
	public Plan_ManagementDTO selectOne(String plan_number) {
		Plan_ManagementDTO plDTO = null;
		plDTO = sqlSession.selectOne("mapper.pl_sp.selectPL_data_one",plan_number);
		return plDTO;
	}
	@Override
	public Product_ManagementDTO selectPM_data_one(String product_code) {
		Product_ManagementDTO pmdto = sqlSession.selectOne("mapper.pl_sp.selectPM_data_one",product_code);
		return pmdto;
	}

}
