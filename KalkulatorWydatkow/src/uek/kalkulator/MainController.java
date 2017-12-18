package uek.kalkulator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController {
    @RequestMapping(method = RequestMethod.GET)
    public String printPage(ModelMap modelMap)
    {
        modelMap.addAttribute("title","Kalkulator wydatków");
        modelMap.addAttribute("add","Załóż grupę rozliczeniową");
        modelMap.addAttribute("login","Zaloguj się do grupy");
        return "index";
    }
}
