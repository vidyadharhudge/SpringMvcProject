package com.bl.test.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String Home(){
        return "login";
    }

    @RequestMapping("/Login")
    public String display(HttpServletRequest req, Model model)
    {
        String name=req.getParameter("username");
        String password=req.getParameter("password");

         if(password.equals("Dhiraj")) {
            String msg="Hello"+ name;

            model.addAttribute("message", msg);
            return "view";

        } else {
            String msg="Sorry "+ name+". You entered an incorrect password";
            model.addAttribute("message", msg);
            return "error";
        }
    }
}