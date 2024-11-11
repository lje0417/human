package human.class1.ajax.pmdao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import human.class1.ajax.pmdto.Product_ManagementDTO;

@Repository
public class Product_ManagementDAOImpl implements Product_ManagementDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List selectpmPage(int start, int end, String search, String optionvalue) {
		Map searchMap = new HashMap();
		searchMap.put("start", start);
		searchMap.put("end", end);
		searchMap.put("search", search);
		searchMap.put("optionvalue", optionvalue);
		List list = sqlSession.selectList("mapper.emp.selectpmPage",searchMap);
		return list;
	}
	
	@Override
	public int totalpmPage() {
		int result = -1;
		result = sqlSession.selectOne("mapper.emp.totalpmPage");
		return result;
	}
	
	@Override
	public int insertPM(Product_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.insert("mapper.emp.insertPM",dto);
		return result;
	}
	@Override
	public long selectSequence() {
		long result = -1;
		result = sqlSession.selectOne("mapper.emp.selectSequence");
		return result;
	}
	@Override
	public int deletePM(String[] product_codes) {
		int result = -1;
		List<String> product_codesAslist = Arrays.asList(product_codes);
		
		System.out.println("product_codes : "+ product_codesAslist);
		result = sqlSession.delete("mapper.emp.deletePM",product_codesAslist);
		return result;
	}
	@Override
	public int updatePM(Product_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.update("mapper.emp.modifyPM",dto);
		return result;
	}
	@Override
	public Product_ManagementDTO selectOne(String product_code) {
		Product_ManagementDTO pmDTO = null;
		pmDTO = sqlSession.selectOne("mapper.emp.selectOne",product_code);
		return pmDTO;
	}
	@Override
	public List selectpm_stockPage(int start, int end, String search, String optionvalue) {
		Map searchMap = new HashMap();
		searchMap.put("start", start);
		searchMap.put("end", end);
		searchMap.put("search", search);
		searchMap.put("optionvalue", optionvalue);
		List list = sqlSession.selectList("mapper.emp.selectpm_stockPage",searchMap);
		return list;
	}
}
