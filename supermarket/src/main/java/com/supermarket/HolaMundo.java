package com.supermarket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/saludar")
public class HolaMundo {
    @GetMapping("hola")
    public String saludar() {
        return "Hola Mundo";
    }
}
