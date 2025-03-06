package com.example.demo_thymeleaf.controller;

import com.example.demo_thymeleaf.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    private List<Person> people = new ArrayList<>(List.of(
            new Person(1,"Nguyễn Văn A", "M", 20),
            new Person(1,"Nguyễn Văn B", "M", 23),
            new Person(1,"Lê Thị C", "F", 18),
            new Person(1,"Trần Văn D", "M", 25),
            new Person(1,"Phạm Thị E", "F", 21)
    ));
    @GetMapping("/") //http://localhost:8080
    public String getHome(Model model){

        http://localhost:8080
        model.addAttribute("people", people);
        model.addAttribute("person",people.get(0));
        model.addAttribute("name","Nguyễn Văn A");
        model.addAttribute("salary", 1000);
        return "index";
    }
}
