package human.class1.ajax.poDAO;

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
import human.class1.ajax.poDTO.Purchase_Order_ManagementDTO;
import human.class1.ajax.shDTO.Shipping_ManagementDTO;

@Repository
public class Purchase_Order_ManagementDAOImpl implements Purchase_Order_ManagementDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List selectpoPage(int start, int end, String search, String optionvalue) {
		Map searchMap = new HashMap();
		searchMap.put("start", start);
		searchMap.put("end", end);
		searchMap.put("search", search);
		searchMap.put("optionvalue", optionvalue);
		List list = sqlSession.selectList("mapper.po.selectpoPage",searchMap);
		return list;
	}
	
	@Override
	public int totalpoPage() {
		int result = -1;
		result = sqlSession.selectOne("mapper.po.totalpoPage");
		return result;
	}
	
	@Override
	public int insertPO(Purchase_Order_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.insert("mapper.po.insertPO",dto);
		return result;
	}
	@Override
	public long selectSequence() {
		long result = -1;
		result = sqlSession.selectOne("mapper.po.selectSequence");
		return result;
	}
	
	@Override
	public List selectPT_data() {
		List list = sqlSession.selectList("mapper.po.selectPT_data");
		return list;
	}
	
	@Override
	public int deletePO(String[] purchase_order_numbers) {
		int result = -1;
		List<String> purchase_order_numbersAslist = Arrays.asList(purchase_order_numbers);
		
		result = sqlSession.delete("mapper.po.deletePO",purchase_order_numbersAslist);
		return result;
	}
	@Override
	public int updatePO(Purchase_Order_ManagementDTO dto) {
		int result = -1;
		result = sqlSession.update("mapper.po.modifyPO",dto);
		return result;
	}
	@Override
	public Purchase_Order_ManagementDTO selectOne(String purchase_order_number) {
		Purchase_Order_ManagementDTO poDTO = null;
		poDTO = sqlSession.selectOne("mapper.po.selectPO_data_one",purchase_order_number);
		return poDTO;
	}
	
}
