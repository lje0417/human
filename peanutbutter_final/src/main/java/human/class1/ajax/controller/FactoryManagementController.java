package human.class1.ajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import human.class1.ajax.dao.FmDAO;
import human.class1.ajax.dto.FmDTO;

import java.util.List;

@Controller
public class FactoryManagementController {

    @Autowired
    private FmDAO fmDAO;

    @GetMapping("/factory_Management")
    public String getProcesses(Model model) {
        List<FmDTO> processList = fmDAO.getProcesses();
        model.addAttribute("processList", processList);
        return "factory";  
    }
    
}