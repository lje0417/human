package human.class1.ajax.pmdao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;
import human.class1.ajax.shDTO.Shipping_ManagementDTO;

@Repository
public class Product_Stock_ManagementDAOImpl implements Product_Stock_ManagementDAO{
	
	@Autowired
	SqlSession sqlSession;
	
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
	
	@Override
	public int totalpm_stockPage() {
		int result = -1;
		result = sqlSession.selectOne("mapper.emp.totalpm_stockPage");
		return result;
	}
	
	@Override
	public int deletePM_Stock(String[] product_codes) {
		int result = -1;
		List<String> product_codesAslist = Arrays.asList(product_codes);
		
		System.out.println("product_codes : "+ product_codesAslist);
		result = sqlSession.delete("mapper.emp.deletePM_Stock",product_codesAslist);
		return result;
	}
	
	@Override
	public int insert_PM_stock(Product_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.insert("mapper.emp.insert_PM_stock",dto);
		return result;
	}
	
	@Override
	public int updatePM_stock(Specification_ManagementDTO dto1) {
		int result = -1;
		result = sqlSession.update("mapper.emp.modifyPM_stock",dto1);
		return result;
	}
	
	@Override
	public int updatePM_status_stock(Shipping_ManagementDTO dto1) {
		int result = -1;
		result = sqlSession.update("mapper.emp.modifyPM_status_stock",dto1);
		return result;
	}
	
	
}
