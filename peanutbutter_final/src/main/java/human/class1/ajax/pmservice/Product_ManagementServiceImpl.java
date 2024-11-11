package human.class1.ajax.pmservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.pmdao.Product_ManagementDAO;
import human.class1.ajax.pmdao.Product_Stock_ManagementDAO;
import human.class1.ajax.pmdto.Product_ManagementDTO;
import human.class1.ajax.shDTO.Shipping_ManagementDTO;

@Service
public class Product_ManagementServiceImpl implements Product_ManagementService{

	@Autowired
	Product_ManagementDAO pmDAO;
	
	@Autowired
	Product_Stock_ManagementDAO pm_stockDAO;
	
	@Override
	// 제품관리 페이지의 제품 검색 및 필터링, 페이지네이션
	public Map listpm(String countPerPage, String page, String search, String optionvalue) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo-1)* count) + 1;
		int end = pageNo * count;
		
		List list = pmDAO.selectpmPage(start, end, search, optionvalue);
		
		int totalCount = pmDAO.totalpmPage();
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
	@Override
	// 제품관리 페이지의 등록 정보 DB에 저장 
	public int joinPM(Product_ManagementDTO dto) {
		
		long sequence = pmDAO.selectSequence();
		
		System.out.println("sequence "+ sequence);
		
		String sequenceString = Long.toString(sequence);
		
		dto.setProduct_code(sequenceString);
		
		System.out.println("dto: "+dto);
		
		int result = pmDAO.insertPM(dto);
		int insertCount_stock = pm_stockDAO.insert_PM_stock(dto);
		
		return result;
	}
	@Override
	// 제품관리 페이지의 DB에서 삭제 (product_code로)  
	public int delete(String[] product_codes) {
		
		int result = pmDAO.deletePM(product_codes);
		
		return result;
	}
	@Override
	// 제품관리 페이지의 기존 정보 수정 
	public int modify(Product_ManagementDTO dto) {
		
		int result = pmDAO.updatePM(dto);
		
		return result;
	}
	@Override
	// 제품관리 페이지에서 product_code 하나로 셀렉트
	public Product_ManagementDTO get(String product_code) {
		
		Product_ManagementDTO dto = new Product_ManagementDTO();
		
		dto = pmDAO.selectOne(product_code);
		
		return dto;
	}
	
	@Override
	// 제품재고 관리 페이지의 제품 검색 및 필터링, 페이지네이션 
	public Map listpm_stock(String countPerPage, String page, String search, String optionvalue) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo-1)* count) + 1;
		int end = pageNo * count;
		
		List list = pm_stockDAO.selectpm_stockPage(start, end, search, optionvalue);
		
		System.out.println("list "+ list);
		int totalCount = pm_stockDAO.totalpm_stockPage();
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
	@Override
	// 제품재고관리 페이지의 DB에서 삭제 (product_code로)  
	public int delete_pmstock(String[] product_codes) {
		
		int result = pm_stockDAO.deletePM_Stock(product_codes);
		
		return result;
	}
	
	@Override
	// 제품재고 페이지의 수정 
	public int modify_pmstock(Specification_ManagementDTO dto1) {
		
		int result = pm_stockDAO.updatePM_stock(dto1);
		
		return result;
	}
	
	@Override
	// 제품재고 페이지의 수정 
	public int modify_status_pmstock(Shipping_ManagementDTO dto1) {
		
		int result = pm_stockDAO.updatePM_status_stock(dto1);
		
		return result;
	}
	
	
}
