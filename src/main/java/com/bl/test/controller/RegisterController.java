package com.bl.test.controller;
import com.bl.test.dao.RegisterDao;
import com.bl.test.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

    @RequestMapping("/register")
    public ModelAndView registrationPage(){
        return new ModelAndView("register");
    }

    @RequestMapping("/Register")
    public String save(HttpServletRequest request, Model model){
        RegisterDao registerDao=new RegisterDao();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String confirmPass = request.getParameter("confirmPass");

        Registration registration=new Registration();
        registration.setUsername(name);
        registration.setEmail(email);
        registration.setPassword(pass);
        registration.setConfirmPass(confirmPass);

        int Status=registerDao.dataSave(registration);
        if (Status==1){
            String msg="Registration Successful";
            model.addAttribute("message",msg);
            return "login";
        }
        else {
            String msg="Registration Unsuccessful";
            model.addAttribute("message",msg);
            return "register";
        }
    }
}
