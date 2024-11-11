package human.class1.ajax.poController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import human.class1.ajax.pmdto.Product_ManagementDTO;
import human.class1.ajax.poDTO.Purchase_Order_ManagementDTO;
import human.class1.ajax.poService.Purchase_Order_ManagementService;

@Controller
public class Purchase_Order_Management_Controller {
	@Autowired
	Purchase_Order_ManagementService poService;
	
	@RequestMapping(value="/po", method=RequestMethod.GET)
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
		
		Map map = poService.listpo(countPerPage, page, search, optionvalue);
		
		map.put("search", search);
		map.put("optionvalue", optionvalue);
		
		model.addAttribute("map",map);
		System.out.println("map :"+ map);
		System.out.println("map.list :"+ map.get("list"));
		model.addAttribute("countPerPage",countPerPage);
		model.addAttribute("page",page);
		return "PO/Purchase_orderList";
	}
	
	// PO 등록 페이지 컨트롤러
		@RequestMapping(value="/insert_po", method=RequestMethod.GET)
		public String view(Model model) {
			List list = poService.getPT_data();
			model.addAttribute("list", list);
			return "PO/Purchase_orderInsert";
		}
		
		@RequestMapping(value="/insert_po", method=RequestMethod.POST)
		public String insert(
				@ModelAttribute Purchase_Order_ManagementDTO dto) {
			System.out.println("dto :"+dto);
			int result = poService.joinpo(dto);
			
			return "redirect:/po";
		}
		
		@RequestMapping(value="/delete_po", method=RequestMethod.POST)
		public String collect_purchase_order_numbers(
				// 한 페이지당 개수
				@RequestParam("purchase_order_numbers") String purchase_order_number) {
			
			String[] purchase_order_numbers = purchase_order_number.split(",");
			
			int result = poService.delete(purchase_order_numbers);
			System.out.println("삭제 개수 :"+ result);

			return "redirect:/po";
		}
//		
		// 발주관리 수정 페이지 컨트롤러
		@RequestMapping(value="/modify_po", method=RequestMethod.GET)
		public String view(
				@RequestParam("purchase_order_number") String purchase_order_number,
				@RequestParam("part_code") String part_code,			
				Model model) {
			
			System.out.println("purchase_order_number :"+purchase_order_number);
			System.out.println("part_code :"+part_code);
			Purchase_Order_ManagementDTO dto = poService.get_select_data(purchase_order_number);
			
			System.out.println("dto "+ dto);
			model.addAttribute("dto",dto);
			
			return "PO/Purchase_orderUpdate";
		}
		
		@RequestMapping(value="/modify_po", method=RequestMethod.POST)
		public String insert_po_to_modify(
				@ModelAttribute Purchase_Order_ManagementDTO dto) {
			System.out.println("dto :"+dto);
			int result = poService.modify_po(dto);
			System.out.println("modify 결과 :"+ result);
			
			return "redirect:/po";
		}
	
}
