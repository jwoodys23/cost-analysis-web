package com.jourdanwoodrich.controllers;

import com.jourdanwoodrich.model.PartUpdate;
import com.jourdanwoodrich.service.PartUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by jourdanwoodrich on 9/4/16.
 */

@Controller
public class PageController {

    @Autowired
    private PartUpdateService partUpdateService;

    @RequestMapping("/")
    String home(){
        return "app.homepage";
    }

    @RequestMapping("/about")
    String about(){
        return "app.about";
    }

    @RequestMapping(value = "/addpart", method = RequestMethod.GET)
    ModelAndView addPart(ModelAndView modelAndView){

        modelAndView.setViewName("app.addPart");

        PartUpdate partUpdate = new PartUpdate();

        modelAndView.getModel().put("partUpdate", partUpdate);

        return modelAndView;
    }
    @RequestMapping(value = "/addpart", method = RequestMethod.POST)
    ModelAndView addPart(ModelAndView modelAndView, PartUpdate partUpdate){

        modelAndView.setViewName("app.addPart");

        partUpdateService.save(partUpdate);

//        modelAndView.getModel().put("partUpdate", partUpdate);

        return modelAndView;
    }
}
