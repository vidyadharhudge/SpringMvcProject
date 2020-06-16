package com.bl.test.controller;
import com.bl.test.dao.RegisterDao;
import com.bl.test.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RegisterController {
    static String NAME_PATTERN = "[A-Z][A-Z a-z]{3,}";
    static String EMAIL_PATTERN = "^[a-zA-Z0-9]{3,}+[@][a-zA-Z0-9]{3,}+[.][a-zA-Z]{3,}$";
    static String PASSWORD_PATTERN = "[0-9]{4,}";

    @RequestMapping("/register")
    public ModelAndView registrationPage() {
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/Register", method = RequestMethod.GET)
    public String saveRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegisterDao registerDao = new RegisterDao();

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String confirmPass = request.getParameter("confirmPass");

        Registration registration = new Registration();
        registration.setUsername(name);
        registration.setEmail(email);
        registration.setPassword(pass);
        registration.setConfirmPass(confirmPass);

        if (name.matches(NAME_PATTERN) && email.matches(EMAIL_PATTERN) && pass.matches(PASSWORD_PATTERN) && pass.equals(confirmPass)) {
            int Status = registerDao.dataSave(registration);
            if (Status == 1) {
                request.getServletContext().getRequestDispatcher("/login.jsp");
                String message = "<h4  style=\"color:green\" align=\"center\">Registration Is Successful</h4>";
                request.setAttribute("message", message);
                return "login";
            }
        } else {
            request.getServletContext().getRequestDispatcher("/register.jsp");
            String message = "<h4  style=\"color:red\" align=\"center\">Registration Is Unsuccessful</h4>";
            request.setAttribute("message", message);
            return "register";
        }
        return "register";
    }
}