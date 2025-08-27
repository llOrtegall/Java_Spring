package com.platzi.platzi_play.web.controller;

import com.platzi.platzi_play.domain.service.PPAIService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final PPAIService ppaiService;

    public HelloController(PPAIService ppaiService) {
        this.ppaiService = ppaiService;
    }

    @GetMapping("/hello")
    public String hello(){
        return this.ppaiService.generateString();
    }
}
