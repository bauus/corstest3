package cn.wzvtc.soft;

import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
//@CrossOrigin
@CrossOrigin(origins = {"http://10.30.201.71:5500","http://10.30.201.75:5500",
        "http://10.30.201.74:5500","http://10.30.201.31:5500","http://127.0.0.1:5500"}
        )
@RestController("/")
public class TestController {

    @RequestMapping(value="/userinfo")
    public Map<String,String> userinfo(HttpSession httpSession){
        Map<String,String> resultMap=new HashMap<>();
        if(httpSession.getAttribute("loginname")!=null){
                resultMap.put("myname","苏威");
                resultMap.put("mynumber","18002090225");
        }
        return resultMap;

    }


    @RequestMapping(value="/login")
    public Map<String,String> login(@RequestBody Map<String,String> map, HttpSession httpSession){
        String pwd=map.get("pwd");
        String name=map.get("name");

        Map<String,String> resultMap=new HashMap<>();
        if("18002090225".equals(name) && "18002090225".equals(pwd)) {
            httpSession.setAttribute("loginname",name);
            resultMap.put("result","success");
        }
        return resultMap;
    }
}