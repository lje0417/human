package human.class1.ajax.shDAO;

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
import human.class1.ajax.shDTO.Shipping_ManagementDTO;
import human.class1.ajax.stDTO.Stocking_ManagementDTO;

@Repository
public class Shipping_ManagementDAOImpl implements Shipping_ManagementDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List selectshPage(int start, int end, String search, String optionvalue) {
		Map searchMap = new HashMap();
		searchMap.put("start", start);
		searchMap.put("end", end);
		searchMap.put("search", search);
		searchMap.put("optionvalue", optionvalue);
		List list = sqlSession.selectList("mapper.sh.selectshPage",searchMap);
		return list;
	}
	
	@Override
	public int totalshPage() {
		int result = -1;
		result = sqlSession.selectOne("mapper.sh.totalshPage");
		return result;
	}
	
	@Override
	public int insertSH(Shipping_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.insert("mapper.sh.insertSH",dto);
		return result;
	}
	@Override
	public long selectSequence() {
		long result = -1;
		result = sqlSession.selectOne("mapper.sh.selectSequence");
		return result;
	}
	
	@Override
	public int deleteSH(String[] shipping_numbers) {
		int result = -1;
		List<String> plan_numbersAslist = Arrays.asList(shipping_numbers);
		
		result = sqlSession.delete("mapper.sh.deleteSH",plan_numbersAslist);
		return result;
	}
	@Override
	public int updateSH(Shipping_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.update("mapper.sh.modifySH",dto);
		return result;
	}
	@Override
	public Shipping_ManagementDTO selectOne(String shipping_number) {
		Shipping_ManagementDTO shDTO = null;
		shDTO = sqlSession.selectOne("mapper.sh.selectSH_data_one",shipping_number);
		return shDTO;
	}
	
	@Override
	public Shipping_ManagementDTO selectSH_data_one(Shipping_ManagementDTO dto) {
		Shipping_ManagementDTO shDTO = null;
		shDTO = sqlSession.selectOne("mapper.sh.select_complete_data",dto);
		return shDTO;
	}
	
	@Override
	public int updateSH_status(Shipping_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.update("mapper.sh.modifySH_status",dto);
		return result;
	}
	
}
