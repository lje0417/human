package human.class1.ajax.stDAO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.stDTO.Stocking_ManagementDTO;

@Repository
public class Stocking_ManagementDAOImpl implements Stocking_ManagementDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List selectstPage(int start, int end, String search, String optionvalue) {
		Map searchMap = new HashMap();
		searchMap.put("start", start);
		searchMap.put("end", end);
		searchMap.put("search", search);
		searchMap.put("optionvalue", optionvalue);
		List list = sqlSession.selectList("mapper.st.selectstPage",searchMap);
		return list;
	}
	
	@Override
	public int totalstPage() {
		int result = -1;
		result = sqlSession.selectOne("mapper.st.totalstPage");
		return result;
	}
	
	@Override
	public int insertST(Stocking_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.insert("mapper.st.insertST",dto);
		return result;
	}
	@Override
	public long selectSequence() {
		long result = -1;
		result = sqlSession.selectOne("mapper.st.selectSequence");
		return result;
	}
	
	@Override
	public List selectPO_data() {
		List list = sqlSession.selectList("mapper.st.selectPO_data");
		return list;
	}
	
	@Override
	public int deleteST(String[] stocking_numbers) {
		int result = -1;
		List<String> stocking_numbersAslist = Arrays.asList(stocking_numbers);
		
		result = sqlSession.delete("mapper.st.deleteST",stocking_numbersAslist);
		return result;
	}
	
	@Override
	public int updateST(Stocking_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.update("mapper.st.modifyST",dto);
		return result;
	}
	@Override
	public Stocking_ManagementDTO selectOne(String stocking_number) {
		Stocking_ManagementDTO stDTO = null;
		stDTO = sqlSession.selectOne("mapper.st.selectST_data_one",stocking_number);
		return stDTO;
	}
	@Override
	public Stocking_ManagementDTO selectST_data_one(Stocking_ManagementDTO dto) {
		Stocking_ManagementDTO stDTO = null;
		stDTO = sqlSession.selectOne("mapper.st.select_complete_data",dto);
		return stDTO;
	}
	
	@Override
	public int updateST_status(Stocking_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.update("mapper.st.modifySP_status",dto);
		return result;
	}
	
}
