package com.bl.test.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
public class LoginController {
    static String NAME_PATTERN = "[A-Z][A-Z a-z]{3,}";
    static String PASSWORD_PATTERN = "[0-9]{4,}";
    @RequestMapping("/")
    public String Home(){
        return "login";
    }

    @RequestMapping("/Login")
    public String display(HttpServletRequest req, Model model) {
        String name=req.getParameter("username");
        String password=req.getParameter("password");

        if (name.matches(NAME_PATTERN)&& password.matches(PASSWORD_PATTERN)){
            String msg="Hello"+ name;
            model.addAttribute("message", msg);
            return "view";
        }
        else {
            req.getServletContext().getRequestDispatcher("/Login.jsp");
            String message = "<h4  style=\"color:red\" align=\"center\">Either Username Or Password Is Wrong</h4>";
            req.setAttribute("message",message);
            return "login";
        }
    }
}