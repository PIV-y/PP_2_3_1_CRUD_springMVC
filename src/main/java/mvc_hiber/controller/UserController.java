package mvc_hiber.controller;

import mvc_hiber.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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