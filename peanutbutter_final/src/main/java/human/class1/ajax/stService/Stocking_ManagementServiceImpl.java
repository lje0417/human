package human.class1.ajax.stService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.stDAO.Stocking_ManagementDAO;
import human.class1.ajax.stDTO.Stocking_ManagementDTO;

@Service
public class Stocking_ManagementServiceImpl implements Stocking_ManagementService{

	@Autowired
	Stocking_ManagementDAO stDAO;
	
	@Override
	// 입고관리 페이지의 검색 및 필터링, 페이지네이션
	public Map listst(String countPerPage, String page, String search, String optionvalue) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo-1)* count) + 1;
		int end = pageNo * count;
		
		List list = stDAO.selectstPage(start, end, search, optionvalue);
		
		int totalCount = stDAO.totalstPage();
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
	@Override
	// 입고관리 페이지의 등록 정보 DB에 저장 
	public int joinst(Stocking_ManagementDTO dto) {
		
		long sequence = stDAO.selectSequence();
		
		System.out.println("sequence "+ sequence);
		
		String sequenceString = Long.toString(sequence);
		
		dto.setStocking_number(sequenceString);
		
		System.out.println("dto: "+dto);
		
		int result = stDAO.insertST(dto);
		
		return result;
	}
	
	@Override
	public List getPO_data() {
		
		List result = stDAO.selectPO_data();
		return result;
	}
	
	@Override
	// 입고관리 페이지의 DB에서 삭제 (purchase_order_numbers로)  
	public int delete(String[] stocking_numbers) {
		
		int result = stDAO.deleteST(stocking_numbers);
		
		return result;
	}
	
	@Override
	// 입고관리 페이지의 기존 정보 수정 
	public int modify_st(Stocking_ManagementDTO dto) {
		
		int result = stDAO.updateST(dto);
		
		return result;
	}
	@Override
	// 입고관리 페이지에서  하나로 셀렉트
	public Stocking_ManagementDTO get_select_data(String stocking_number) {
		
		Stocking_ManagementDTO dto = new Stocking_ManagementDTO();
		
		dto = stDAO.selectOne(stocking_number);
		
		return dto;
	}
	
	@Override
	// 상태표시가 완료된 st데이터 추출
		public Stocking_ManagementDTO get_complete_data(Stocking_ManagementDTO dto) {
			
		Stocking_ManagementDTO stdto = stDAO.selectST_data_one(dto);
			
			return stdto;
		}
	
	@Override
	// 입고관리 페이지의 상태 정보 수정 
	public int modify_st_status(Stocking_ManagementDTO dto) {
		
		int result = stDAO.updateST_status(dto);
		
		return result;
	}
	
}

