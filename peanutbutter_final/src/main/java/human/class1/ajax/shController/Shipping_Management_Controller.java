package human.class1.ajax.shController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import human.class1.ajax.PTservice.Part_ManagementService;
import human.class1.ajax.pl_spDTO.Plan_ManagementDTO;
import human.class1.ajax.pl_spService.Plan_ManagementService;
import human.class1.ajax.pmdto.Product_ManagementDTO;
import human.class1.ajax.pmservice.Product_ManagementService;
import human.class1.ajax.shDTO.Shipping_ManagementDTO;
import human.class1.ajax.shService.Shipping_ManagementService;
import human.class1.ajax.stDTO.Stocking_ManagementDTO;

@Controller
public class Shipping_Management_Controller {
	@Autowired
	Shipping_ManagementService shService;
	
	@Autowired
	Plan_ManagementService plService;
	
	@Autowired
	Product_ManagementService pmService;
	
	@RequestMapping(value="/sh", method=RequestMethod.GET)
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
		
		Map map = shService.listsh(countPerPage, page, search, optionvalue);
		
		map.put("search", search);
		map.put("optionvalue", optionvalue);
		
		model.addAttribute("map",map);
		System.out.println("map :"+ map);
		System.out.println("map.list :"+ map.get("list"));
		model.addAttribute("countPerPage",countPerPage);
		model.addAttribute("page",page);
		return "Shipping/ShippingList";
	}
	
	// SH 등록 페이지 컨트롤러
		@RequestMapping(value="/insert_sh", method=RequestMethod.GET)
		public String view(Model model) {
			List list = plService.getPM_data();
			model.addAttribute("list", list);
			return "Shipping/ShippingInsert";
		}
		
		@RequestMapping(value="/insert_sh", method=RequestMethod.POST)
		public String insert(
				@ModelAttribute Shipping_ManagementDTO dto) {
			System.out.println("dto :"+dto);
			int result = shService.joinsh(dto);
			
			return "redirect:/sh";
		}
		
		@RequestMapping(value="/delete_sh", method=RequestMethod.POST)
		public String collect_shipping_numbers(
				// 한 페이지당 개수
				@RequestParam("shipping_numbers") String shipping_number) {
			
			String[] shipping_numbers = shipping_number.split(",");
			
			int result = shService.delete(shipping_numbers);
			System.out.println("삭제 개수 :"+ result);

			return "redirect:/sh";
		}
		
		// 출고관리 수정 페이지 컨트롤러
		@RequestMapping(value="/modify_sh", method=RequestMethod.GET)
		public String view(
				@RequestParam("shipping_number") String shipping_number,
				@RequestParam("product_code") String product_code,			
				Model model) {
			
			System.out.println("shipping_number :"+shipping_number);
			System.out.println("product_code :"+product_code);
			Shipping_ManagementDTO dto = shService.get_select_data(shipping_number);
			
			System.out.println("dto "+ dto);
			model.addAttribute("dto",dto);
			
			return "Shipping/ShippingUpdate";
		}
		
		@RequestMapping(value="/modify_sh", method=RequestMethod.POST)
		public String insert_sh_to_modify(
				@ModelAttribute Shipping_ManagementDTO dto) {
			System.out.println("dto :"+dto);
			int result = shService.modify_sh(dto);
			System.out.println("modify 결과 :"+ result);
			
			return "redirect:/sh";
		}
		
		// 입고관리 상태변화 업데이트 
		@RequestMapping(value="/update_sh", method=RequestMethod.PUT)
		public String update_st(
				@RequestParam(value= "shipping_status") String shipping_status,
				@RequestParam(value= "shipping_number") String shipping_number,
					Model model) {
							
			Shipping_ManagementDTO dto = new Shipping_ManagementDTO();
			dto.setShipping_status(shipping_status);
			dto.setShipping_number(shipping_number);
						
			int result = shService.modify_sh_status(dto);
			System.out.println("modify 결과 :"+ result);
						
			Shipping_ManagementDTO dto1 = new Shipping_ManagementDTO();
						
			dto1 = shService.get_complete_data(dto);
						
			System.out.println("dto1 :"+ dto1 );
						
			pmService.modify_status_pmstock(dto1);
						
			return "forward:/pm_stock_modify";
			
		}		
	
}
