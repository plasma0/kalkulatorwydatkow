package uek.kalkulator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import uek.dbmanager.DBManager;
import uek.pojo.DeviceUser;
import uek.pojo.Group;

import java.util.Iterator;
import java.util.List;

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
            List<DeviceUser> list = dbManager.getDevU(group.getName());
            String flows = "";
            int count = list.size();
            double sum = 0;
            for (Iterator iter = list.iterator();iter.hasNext();)
            {
                sum += ((DeviceUser)iter.next()).getContrib();
            }
            double mean = sum/count;
            for (int i = 0; i < count; i++) {
                flows += (list.get(i).getToken()+": -"+(list.get(i).getContrib()-mean)+"<br>");
            }
            modelMap.addAttribute("flows",flows);

        }
        return "table";
    }
}
