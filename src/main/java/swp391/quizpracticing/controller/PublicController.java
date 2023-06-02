package swp391.quizpracticing.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class PublicController {
    @GetMapping("")
    public String getHome(){
        return "index.html";
    }
}
