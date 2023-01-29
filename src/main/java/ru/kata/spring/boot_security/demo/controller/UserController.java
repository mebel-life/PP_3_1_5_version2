package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    //	private final UserService userService;
//	public UserController(UserService userService) {
//		this.userService = userService;
//	}
//	@GetMapping(value = "/user")
//	public String userPage(Model model, @AuthenticationPrincipal User user) {
//		model.addAttribute("user", user);
//
//		return "/user";
//	}
    @GetMapping("/user")
    public ModelAndView userPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_info");
        return modelAndView;
    }
}