package com.richard.api.ws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author richard
 */
@Controller
public class HomeController {
 
    @RequestMapping("/")   
    public String index() {
        return "index";
    }
}
