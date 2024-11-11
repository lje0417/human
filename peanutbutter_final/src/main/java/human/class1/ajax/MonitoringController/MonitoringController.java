package human.class1.ajax.MonitoringController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MonitoringController {


	@RequestMapping(value="chart", method=RequestMethod.GET)
	public String view(
			
			) {
		return "Chart/chart";
	}
	
	@RequestMapping(value="chart2", method=RequestMethod.GET)
	public String view_chart2(
			
			) {
		return "Chart/chart2";
	}
	
}
