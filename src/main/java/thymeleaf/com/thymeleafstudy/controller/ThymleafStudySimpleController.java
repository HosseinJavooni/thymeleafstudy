package thymeleaf.com.thymeleafstudy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import thymeleaf.com.thymeleafstudy.model.Address;
import thymeleaf.com.thymeleafstudy.model.Person;

@Controller
public class ThymleafStudySimpleController{
    @GetMapping
    public String returnModel(Model model){
        var persons = new ArrayList<Person>();
        var address = new Address("zarrin ghobaie", "123");
        persons.add(new Person(1, "Hossein", "Jabani", address));

        model.addAttribute("person", new Person(2, "Mahan", "Jabani", address));
        model.addAttribute("Hi", "Hi Thymeleaf World!");
        return "index";
    }
}