package human.class1.ajax.shService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import human.class1.ajax.pl_spDTO.Plan_ManagementDTO;
import human.class1.ajax.shDAO.Shipping_ManagementDAO;
import human.class1.ajax.shDTO.Shipping_ManagementDTO;
import human.class1.ajax.stDTO.Stocking_ManagementDTO;

@Service
public class Shipping_ManagementServiceImpl implements Shipping_ManagementService{

	@Autowired
	Shipping_ManagementDAO shDAO;
	
	@Override
	// 출고관리 페이지의 검색 및 필터링, 페이지네이션
	public Map listsh(String countPerPage, String page, String search, String optionvalue) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo-1)* count) + 1;
		int end = pageNo * count;
		
		List list = shDAO.selectshPage(start, end, search, optionvalue);
		
		int totalCount = shDAO.totalshPage();
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
	@Override
	// 출고관리 페이지의 등록 정보 DB에 저장 
	public int joinsh(Shipping_ManagementDTO dto) {
		
		long sequence = shDAO.selectSequence();
		
		System.out.println("sequence "+ sequence);
		
		String sequenceString = Long.toString(sequence);
		
		dto.setShipping_number(sequenceString);
		
		System.out.println("dto: "+dto);
		
		int result = shDAO.insertSH(dto);
		
		return result;
	}
	
	@Override
	// 출고관리 페이지의 DB에서 삭제 (shipping_numbers로)  
	public int delete(String[] shipping_numbers) {
		
		int result = shDAO.deleteSH(shipping_numbers);
		
		return result;
	}
	
	@Override
	// 출고관리 페이지의 기존 정보 수정 
	public int modify_sh(Shipping_ManagementDTO dto) {
		
		int result = shDAO.updateSH(dto);
		
		return result;
	}
	@Override
	// 출고관리 페이지에서 shipping_number 하나로 셀렉트
	public Shipping_ManagementDTO get_select_data(String shipping_number) {
		
		Shipping_ManagementDTO dto = new Shipping_ManagementDTO();
		
		dto = shDAO.selectOne(shipping_number);
		
		return dto;
	}
	
	@Override
	// 상태표시가 완료된 sh데이터 추출
		public Shipping_ManagementDTO get_complete_data(Shipping_ManagementDTO dto) {
			
		Shipping_ManagementDTO shdto = shDAO.selectSH_data_one(dto);
			
			return shdto;
		}
	
	@Override
	// 출고관리 페이지의 상태 정보 수정 
	public int modify_sh_status(Shipping_ManagementDTO dto) {
		
		int result = shDAO.updateSH_status(dto);
		
		return result;
	}
	
}

