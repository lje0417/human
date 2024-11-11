package human.class1.ajax.controller;

import human.class1.ajax.mapper.DELETEMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DeleteProcessController {

    @Autowired
    private DELETEMapper deleteMapper;

    @PostMapping("/DeleteProcess")
    public String deleteProcess(@RequestParam("processCode") String[] processCodes, RedirectAttributes redirectAttributes) {
        System.out.println(processCodes);
    	if (processCodes != null && processCodes.length > 0) {
            for (String processCode : processCodes) {
                deleteMapper.deleteProcess(processCode);
            }
        }
        
        return "redirect:/factory_Management"; 
    }
}
