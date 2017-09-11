package tom.springboot.springbootwebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tom.springboot.springbootwebapp.domain.Product;

@Controller
public class IndexController {
    @RequestMapping("/")
    String index(){
        return "index";
    }
}
