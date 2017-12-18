package uek.kalkulator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uek.dbmanager.DBManager;

@Controller
@RequestMapping("/add_contrib")
public class AddContrib {
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String addContrib(@RequestParam("token")String token, @RequestParam("group")String group, @RequestParam("contrib") Double contrib, ModelMap modelMap)
    {
        DBManager dbManager = new DBManager();
        boolean isOK = dbManager.updateContribution(token,group,contrib);
        String OK = isOK?"true":"false";
        modelMap.addAttribute("isOK",isOK);
        return "added";
    }

}
