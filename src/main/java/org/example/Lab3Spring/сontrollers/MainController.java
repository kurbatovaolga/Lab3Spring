package org.example.Lab3Spring.сontrollers;


import org.example.Lab3Spring.entity.User;
import org.example.Lab3Spring.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;


@Controller
@RequestMapping("/")
public class MainController {

        private final EmployeeRepo employeeRepo;

        @Autowired
        public MainController(EmployeeRepo employeeRepo) {
            this.employeeRepo = employeeRepo;
        }
    @GetMapping
    public String main (Model model,@AuthenticationPrincipal User user) {

        HashMap<Object, Object> data = new HashMap<>();

        data.put("profile",user);
        data.put("employees",employeeRepo.findAll());
        model.addAttribute("frontendData", data);

        return "index";
    }
}
