package com.liuzhen.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@Slf4j
public class LoginController {
    @PostMapping(value="/user/login")
    public String login(@RequestParam("username") String username ,
                        @RequestParam("password") String password,
                        Map<String,Object> map,
                        HttpServletRequest request){
        HttpSession session = request.getSession();
        if (!StringUtils.isEmpty(username)&&!StringUtils.isEmpty(password)){
            log.info("login in seccess!");
            session.setAttribute("loguser",username);
            return "redirect:/main.html";
        }else {
            log.info("login in false!");
            map.put("msg","userName or passWord is null");
            return "login";
        }


    }
}
