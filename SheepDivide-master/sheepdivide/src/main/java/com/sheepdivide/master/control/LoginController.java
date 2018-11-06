package com.sheepdivide.master.control;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.unbescape.html.HtmlEscape;

@Controller
public class LoginController { //MainController i guide.

//    @RequestMapping("/")
//    public String root(Locale locale) {
//        return "redirect:/shared/index.html";
//    }

    @RequestMapping("/index.html") //.html
    public String index() {
        return "index";
    }

    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("/user/home.html")
    public String home(){
        return "user/home";
    }

    @RequestMapping("/newlogin.html")
    public String newLogin(){
        return "newlogin";
    }

//    /** Login form with error. */
//    @RequestMapping("/login-error.html")
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login";
//    }

//    /** Error page. */
//    @RequestMapping("/403.html")
//    public String forbidden() {
//        return "403";
//    }
}

