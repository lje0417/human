package human.class1.ajax.bomService;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import human.class1.ajax.bomDAO.Bom_ManagementDAO;
import human.class1.ajax.bomDTO.Bom_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;

@Service
public class Bom_ManagementServiceImpl implements Bom_ManagementService{

	@Autowired
	Bom_ManagementDAO bomDAO;
	
	@Override
	// 계획관리 페이지의 검색 및 필터링, 페이지네이션
	public Map listbom(String countPerPage, String page, String search, String optionvalue) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo-1)* count) + 1;
		int end = pageNo * count;
		
		List list = bomDAO.selectbomPage(start, end, search, optionvalue);
		
		int totalCount = bomDAO.totalbomPage();
		
		Map map = new HashMap();
		map.put("list",list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
	
	@Override
	// 제품관리 페이지의 등록 정보 DB에 저장 
	public int joinBOM(Bom_ManagementDTO dto) {
		
		long sequence = bomDAO.selectSequence();
		
		System.out.println("sequence "+ sequence);
		
		String sequenceString = Long.toString(sequence);
		
		dto.setBom_number(sequenceString);
		
		List<String> partCodes = Arrays.asList(dto.getPart_code().split(","));
        List<String> partNames = Arrays.asList(dto.getPart_name().split(","));
        List<String> partModelNames = Arrays.asList(dto.getPart_modelname().split(","));
        List<String> partStandards = Arrays.asList(dto.getPart_standard().split(","));
        List<String> partUnits = Arrays.asList(dto.getPart_unit().split(","));
        List<String> partAmounts = Arrays.asList(dto.getPart_amount_str().split(","));
		
		System.out.println("dto: "+dto);
		int result = 0;
		for(int i=0; i < partCodes.size(); i++) {
			dto.setPart_code(partCodes.get(i));
			dto.setPart_name(partNames.get(i));
			dto.setPart_modelname(partModelNames.get(i));
			dto.setPart_standard(partStandards.get(i));
			dto.setPart_unit(partUnits.get(i));
			dto.setPart_amount_str(partAmounts.get(i));
			result += bomDAO.insertBOM(dto);
		}
		
		return result;
	}
	
	
//	@Override
//	// 제품관리 페이지의 등록 정보 DB에 저장 
//	public int joinBOM(Bom_ManagementDTO dto) {
//		
//		long sequence = bomDAO.selectSequence();
//		
//		System.out.println("sequence "+ sequence);
//		
//		String sequenceString = Long.toString(sequence);
//		
//		dto.setBom_number(sequenceString);
//		
//		System.out.println("dto: "+dto);
//		
//		
//		
//		int result = bomDAO.insertBOM(dto);
//		
//		Date plan_start_date = dto.getPlan_start_date();
//		Date plan_end_date = dto.getPlan_end_date();
//		
//		// Calendar 객체를 사용하기 위해 Calendar 인스턴스를 생성합니다.
//		Calendar calStrDt = Calendar.getInstance();
//		Calendar calEndDt = Calendar.getInstance();
//		
//		// 시작 날짜를 Calendar 객체에 설정합니다.
//		calStrDt.setTime(plan_start_date);
//		
//		// 시작일의 일(day), 월(month), 연(year)을 가져옵니다.
//		int strDayOfMonth = calStrDt.get(Calendar.DAY_OF_MONTH); 
//		int strMonth = calStrDt.get(Calendar.MONTH); 
//		int strYear = calStrDt.get(Calendar.YEAR);
//		
//		// 종료 날짜를 Calendar 객체에 설정합니다.
//		calEndDt.setTime(plan_end_date);
//		// 종료일의 일(day), 월(month), 연(year)을 가져옵니다.
//		int endDayOfMonth = calEndDt.get(Calendar.DAY_OF_MONTH); 
//		int endMonth = calEndDt.get(Calendar.MONTH); 
//		int endYear = calEndDt.get(Calendar.YEAR); 
//
//		// 두 날짜의 일(day) 차이를 계산합니다.
//		int diffDays = calStrDt.getActualMaximum(Calendar.DAY_OF_MONTH) == strDayOfMonth && calEndDt.getActualMaximum(Calendar.DAY_OF_MONTH) == endDayOfMonth ? 0 : endDayOfMonth - strDayOfMonth;
//		// 두 날짜의 월(month) 차이를 계산합니다.
//		int diffMonths = endMonth - strMonth;
//		// 두 날짜의 연(year) 차이를 계산합니다.
//		int diffYears = endYear - strYear;
//		
//		// 일 차이 결과를 출력합니다.
//		System.out.println(diffDays);	
//		
//		int plan_amount = dto.getPlan_amount();
//		double plan_amout_per_day = (double)(plan_amount/diffDays);
//		
//		Specification_ManagementDTO spDTO = new Specification_ManagementDTO();
//		
//		java.sql.Date sqlEndDate = new java.sql.Date(calEndDt.getTimeInMillis());
//		spDTO.setPlan_end_date(sqlEndDate);
//		
//		String product_code_sp = dto.getProduct_code();
//		String product_name_sp = dto.getProduct_name();
//		
//		spDTO.setProduct_code(product_code_sp);
//		spDTO.setProduct_name(product_name_sp);
//		
//		
//		
//		for(int i=0; i<=diffDays; i++) {	
//			
//		java.sql.Date sqlStartDate = new java.sql.Date(calStrDt.getTimeInMillis());		
//		
//		int dailyAmount = (int) Math.round(plan_amout_per_day);
//		
//		// 마지막 일에 나머지 몰아넣기
//		if (i == diffDays) { 
//			dailyAmount = plan_amount - (dailyAmount * (diffDays));
//		}
//		
//		spDTO.setPlan_amount(dailyAmount);
//		
//		long sequence_sp = spDAO.selectSequence_sp();
//		
//		System.out.println("sequence_sp "+ sequence_sp);
//		
//		String sequenceString_sp = Long.toString(sequence_sp);
//		
//		spDTO.setSpecification_number(sequenceString_sp);
//		spDTO.setPlan_start_date(sqlStartDate);
//		
//		spDAO.insertSP(spDTO);
//		
//		// 시작일에 1일을 추가 합니다 
//		calStrDt.add(Calendar.DAY_OF_MONTH,1);
//		
//		System.out.println("sqlStartDate :"+ sqlStartDate);
//		
//		}
//		return result;
//	}
	
	@Override
	public List getPM_data() {
		
		List result = bomDAO.selectPM_data();
		return result;
	}
	
	@Override
	public List getPT_data() {
		
		List result = bomDAO.selectPT_data();
		return result;
	}
	
//	@Override
//	// 계획관리 페이지의 DB에서 삭제 (plan_numbers로)  
//	public int delete(String[] plan_numbers) {
//		
//		int result = plDAO.deletePL(plan_numbers);
//		
//		return result;
//	}
//	@Override
//	// 제품관리 페이지의 기존 정보 수정 
//	public int modify(Plan_ManagementDTO dto) {
//		
//		int result = plDAO.updatePL(dto);
//		
//		return result;
//	}
//	@Override
//	// 제품관리 페이지에서 plan_number 하나로 셀렉트
//	public Plan_ManagementDTO get(String plan_number) {
//		
//		Plan_ManagementDTO dto = new Plan_ManagementDTO();
//		
//		dto = plDAO.selectOne(plan_number);
//		
//		return dto;
//	}
//	@Override
//	public Product_ManagementDTO getPM_data_one(String product_code) {
//		
//		Product_ManagementDTO pmdto = plDAO.selectPM_data_one(product_code);
//		
//		System.out.println("pmdto_service "+ pmdto);
//		
//		return pmdto;
//	}
//	
//	@Override
//	// 계획관리 페이지의 검색 및 필터링, 페이지네이션
//	public Map listsp(String countPerPage, String page, String search, String optionvalue) {
//		int count = Integer.parseInt(countPerPage);
//		int pageNo = Integer.parseInt(page);
//		
//		int start = ((pageNo-1)* count) + 1;
//		int end = pageNo * count;
//		
//		List list = spDAO.selectspPage(start, end, search, optionvalue);
//		
//		int totalCount = spDAO.totalspPage();
//		
//		Map map = new HashMap();
//		map.put("list",list);
//		map.put("totalCount", totalCount);
//		
//		return map;
//	}
//	
//	@Override
//	// 계획관리 페이지의 DB에서 삭제 (plan_numbers로)  
//	public int delete_sp(String[] specification_numbers) {
//		
//		int result = spDAO.deleteSP(specification_numbers);
//		
//		return result;
//	}
//	
//	@Override
//	// 작업지시서 디테일 페이지 뷰어
//	public List listsp_detail(String plan_start_date) {		
//		
//		List list = spDAO.selectsp_detail(plan_start_date);
//
//		return list;
//	}
//	
//	@Override
//	// 제품관리 페이지의 기존 정보 수정 
//		public int modify_sp(Specification_ManagementDTO dto) {
//			
//			int result = spDAO.updateSP(dto);
//			
//			return result;
//		}
//	@Override
//	// 상태표시가 완료된 sp데이터 추출
//		public Specification_ManagementDTO get_complete_data(Specification_ManagementDTO dto) {
//			
//		Specification_ManagementDTO spdto = spDAO.selectSP_data_one(dto);
//			
//			return spdto;
//		}
	
}