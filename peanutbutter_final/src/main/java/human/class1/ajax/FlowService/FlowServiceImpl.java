package human.class1.ajax.FlowService;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import human.class1.ajax.FlowDAO.FlowDAO;
import human.class1.ajax.pmdto.Product_ManagementDTO;
@Service
public class FlowServiceImpl implements FlowService{

	@Autowired
	FlowDAO flDAO;
	
	@Override
	// 작업순서도 페이지의 페이지네이션
	public Map listfl(String countPerPage, String page, String process_code) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo-1)* count) + 1;
		int end = pageNo * count;
		
		List list = flDAO.selectflPage(start, end, process_code);
		
		int totalCount = flDAO.totalflPage();
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
//	@Override
//	// BOM 페이지에서  하나로 셀렉트
//	public Product_ManagementDTO get(String product_code) {
//		
//		Product_ManagementDTO dto = new Product_ManagementDTO();
//		
//		dto = pmDAO.selectOne(product_code);
//		
//		return dto;
//	}
	
	
}
