package com.projektjava.tablicaturniejowa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ApplicationControllers {

    /*@Autowired
    private UserRepository userRepo;*/

    UserJDBCDAO userRepo = new UserJDBCDAO();

    @RequestMapping("/")
    public String get(Model model) {
        model.addAttribute("name","Anonymous");
        TournamentJDBCDAO tournament = new TournamentJDBCDAO();
        TournamentBean alok= new TournamentBean();
        alok.setIdTournament(1);
        alok.setOpen(true);
        alok.setPlayers(4);
        tournament.add(alok);
        tournament.findAll();
        return "index";
    }
    @RequestMapping("/logowanie")
    public String loginPage(@RequestParam(required = false, name="user_name") String user_name, @RequestParam(required = false, name="password") String password, Model model) {
        User curr = userRepo.findlogin(user_name);
        if (curr.getpassword().equals(password)){
            if (curr.getadmin() == 1){
                model.addAttribute("administrator", curr);
                return "stronaadmina";
            }
            else{
                model.addAttribute("zawodnik", curr);
                return "stronazawodnika";
            }
        }
        else
            return "bladlogowania";
    }

    /*@GetMapping("/rejestracja")
    public String registerStart(Model model){
        model.addAttribute("user", new User());
        return "rejestracja";
    }*/

    @PostMapping("/rejestracja")
    public String registerPage(User user) {
        userRepo.add(user);
        return "index";
    }

    @GetMapping("/loginOrRegister")
    public String loginOrRegister(@RequestParam(value="action", required=true) String action, Model model) {
        if (action.equals("login")) {
            model.addAttribute("user", new User());
            return "logowanie";
        } else if (action.equals("register")) {
            model.addAttribute("user", new User());
            return "rejestracja";
        }
        return "loginOrRegister";
    }

    @GetMapping("/register")
    public String registerStart(Model model){
        model.addAttribute("user", new User());
        return "rejestracja";
    }

    @GetMapping("/login")
    public String loginStart(Model model){
        model.addAttribute("user", new User());
        return "logowanie";
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
