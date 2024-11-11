package human.class1.ajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FactoryDetailController {
	
    @GetMapping("/factory_Detail")
    public String getFactoryDetail(@RequestParam("processCode5") String processCode5, Model model) {

        return "factoryDetail";
    }
}
