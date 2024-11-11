package human.class1.ajax.bomController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import human.class1.ajax.bomDTO.Bom_ManagementDTO;
import human.class1.ajax.bomService.Bom_ManagementService;
@Controller
public class Bom_Management_Controller {

	@Autowired
	Bom_ManagementService bomService;
	
	
	@RequestMapping(value="/bom", method=RequestMethod.GET)
	public String send(
			// 한 페이지당 개수
			@RequestParam(value="counterpage",required=false) String countPerPage,
			// 현재 페이지
			@RequestParam(value="page",required=false) String page,
			// 검색창의 입력 데이터 받기   
			@RequestParam(value="search",required=false) String search,
			// select 문의 option 값 받기
			@RequestParam(value= "optionvalue",required=false) String optionvalue,
						  Model model) {
		
		if(countPerPage == null) countPerPage = "5";
		if(page == null) page = "1";
		
		Map map = bomService.listbom(countPerPage, page, search, optionvalue);
		
		map.put("search", search);
		map.put("optionvalue", optionvalue);
		
		model.addAttribute("map",map);
		System.out.println("map :"+ map);
		System.out.println("map.list :"+ map.get("list"));
		model.addAttribute("countPerPage",countPerPage);
		model.addAttribute("page",page);
		return "BOM/BOMList";
	}
	
	// BOM 등록 페이지 컨트롤러
	@RequestMapping(value="/insert_bom", method=RequestMethod.GET)
	public String view(Model model) {
		List list = bomService.getPM_data();
		List list_pt = bomService.getPT_data();
		model.addAttribute("list", list);
		model.addAttribute("list_pt", list_pt);
		return "BOM/BOMInsert";
	}
	
	@RequestMapping(value="/insert_bom", method=RequestMethod.POST)
	public String insert(
			@ModelAttribute Bom_ManagementDTO dto) {
		System.out.println("dto :"+dto);
		int result = bomService.joinBOM(dto);
		
		return "redirect:/bom";
	}
	
//	// BOM 삭제 페이지 컨트롤러
//	@RequestMapping(value="/delete_bom", method=RequestMethod.POST)
//	public String collect_bom_numbers(
//			// 한 페이지당 개수
//			@RequestParam("plan_numbers") String plan_number) {
//		
//		String[] plan_numbers = plan_number.split(",");
//		
//		int result = plService.delete(plan_numbers);
//		System.out.println("삭제 개수 :"+ result);
//
//		return "redirect:/pl";
//	}
//	
//	// PL 수정 페이지 컨트롤러
//	@RequestMapping(value="/modify_pl", method=RequestMethod.GET)
//	public String view(
//			@RequestParam("plan_number") String plan_number,
//			@RequestParam("product_code") String product_code,			
//			Model model) {
//		
//		System.out.println("plan_number :"+plan_number);
//		System.out.println("product_code :"+product_code);
//		Plan_ManagementDTO dto = plService.get(plan_number);
//		Product_ManagementDTO pmdto = plService.getPM_data_one(product_code);
//		
//		System.out.println("dto "+ dto);
//		System.out.println("pmdto "+ pmdto);
//		model.addAttribute("dto",dto);
//		model.addAttribute("pmdto",pmdto);
//		
//		return "PL/PLModify";
//	}
//	
//	@RequestMapping(value="/modify_pl", method=RequestMethod.POST)
//	public String insert_modify(
//			@ModelAttribute Plan_ManagementDTO dto) {
//		System.out.println("dto :"+dto);
//		int result = plService.modify(dto);
//		System.out.println("modify 결과 :"+ result);
//		
//		return "redirect:/pl";
//	}
//	
//	// 생산계획관리 리스트에서 비고사항 확인
//	@RequestMapping(value="remarks", method=RequestMethod.GET)
//	public String view_remarks(
//			@RequestParam(value="plan_number",required=false) String plan_number,
//			Model model) {
//		Plan_ManagementDTO dto = plService.get(plan_number);
//		
//		model.addAttribute("dto", dto);
//		
//		return "PL/PLRemarks";
//	}
//	
//	// 작업지시서 관리 페이지 컨트롤러
//	@RequestMapping(value="/sp", method=RequestMethod.GET)
//	public String send_pmstock(
//			// 한 페이지당 개수
//			@RequestParam(value="counterpage",required=false) String countPerPage,
//			// 현재 페이지
//			@RequestParam(value="page",required=false) String page,
//			// 검색창의 입력 데이터 받기   
//			@RequestParam(value="search",required=false) String search,
//			// select 문의 option 값 받기
//			@RequestParam(value= "optionvalue",required=false) String optionvalue,
//						  Model model) {
//		
//		if(countPerPage == null) countPerPage = "5";
//		if(page == null) page = "1";
//		
//		System.out.println("countPerPage "+countPerPage );
//		System.out.println("page "+page );
//		
//		Map map = plService.listsp(countPerPage, page, search, optionvalue);
//		
//		map.put("search", search);
//		map.put("optionvalue", optionvalue);
//		
//		model.addAttribute("map",map);
//		System.out.println("map :"+ map);
//		System.out.println("map.list :"+ map.get("list"));
//		model.addAttribute("countPerPage",countPerPage);
//		model.addAttribute("page",page);
//		return "SP/SPList";
//	}
//	
//	// 작업지시서 삭제 페이지 컨트롤러
//		@RequestMapping(value="/delete_sp", method=RequestMethod.POST)
//		public String collect_specification_numbers(
//				// 한 페이지당 개수
//				@RequestParam("specification_numbers") String specification_number) {
//			
//			String[] specification_numbers = specification_number.split(",");
//			
//			int result = plService.delete_sp(specification_numbers);
//			System.out.println("삭제 개수 :"+ result);
//
//			return "redirect:/sp";
//		}
//		
//	// 작업지시서 페이지 컨트롤러
//		@RequestMapping(value="/sp_detail", method=RequestMethod.GET)
//		public String view_sp_detail(
//				@RequestParam(value= "plan_start_date") String plan_start_date,
//							  Model model) {
//				
//			List list = plService.listsp_detail(plan_start_date);
//			System.out.println("list "+ list);
//		
//			model.addAttribute("list",list);
//			return "SP/SPList_Detail";
//		}
//		
//	// 작업지시서 상태변화 업데이트 
//				@RequestMapping(value="/update_sp", method=RequestMethod.PUT)
//				public String update_sp(
//						@RequestParam(value= "specification_status") String specification_status,
//						@RequestParam(value= "specification_number") String specification_number,
//									  Model model) {
//						
//					Specification_ManagementDTO dto = new Specification_ManagementDTO();
//					dto.setSpecification_status(specification_status);
//					dto.setSpecification_number(specification_number);
//					
//					int result = plService.modify_sp(dto);
//					System.out.println("modify 결과 :"+ result);
//					
//					Specification_ManagementDTO dto1 = new Specification_ManagementDTO();
//					
//					dto1 = plService.get_complete_data(dto);
//					
//					System.out.println("dto1 :"+ dto1 );
//					
//					pmService.modify_pmstock(dto1);
//					
//					return "forward:/pm_stock_modify";
//		
//				}		

}
