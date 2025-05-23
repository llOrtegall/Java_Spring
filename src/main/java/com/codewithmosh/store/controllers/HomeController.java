package com.codewithmosh.store.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class HomeController {
  // This method handles requests to the root URL ("/") and returns the "index" view.
  @RequestMapping("/")
  public String index(Model model) {
    model.addAttribute("name", "Ivan Ortega");

    return "index.html";
  }
}
