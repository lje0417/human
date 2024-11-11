package human.class1.ajax.rbController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import human.class1.ajax.shService.Shipping_ManagementService;

@Controller
public class Rollback_Management_Controller {
	@Autowired
	Shipping_ManagementService shService;
	
	@RequestMapping(value="/rb", method=RequestMethod.GET)
	public String view_sh() {
		return "Rollback/rollback";
	}
}
