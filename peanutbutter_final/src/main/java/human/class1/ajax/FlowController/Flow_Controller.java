package human.class1.ajax.FlowController;

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

import human.class1.ajax.FlowService.FlowService;

@Controller
public class Flow_Controller {

	@Autowired
	FlowService flService;
	
	
	@RequestMapping(value="/fl", method=RequestMethod.GET)
	public String send(
			// 한 페이지당 개수
			@RequestParam(value="counterpage",required=false) String countPerPage,
			// 현재 페이지
			@RequestParam(value="page",required=false) String page,
			// 프로세스 코드 받기
			@RequestParam(value="process_code",required=false) String process_code,
						  Model model) {
		
		if(countPerPage == null) countPerPage = "5";
		if(page == null) page = "1";
		
		Map map = flService.listfl(countPerPage, page, process_code);
		
		model.addAttribute("map",map);
		System.out.println("map :"+ map);
		System.out.println("map.list :"+ map.get("list"));
		model.addAttribute("countPerPage",countPerPage);
		model.addAttribute("page",page);
		return "SP/SPList_Flow";
	}

}
