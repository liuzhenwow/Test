package com.liuzhen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class HelloWordController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello Word!";
    }

    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("user", new String[]{"zhangsan", "lisi","wangwu"});
        return "success";
    }
}
