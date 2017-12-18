package uek.kalkulator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uek.dbmanager.DBManager;
import uek.pojo.DeviceUser;
import uek.pojo.Group;

@Controller
@RequestMapping("/android_login")
public class MobileController {
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String processRequest(@RequestParam("alogin")String alogin, @RequestParam("apass")String apass, ModelMap modelMap, @RequestParam("token")String token)
    {
        DBManager dbManager = new DBManager();
        Group group = dbManager.getGroup(alogin);
        if(group==null)
        {
            modelMap.addAttribute("isProccessSucceded","false");
        }
        else
        {
            if(group.getPassword().equals(apass))
            {
                DeviceUser deviceUser = new DeviceUser(token,alogin,0);
                if(dbManager.addObject(deviceUser))modelMap.addAttribute("isEverythingSucceded", "true");
                else modelMap.addAttribute("isEverythingSucceded","false");
            }
            else
            {
                modelMap.addAttribute("isPasswordCorrect","false");
            }
        }
        return "status";
    }
}
