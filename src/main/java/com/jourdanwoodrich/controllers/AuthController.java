package com.jourdanwoodrich.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jourdanwoodrich on 9/4/16.
 */


@Controller
public class AuthController {

    @RequestMapping("/admin")
    String admin(){
        return "admin";
    }
}
