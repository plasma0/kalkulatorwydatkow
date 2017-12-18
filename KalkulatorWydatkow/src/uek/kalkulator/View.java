package uek.kalkulator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import uek.dbmanager.DBManager;
import uek.pojo.Group;

@Controller
public class View {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String calculateFlows(ModelMap modelMap)
    {
        modelMap.addAttribute("command", new Group());
        return "login";
    }
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String checkFlows(@ModelAttribute("SpringWeb")Group group, ModelMap modelMap)
    {
        DBManager dbManager = new DBManager();
        Group acquired = dbManager.getGroup(group.getName());
        if(acquired.getPassword()==group.getPassword())
        {
            
        }

    }
}
