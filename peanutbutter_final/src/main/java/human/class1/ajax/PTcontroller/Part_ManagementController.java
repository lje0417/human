package human.class1.ajax.PTcontroller;

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

import human.class1.ajax.PTDTO.Part_ManagementDTO;
import human.class1.ajax.PTservice.Part_ManagementService;

@Controller
public class Part_ManagementController {

	@Autowired
	Part_ManagementService ptService;
	
	@RequestMapping(value="/pt", method=RequestMethod.GET)
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
		
		Map map = ptService.listpt(countPerPage, page, search, optionvalue);
		
		map.put("search", search);
		map.put("optionvalue", optionvalue);
		
		model.addAttribute("map",map);
		System.out.println("map :"+ map);
		System.out.println("map.list :"+ map.get("list"));
		model.addAttribute("countPerPage",countPerPage);
		model.addAttribute("page",page);
		return "PT/PTList";
	}
	
	// PM 등록 페이지 컨트롤러
	@RequestMapping("/insert_pt")
	public String view() {
		return "PT/PTInsert";
	}
	
	@RequestMapping(value="/insert_pt", method=RequestMethod.POST)
	public String insert(
			@ModelAttribute Part_ManagementDTO dto) {
		System.out.println("dto :"+dto);
		int result = ptService.joinPT(dto);
		
		return "redirect:/pt";
	}
	
	// PT 삭제 페이지 컨트롤러
	@RequestMapping(value="/delete_pt", method=RequestMethod.POST)
	public String collect_part_code(
			// 한 페이지당 개수
			@RequestParam("part_codes") String part_code) {
		
		String[] part_codes = part_code.split(",");
		
		int result = ptService.delete(part_codes);
		System.out.println("삭제 개수 :"+ result);

		return "redirect:/pt";
	}
	
	// PM 수정 페이지 컨트롤러
	@RequestMapping(value="/modify_pt", method=RequestMethod.GET)
	public String view(
			@RequestParam("part_code") String part_code,
			Model model) {
		
		System.out.println("part_code: "+ part_code);
		Part_ManagementDTO dto = ptService.get_pt(part_code);
		
		System.out.println("dto "+ dto);
		model.addAttribute("dto",dto);
		
		return "PT/PTModify";
	}
	
	@RequestMapping(value="/modify_pt", method=RequestMethod.POST)
	public String insert_modify(
			@ModelAttribute Part_ManagementDTO dto) {
		System.out.println("dto :"+dto);
		int result = ptService.modify_pt(dto);
		System.out.println("modify 결과 :"+ result);
		
		return "redirect:/pt";
	}
	
	// 제품재고관리 페이지 컨트롤러
	@RequestMapping(value="/pt_stock", method=RequestMethod.GET)
	public String send_pmstock(
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
		
		System.out.println("countPerPage "+countPerPage );
		System.out.println("page "+page );
		
		Map map = ptService.listpt_stock(countPerPage, page, search, optionvalue);
		
		map.put("search", search);
		map.put("optionvalue", optionvalue);
		
		model.addAttribute("map",map);
		System.out.println("map :"+ map);
		System.out.println("map.list :"+ map.get("list"));
		model.addAttribute("countPerPage",countPerPage);
		model.addAttribute("page",page);
		return "PT_Stock/PT_Stock_List";
	}
	// 제품재고관리 페이지 삭제
	@RequestMapping(value="/delete_pt_stock", method=RequestMethod.POST)
	public String collect_ptstock_part_code(
			// 한 페이지당 개수
			@RequestParam("part_codes") String part_code) {
		
		String[] part_codes = part_code.split(",");
		System.out.println("part_codes : "+ part_codes[0]);
		
		int result = ptService.delete_ptstock(part_codes);
		System.out.println("삭제 개수 :"+ result);

		return "redirect:/pt_stock";
	}
	
}
