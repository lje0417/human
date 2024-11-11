package human.class1.ajax.PTDAO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import human.class1.ajax.PTDTO.Part_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;

@Repository
public class Part_ManagementDAOImpl implements Part_ManagementDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List selectptPage(int start, int end, String search, String optionvalue) {
		Map searchMap = new HashMap();
		searchMap.put("start", start);
		searchMap.put("end", end);
		searchMap.put("search", search);
		searchMap.put("optionvalue", optionvalue);
		List list = sqlSession.selectList("mapper.pt.selectptPage",searchMap);
		return list;
	}
	
	@Override
	public int totalptPage() {
		int result = -1;
		result = sqlSession.selectOne("mapper.pt.totalptPage");
		return result;
	}
	
	@Override
	public int insertPT(Part_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.insert("mapper.pt.insertPT",dto);
		return result;
	}
	@Override
	public long selectSequence() {
		long result = -1;
		result = sqlSession.selectOne("mapper.pt.selectSequence");
		return result;
	}
	@Override
	public int deletePT(String[] part_codes) {
		int result = -1;
		List<String> part_codesAslist = Arrays.asList(part_codes);
		
		System.out.println("product_codes : "+ part_codesAslist);
		result = sqlSession.delete("mapper.pt.deletePT",part_codesAslist);
		return result;
	}
	@Override
	public int updatePT(Part_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.update("mapper.pt.modifyPT",dto);
		return result;
	}
	@Override
	public Part_ManagementDTO selectOne(String part_code) {
		Part_ManagementDTO ptDTO = null;
		ptDTO = sqlSession.selectOne("mapper.pt.selectOne",part_code);
		return ptDTO;
	}
	@Override
	public List selectpt_stockPage(int start, int end, String search, String optionvalue) {
		Map searchMap = new HashMap();
		searchMap.put("start", start);
		searchMap.put("end", end);
		searchMap.put("search", search);
		searchMap.put("optionvalue", optionvalue);
		List list = sqlSession.selectList("mapper.pt.selectpt_stockPage",searchMap);
		return list;
	}
}
