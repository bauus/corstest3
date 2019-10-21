package cn.wzvtc.soft;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController("/" )
public class TestController {

    @RequestMapping(value="data0.json",method={RequestMethod.GET})
    public Map<String,String> bookById0(){
        Map<String,String> resultMap=new HashMap<>();
        resultMap.put("myname","苏威");
        resultMap.put("mynumber","18002090225");
        return resultMap;
    }
    @RequestMapping(value="data1.json",method={RequestMethod.GET})
    public Map<String,String> bookById1(){
        Map<String,String> resultMap=new HashMap<>();
        resultMap.put("myname","XX");
        resultMap.put("mynumber","180020902XX");
        return resultMap;
    }
}