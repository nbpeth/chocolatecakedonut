package com.chocolatecakedonut.home.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
class HomeController {

    @GetMapping("/")
    def index(){
        return new ModelAndView("index")
    }

}
