package mvc_hiber.controller;

import mvc_hiber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String printStart (ModelMap model) {
        userService.createUsersTable();
        model.addAttribute("messages", "Приветствие");
        return "start";
    }
    @GetMapping("/user_list")
    public String printUserList (ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

//    @GetMapping("/SaveUser")
//    public String SaveUser (ModelMap model) {
//        model.addAttribute("",userService.saveUser());
//    }
}