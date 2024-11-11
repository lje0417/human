package human.class1.ajax.stController;

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

import human.class1.ajax.PTservice.Part_ManagementService;
import human.class1.ajax.stDTO.Stocking_ManagementDTO;
import human.class1.ajax.stService.Stocking_ManagementService;

@Controller
public class Stocking_Management_Controller {

	@Autowired
	Stocking_ManagementService stService;
	
	@Autowired
	Part_ManagementService ptService;
		
	@RequestMapping(value="/st", method=RequestMethod.GET)
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
		
		Map map = stService.listst(countPerPage, page, search, optionvalue);
		
		map.put("search", search);
		map.put("optionvalue", optionvalue);
		
		model.addAttribute("map",map);
		System.out.println("map :"+ map);
		System.out.println("map.list :"+ map.get("list"));
		model.addAttribute("countPerPage",countPerPage);
		model.addAttribute("page",page);
		return "Stocking/StockingList";
	}
	
	// ST 등록 페이지 컨트롤러
	@RequestMapping(value="/insert_st", method=RequestMethod.GET)
	public String view(Model model) {
		List list = stService.getPO_data();
		model.addAttribute("list", list);
		return "Stocking/StockingInsert";
	}
	
	@RequestMapping(value="/insert_st", method=RequestMethod.POST)
	public String insert(
			@ModelAttribute Stocking_ManagementDTO dto) {
		System.out.println("dto :"+dto);
		int result = stService.joinst(dto);
		
		return "redirect:/st";
	}
	
	// ST 삭제 페이지 컨트롤러
	@RequestMapping(value="/delete_st", method=RequestMethod.POST)
	public String collect_stocking_numbers(
			// 한 페이지당 개수
			@RequestParam("stocking_numbers") String stocking_number) {
		
		String[] stocking_numbers = stocking_number.split(",");
		
		int result = stService.delete(stocking_numbers);
		System.out.println("삭제 개수 :"+ result);

		return "redirect:/st";
	}
	
	// ST 수정 페이지 컨트롤러
	@RequestMapping(value="/modify_st", method=RequestMethod.GET)
	public String view(
			@RequestParam("stocking_number") String stocking_number,			
			Model model) {
		
		System.out.println("stocking_number :"+stocking_number);
		Stocking_ManagementDTO dto = stService.get_select_data(stocking_number);
		
		System.out.println("dto "+ dto);
		model.addAttribute("dto",dto);
		
		return "Stocking/StockingUpdate";
	}
	
	@RequestMapping(value="/modify_st", method=RequestMethod.POST)
	public String insert_modify(
			@ModelAttribute Stocking_ManagementDTO dto) {
		System.out.println("dto :"+dto);
		int result = stService.modify_st(dto);
		System.out.println("modify 결과 :"+ result);
		
		return "redirect:/st";
	}

	// 입고관리 상태변화 업데이트 
	@RequestMapping(value="/update_st", method=RequestMethod.PUT)
	public String update_st(
			@RequestParam(value= "stocking_status") String stocking_status,
			@RequestParam(value= "stocking_number") String stocking_number,
				Model model) {
						
		Stocking_ManagementDTO dto = new Stocking_ManagementDTO();
		dto.setStocking_status(stocking_status);
		dto.setStocking_number(stocking_number);
					
		int result = stService.modify_st_status(dto);
		System.out.println("modify 결과 :"+ result);
					
		Stocking_ManagementDTO dto1 = new Stocking_ManagementDTO();
					
		dto1 = stService.get_complete_data(dto);
					
		System.out.println("dto1 :"+ dto1 );
					
		ptService.modify_ptstock(dto1);
					
		return "forward:/pt_stock_modify";
		
	}		

}
