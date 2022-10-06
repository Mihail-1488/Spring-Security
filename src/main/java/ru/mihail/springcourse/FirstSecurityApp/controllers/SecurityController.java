package ru.mihail.springcourse.FirstSecurityApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.mihail.springcourse.FirstSecurityApp.security.PersonDetails;
import ru.mihail.springcourse.FirstSecurityApp.services.AdminServices;

@Controller
public class SecurityController {
    private final AdminServices adminServices;

    @Autowired
    public SecurityController(AdminServices adminServices) {
        this.adminServices = adminServices;
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/showUserInfo")
    public String shoUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails)authentication.getPrincipal();
        System.out.println(personDetails.getPerson());
        return "hello";
    }
    @GetMapping("/admin")
    public String adminPage(){
        adminServices.doAdminStuff();
        return "admin";
    }
    
}
