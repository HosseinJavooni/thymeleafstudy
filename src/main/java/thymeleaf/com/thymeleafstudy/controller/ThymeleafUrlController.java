package thymeleaf.com.thymeleafstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import thymeleaf.com.thymeleafstudy.model.Address;
import thymeleaf.com.thymeleafstudy.model.Person;

@Controller
@RequestMapping("/thymeleafUrl")
public class ThymeleafUrlController {
    @GetMapping
    public String checkPersonUrlExpression(Model model){
        var address = new Address("WallStreet", "4589098");
        var person = new Person(3, "Mahan", "PesarBaba", address);
        model.addAttribute("person", person);
        return "URL_thymeleaf_check/url_thymeleafUrlExpression";
    }
    @GetMapping("/person")
    public String checkPersonUrlExpression_01(Model model){
        var address = new Address("Wall Street", "4589098");
        var person = new Person(3, "Mahan", "Azizbaba", address);
        model.addAttribute("person", person);
        model.addAttribute("url", "/thymeleafUrl/person");
        return "URL_thymeleaf_check/thymeleafUrlReturnPage";
    }

    @GetMapping("/person/{id}/{firstName}/{lastName}/{street}")
    public String checkPersonUrlExpression_02(Model model,
    @PathVariable String id, @PathVariable String firstName,
    @PathVariable String lastName, @PathVariable String street){
        var address = new Address(street, "---");
        var person = new Person(Integer.parseInt(id), firstName, lastName, address);
        model.addAttribute("person", person);
        model.addAttribute("url", "/thymeleafUrl/person/{id}/{firstName}/{lastName}/{street}");
        return "URL_thymeleaf_check/thymeleafUrlReturnPage";
    }

    @GetMapping("/person/pathParams")
    public String checkPersonUrlExpression_03(Model model,
                                              @RequestParam String id,
                                              @RequestParam String firstName,
                                              @RequestParam String lastName,
                                              @RequestParam String street){
        var address = new Address(street, "---");
        var person = new Person(Integer.parseInt(id), firstName, lastName, address);
        model.addAttribute("person", person);
        model.addAttribute("url", "/thymeleafUrl/person?id=**&firstName=**&lastName=**&street=**");
        return "URL_thymeleaf_check/thymeleafUrlReturnPage";
    }
}
