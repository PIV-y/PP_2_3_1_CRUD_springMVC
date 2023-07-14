package mvc_hiber.controller;

import mvc_hiber.model.User;
import mvc_hiber.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String printStart (ModelMap model) {
        model.addAttribute("messages", "HEllO");
        return "start";
    }
    @RequestMapping("/user_list")
    public String printUserList (ModelMap model) {
        model.addAttribute("user", userService.getAllUsers());
        return "users";
    }

    @RequestMapping("/user_info")
    public String addNewUserInfo (ModelMap model) {
        model.addAttribute("user", new User());
        System.out.println("форма открылась");
    return "user-info";
    }
    @PostMapping("/save_user")
    public String saveUser (@ModelAttribute("user") User user) {
        userService.saveUser(user);
        System.out.println("user added!!! "
                + user.getName() + user.toString());
        return "redirect:/user_list";
    }
    @RequestMapping("/delete_all_users")
    public String deleteAllUsers () {
        userService.dropUsersTable();
    return  "create-newtable";
    }

    @RequestMapping("/create_newtable")
    public String createNewTable () {
        userService.createUsersTable();
    return "redirect:/user_list";
    }
}