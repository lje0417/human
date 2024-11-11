package human.class1.ajax.PTDAO;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import human.class1.ajax.PTDTO.Part_ManagementDTO;
import human.class1.ajax.stDTO.Stocking_ManagementDTO;

@Repository
public class Part_Stock_ManagementDAOImpl implements Part_Stock_ManagementDAO{
	
	@Autowired
	SqlSession sqlSession;
	
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
	
	@Override
	public int totalpt_stockPage() {
		int result = -1;
		result = sqlSession.selectOne("mapper.pt.totalpt_stockPage");
		return result;
	}
	
	@Override
	public int deletePT_Stock(String[] part_codes) {
		int result = -1;
		List<String> part_codesAslist = Arrays.asList(part_codes);
		
		System.out.println("part_codes : "+ part_codesAslist);
		result = sqlSession.delete("mapper.pt.deletePT_Stock",part_codesAslist);
		return result;
	}
	
	@Override
	public int insert_PT_stock(Part_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.insert("mapper.pt.insert_PT_stock",dto);
		return result;
	}
	
	@Override
	public int updatePT_stock(Stocking_ManagementDTO dto1) {
		int result = -1;
		System.out.println("dto1 :"+ dto1);
		result = sqlSession.update("mapper.pt.modifyPT_stock",dto1);
		return result;
	}
	
	
}
