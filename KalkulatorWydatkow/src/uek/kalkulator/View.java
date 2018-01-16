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
        if(acquired.getPassword().equals(group.getPassword()))
        {
            DBManager dbManager1 = new DBManager();
            String flows = "";
            List<DeviceUser> members = dbManager1.getMembersOf(group);
            if(members==null)modelMap.addAttribute("flows","Błąd odczytu lub grupa jest pusta");
            else
            {
                double mean = 0;
                int memLength = members.size();
                for (int i = 0; i < memLength; i++) {
                    mean += members.get(i).getContrib();
                }
                mean = mean / memLength;
                MeanCalculator mc = new MeanCalculator(mean);
                for (int i = 0; i < memLength; i++) {
                    flows += ("<br>" + members.get(i).getToken() + ": " + mc.mountChain(members.get(i).getContrib()));
                }
                modelMap.addAttribute("flows",flows);
            }
        }
        else modelMap.addAttribute("flows","Login i hasło nie pasują do siebie");
        return "table";
    }
}
