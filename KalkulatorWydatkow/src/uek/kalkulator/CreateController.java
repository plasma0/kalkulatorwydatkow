package uek.kalkulator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import uek.pojo.Group;
import uek.dbmanager.*;

@Controller
public class CreateController {
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String create(ModelMap modelMap)
    {
        modelMap.addAttribute("command",new Group());
        return "create";
    }
    @RequestMapping(value = "/createDB", method = RequestMethod.POST)
    public String createDB(@ModelAttribute("SpringWeb")Group group, ModelMap modelMap)
    {
        DBManager dbManager = new DBManager();
        boolean isOK = dbManager.addObject(group);
        String OK;
        if(isOK)OK="true";else OK="false";
        modelMap.addAttribute("gname",group.getName());
        modelMap.addAttribute("gpass",group.getPassword());
        modelMap.addAttribute("isSucceded",OK);
        return "createConfirm";
    }
}
