package uek.kalkulator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uek.dbmanager.DBManager;
import uek.pojo.DeviceUser;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/get_groups")
public class MobileGroupList {
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String getList(@RequestParam("token")String token, ModelMap modelMap)
    {
        DBManager dbManager = new DBManager();
        List<DeviceUser> list = dbManager.getByToken(token);
        String GROUPS = "";
        for(Iterator iter = list.iterator(); iter.hasNext();)
        {
            DeviceUser captured = (DeviceUser)iter.next();
            GROUPS += ( '\"' + captured.getGroupid() + '\"' );
            if(iter.hasNext())GROUPS += ',';
        }
        modelMap.addAttribute("groupList",GROUPS);
        return "groups";
    }
}
