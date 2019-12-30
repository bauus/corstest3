package cn.wzvtc.soft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//@CrossOrigin
@CrossOrigin(origins = {"http://10.30.201.71:5500","http://10.30.201.75:5500",
        "http://10.30.201.74:5500","http://10.30.201.31:5500","http://127.0.0.1:5500"}
        )
@RestController("/")
public class TestController {
    @Autowired
    private LvliRepository lvliRepository;

    @RequestMapping(value = "/addlvli")
    public void addlvli(String lvli){
        Lvli lvli1=new Lvli("114514",lvli);
        this.lvliRepository.save(lvli1);
    }

    @RequestMapping(value = "/finall")
    public List<Lvli> getlvlilist(){
        return this.lvliRepository.findAll();
    }


    @RequestMapping(value = "/userinfo")
    public Map<String, String> userinfo(HttpServletRequest httpServletRequest) {
        Map<String, String> resultMap = new HashMap<>();
        if (httpServletRequest.getSession().getAttribute("loginnumber") != null) {
            resultMap.put("myname", (String) httpServletRequest.getSession(true).getAttribute("loginnumber"));
            resultMap.put("mynumber", (String) httpServletRequest.getSession(true).getAttribute("username"));
        }
        return resultMap;
    }


    @RequestMapping(value = "/login")
    public Map<String, String> login(@RequestBody Map<String, String> map, HttpServletRequest httpServletRequest) {
        String pwd = map.get("pwd");
        String name = map.get("name");
        Map<String, String> resultMap = new HashMap<>();
        if (name!=null && name.equals(pwd)) {
            httpServletRequest.getSession().setAttribute("loginnumber", name);
            httpServletRequest.getSession().setAttribute("username", name);
            resultMap.put("result", "success");
        }
        return resultMap;
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpSession httpSession) {
        httpSession.removeAttribute("loginnumber");
    }
}