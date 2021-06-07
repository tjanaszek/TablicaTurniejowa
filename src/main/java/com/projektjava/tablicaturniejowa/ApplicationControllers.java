package com.projektjava.tablicaturniejowa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApplicationControllers {

    @RequestMapping("/")
    public String get(Model model) {
        model.addAttribute("name","Anonymous");
        return "index";
    }
    @RequestMapping("/logowanie")
    public String loginPage() {
        return "logowanie";
    }
    @RequestMapping("/rejestracja")
    public String registerPage() {
        return "rejestracja";
    }

    @RequestMapping("/loginOrRegister")
    public String loginOrRegister(@RequestParam(value="action", required=true) String action) {
        if (action.equals("login")) {
            return "redirect:/logowanie";
        } else if (action.equals("register")) {
            return "redirect:/rejestracja";
        }
        return "loginOrRegister";
    }
    //akcja do przycisku "Zaloguj"
//    @RequestMapping("/login")
//    public String login(@RequestParam(value="action", required=true) String action) {
//        if (action.equals("login")) {
//            return "redirect:/logowanie";
//        } else if (action.equals("register")) {
//            return "redirect:/rejestracja";
//        }
//        return "login";
//    }

    //akcja do przycisku "Zarejestruj się"
//    @RequestMapping("/login")
//    public String login(@RequestParam(value="action", required=true) String action) {
//        if (action.equals("login")) {
//            return "redirect:/logowanie";
//        } else if (action.equals("register")) {
//            return "redirect:/rejestracja";
//        }
//        return "login";
//    }

}
