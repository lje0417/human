package human.class1.ajax.pmcontroller;

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

import human.class1.ajax.pl_spDTO.Specification_ManagementDTO;
import human.class1.ajax.pmdto.Product_ManagementDTO;
import human.class1.ajax.pmservice.Product_ManagementService;

@Controller("p")
public class Product_ManagementController {

	@Autowired
	Product_ManagementService pmService;
	
	@RequestMapping(value="/pm", method=RequestMethod.GET)
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
		
		Map map = pmService.listpm(countPerPage, page, search, optionvalue);
		
		map.put("search", search);
		map.put("optionvalue", optionvalue);
		
		model.addAttribute("map",map);
		System.out.println("map :"+ map);
		System.out.println("map.list :"+ map.get("list"));
		model.addAttribute("countPerPage",countPerPage);
		model.addAttribute("page",page);
		return "PM/pmlist";
	}
	
	// PM 등록 페이지 컨트롤러
	@RequestMapping("/insert")
	public String view() {
		return "PM/PMInsert";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(
			@ModelAttribute Product_ManagementDTO dto) {
		System.out.println("dto :"+dto);
		int result = pmService.joinPM(dto);
		
		return "redirect:/pm";
	}
	
	// PM 삭제 페이지 컨트롤러
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String collect_product_code(
			// 한 페이지당 개수
			@RequestParam("product_codes") String product_code) {
		
		String[] product_codes = product_code.split(",");
		System.out.println("product_codes : "+ product_codes[0]);
		
		int result = pmService.delete(product_codes);
		System.out.println("삭제 개수 :"+ result);

		return "redirect:/pm";
	}
	
	// PM 수정 페이지 컨트롤러
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public String view(
			@RequestParam("product_code") String product_code,
			Model model) {
		
		System.out.println("product_code: "+ product_code);
		Product_ManagementDTO dto = pmService.get(product_code);
		
		System.out.println("dto "+ dto);
		model.addAttribute("dto",dto);
		
		return "PM/PMModify";
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String insert_modify(
			@ModelAttribute Product_ManagementDTO dto) {
		System.out.println("dto :"+dto);
		int result = pmService.modify(dto);
		System.out.println("modify 결과 :"+ result);
		
		return "redirect:/pm";
	}
	
	// 제품재고관리 페이지 컨트롤러
	@RequestMapping(value="/pm_stock", method=RequestMethod.GET)
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
		
		Map map = pmService.listpm_stock(countPerPage, page, search, optionvalue);
		
		map.put("search", search);
		map.put("optionvalue", optionvalue);
		
		model.addAttribute("map",map);
		System.out.println("map :"+ map);
		System.out.println("map.list :"+ map.get("list"));
		model.addAttribute("countPerPage",countPerPage);
		model.addAttribute("page",page);
		return "PM_Stock/PM_Stock_List";
	}
	// 제품재고관리 페이지 삭제
	@RequestMapping(value="/delete_pm_stock", method=RequestMethod.POST)
	public String collect_pmstock_product_code(
			// 한 페이지당 개수
			@RequestParam("product_codes") String product_code) {
		
		String[] product_codes = product_code.split(",");
		System.out.println("product_codes : "+ product_codes[0]);
		
		int result = pmService.delete_pmstock(product_codes);
		System.out.println("삭제 개수 :"+ result);

		return "redirect:/pm_stock";
	}
	
}
