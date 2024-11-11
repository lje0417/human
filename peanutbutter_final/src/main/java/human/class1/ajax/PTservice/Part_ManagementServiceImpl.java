package human.class1.ajax.PTservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import human.class1.ajax.PTDAO.Part_ManagementDAO;
import human.class1.ajax.PTDAO.Part_Stock_ManagementDAO;
import human.class1.ajax.PTDTO.Part_ManagementDTO;
import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.stDTO.Stocking_ManagementDTO;

@Service
public class Part_ManagementServiceImpl implements Part_ManagementService{

	@Autowired
	Part_ManagementDAO ptDAO;
	
	@Autowired
	Part_Stock_ManagementDAO pt_stockDAO;
	
	@Override
	// 제품관리 페이지의 제품 검색 및 필터링, 페이지네이션
	public Map listpt(String countPerPage, String page, String search, String optionvalue) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo-1)* count) + 1;
		int end = pageNo * count;
		
		List list = ptDAO.selectptPage(start, end, search, optionvalue);
		
		int totalCount = ptDAO.totalptPage();
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
	@Override
	// 제품관리 페이지의 등록 정보 DB에 저장 
	public int joinPT(Part_ManagementDTO dto) {
		
		long sequence = ptDAO.selectSequence();
		
		System.out.println("sequence "+ sequence);
		
		String sequenceString = Long.toString(sequence);
		
		dto.setPart_code(sequenceString);
		
		System.out.println("dto: "+dto);
		
		int result = ptDAO.insertPT(dto);
		int insertCount_stock = pt_stockDAO.insert_PT_stock(dto);
		
		return result;
	}
	@Override
	// 제품관리 페이지의 DB에서 삭제 (part_code로)  
	public int delete(String[] part_codes) {
		
		int result = ptDAO.deletePT(part_codes);
		
		return result;
	}
	@Override
	// 제품관리 페이지의 기존 정보 수정 
	public int modify_pt(Part_ManagementDTO dto) {
		
		int result = ptDAO.updatePT(dto);
		
		return result;
	}
	@Override
	// 제품관리 페이지에서 product_code 하나로 셀렉트
	public Part_ManagementDTO get_pt(String part_code) {
		
		Part_ManagementDTO dto = new Part_ManagementDTO();
		
		dto = ptDAO.selectOne(part_code);
		
		return dto;
	}
	
	@Override
	// 제품재고 관리 페이지의 제품 검색 및 필터링, 페이지네이션 
	public Map listpt_stock(String countPerPage, String page, String search, String optionvalue) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo-1)* count) + 1;
		int end = pageNo * count;
		
		List list = pt_stockDAO.selectpt_stockPage(start, end, search, optionvalue);
		
		System.out.println("list "+ list);
		int totalCount = pt_stockDAO.totalpt_stockPage();
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
	@Override
	// 제품재고관리 페이지의 DB에서 삭제 (product_code로)  
	public int delete_ptstock(String[] part_codes) {
		
		int result = pt_stockDAO.deletePT_Stock(part_codes);
		
		return result;
	}
	
	@Override
	// 부품재고 페이지의 수정 
	public int modify_ptstock(Stocking_ManagementDTO dto1) {
		
		int result = pt_stockDAO.updatePT_stock(dto1);
		
		return result;
	}
	
	
}
