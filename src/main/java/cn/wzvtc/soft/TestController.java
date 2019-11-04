package cn.wzvtc.soft;

import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
//@CrossOrigin("*")
@CrossOrigin(origins = {"http://10.30.201.71:5500","http://10.30.201.75:5500",
        "http://10.30.201.74:5500","http://10.30.201.31:5500","http://127.0.0.1:5500"})
@RestController("/" )
public class TestController {

    @RequestMapping(value="data.json",method={RequestMethod.GET})
    public Map<String,String> bookById0(){
        Map<String,String> resultMap=new HashMap<>();
        resultMap.put("myname","苏威");
        resultMap.put("mynumber","18002090225");
        return resultMap;

    }
    @RequestMapping(value="data.json",method={RequestMethod.POST})
    public Map<String,String> bookById1(){
        Map<String,String> resultMap=new HashMap<>();
        resultMap.put("myname","XX");
        resultMap.put("mynumber","180020902XX");
        return resultMap;
    }
}