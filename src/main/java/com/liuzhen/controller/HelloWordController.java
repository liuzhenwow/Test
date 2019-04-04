package com.liuzhen.controller;

import com.liuzhen.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class HelloWordController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        throw new UserNotExistException();
//        return "Hello Word!";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("user", new String[]{"zhangsan", "lisi","wangwu"});
        return "success";
    }
}
