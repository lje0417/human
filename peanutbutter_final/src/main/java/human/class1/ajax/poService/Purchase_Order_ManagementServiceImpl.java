package human.class1.ajax.poService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import human.class1.ajax.poDAO.Purchase_Order_ManagementDAO;
import human.class1.ajax.poDTO.Purchase_Order_ManagementDTO;

@Service
public class Purchase_Order_ManagementServiceImpl implements Purchase_Order_ManagementService{

	@Autowired
	Purchase_Order_ManagementDAO poDAO;
	
	@Override
	// 출고관리 페이지의 검색 및 필터링, 페이지네이션
	public Map listpo(String countPerPage, String page, String search, String optionvalue) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo-1)* count) + 1;
		int end = pageNo * count;
		
		List list = poDAO.selectpoPage(start, end, search, optionvalue);
		
		int totalCount = poDAO.totalpoPage();
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
	@Override
	// 출고관리 페이지의 등록 정보 DB에 저장 
	public int joinpo(Purchase_Order_ManagementDTO dto) {
		
		long sequence = poDAO.selectSequence();
		
		System.out.println("sequence "+ sequence);
		
		String sequenceString = Long.toString(sequence);
		
		dto.setPurchase_order_number(sequenceString);
		
		System.out.println("dto: "+dto);
		
		int result = poDAO.insertPO(dto);
		
		return result;
	}
	
	@Override
	public List getPT_data() {
		
		List result = poDAO.selectPT_data();
		return result;
	}
	
	@Override
	// 출고관리 페이지의 DB에서 삭제 (purchase_order_numbers로)  
	public int delete(String[] purchase_order_numbers) {
		
		int result = poDAO.deletePO(purchase_order_numbers);
		
		return result;
	}
	
	@Override
	// 출고관리 페이지의 기존 정보 수정 
	public int modify_po(Purchase_Order_ManagementDTO dto) {
		
		int result = poDAO.updatePO(dto);
		
		return result;
	}
	@Override
	// 제품관리 페이지에서 plan_number 하나로 셀렉트
	public Purchase_Order_ManagementDTO get_select_data(String purchase_order_number) {
		
		Purchase_Order_ManagementDTO dto = new Purchase_Order_ManagementDTO();
		
		dto = poDAO.selectOne(purchase_order_number);
		
		return dto;
	}
	
}

