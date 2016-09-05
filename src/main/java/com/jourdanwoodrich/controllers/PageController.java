package com.jourdanwoodrich.controllers;

import com.jourdanwoodrich.model.PartUpdate;
import com.jourdanwoodrich.service.PartUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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

    @RequestMapping(value = "/parts", method = RequestMethod.GET)
    ModelAndView viewParts(ModelAndView modelAndView, @RequestParam(name = "p", defaultValue = "1") int pageNumber){

        Page<PartUpdate> page = partUpdateService.getPage(pageNumber);
        modelAndView.getModel().put("page", page);

        modelAndView.setViewName("app.viewParts");
        return modelAndView;
    }

    @RequestMapping(value = "/addpart", method = RequestMethod.GET)
    ModelAndView addPart(ModelAndView modelAndView, @ModelAttribute("partUpdate") PartUpdate partUpdate){

        modelAndView.setViewName("app.addPart");


        PartUpdate latestPartUpdate = partUpdateService.getLatest();

        modelAndView.getModel().put("latestPartUpdate", latestPartUpdate);

        return modelAndView;
    }
    @RequestMapping(value = "/addpart", method = RequestMethod.POST)
    ModelAndView addPart(ModelAndView modelAndView, @Valid PartUpdate partUpdate, BindingResult result){

        modelAndView.setViewName("app.addPart");

        if (!result.hasErrors()){
            partUpdateService.save(partUpdate);
            modelAndView.getModel().put("partUpdate", new PartUpdate());
        }


        PartUpdate latestPartUpdate = partUpdateService.getLatest();
        modelAndView.getModel().put("latestPartUpdate", latestPartUpdate);

        return modelAndView;
    }
}
