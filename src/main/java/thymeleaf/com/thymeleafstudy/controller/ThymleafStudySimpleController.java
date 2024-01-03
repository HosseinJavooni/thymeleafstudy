package thymeleaf.com.thymeleafstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import thymeleaf.com.thymeleafstudy.model.Address;
import thymeleaf.com.thymeleafstudy.model.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymleafStudySimpleController{
    @GetMapping
    public String homePage(){
        return "homePage";
    }
    @GetMapping("/person-thymeleaf-variable-expression")
    public String returnModel(Model model){
        var address = new Address("zarrin ghobaie", "123");
        model.addAttribute("person", new Person(2, "Mahan", "Jabani", address));
        return "person_thymeleafVariableExpression";
    }
    @GetMapping("/simpleAttribute-thymeleaf-simple-expression")
    public String returnSimpleAttribute(Model model){
        model.addAttribute("Hi", "Hi Thymeleaf World!");
        return "simpleAttribute_thymeleafSimpleExpression";
    }
    @GetMapping("/person-thymeleaf-object-expression")
    public String returnPersonObject(Model model){
        var address = new Address("zarrin ghobaie", "123");
        model.addAttribute("person", new Person(2, "Mahan", "Jabani", address));
        return "person_thymeleafObjectExpression";
    }
    @GetMapping("/messages-thymeleaf-message-expression")
    public String returnMessages(){
        return "messages_thymeleafMessageExpression";
    }
    @GetMapping("/url-thymeleaf-url-expression")
    public String returnUrl(){
        return "URL_thymeleaf_check/url_thymeleafUrlExpression";
    }

    @GetMapping("/person-thymeleaf-conditional-expression")
    public String returnPersonForConditional(Model model, @RequestParam int id,
                                             @RequestParam String firstName,
                                             @RequestParam String lastName,
                                             @RequestParam String street,
                                             @RequestParam String zipCode){
        var address = new Address(street, zipCode);
        var person = new Person(id, firstName, lastName, address);
        model.addAttribute("person", person);
        return "person_thymeleafConditionalExpression";
    }
    @GetMapping("/person-thymeleaf-iteration-expression/{count}")
    public String returnPeople(@PathVariable String count, Model model){
        List<Person> personList = new ArrayList<>();
        Person person;
        for(int i=0; i<=Integer.parseInt(count); i++){
            person = new Person(i, "firstName-"+i, "lastName-"+i, null);
            personList.add(person);
        }
        model.addAttribute("personList", personList);
        return "person_thymeleafIterationExpression";
    }
}