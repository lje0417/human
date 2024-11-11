package human.class1.ajax.controller;

import human.class1.ajax.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductMapper productMapper;

    @GetMapping("/list")
    public String getProductCodes(Model model) {
        List<String> productCodes = productMapper.getProductCodes(); 
        model.addAttribute("productCodes", productCodes);
        return "factoryReg"; 
    }
}
