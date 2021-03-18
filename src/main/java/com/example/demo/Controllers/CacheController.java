package com.example.demo.Controllers;

import com.example.demo.MyCache;
import com.example.demo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CacheController {
    MyCache userCache = new MyCache();
    @GetMapping("/get-user-data")
    @ResponseBody
    public String renderCache(@RequestParam int id) throws InterruptedException {

        if(userCache.has(id)==true){
            return userCache.get(id);
        }
        else if(userCache.has(id)==false){
            User user = new User(id);
            String s = user.getDataSlow();
            userCache.set(id,s);
            return s;
        }
        return "/get-user-data";
    }
}