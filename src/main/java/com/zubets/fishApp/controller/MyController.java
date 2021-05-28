package com.zubets.fishApp.controller;

import com.zubets.fishApp.entity.FishClass;
import com.zubets.fishApp.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.zubets.fishApp.Logs.Logger.LogOut;

@Controller
public class MyController {

    @Autowired
    private FishService fishService;

    @RequestMapping("/")
    public String showAllFish(Model model){
        LogOut("!----"+getClass().getName()+"--- intro");
        List<FishClass> allFish = fishService.getAllFish();
        model.addAttribute("allFishes", allFish);
        return "all-fish";
    }

    @RequestMapping("/addNewFish")
    public  String addNewFish(Model model){
        FishClass fishClass = new FishClass();
        model.addAttribute("fishClass", fishClass);
        return "fish-info";
    }
    @RequestMapping("saveFish")
    public String saveFish(@ModelAttribute("fishClass") FishClass fishClass){
        fishService.saveFish(fishClass);
            return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateFish(@RequestParam("fishId") int id, Model model){
        FishClass fishClass = fishService.getFish(id);
        model.addAttribute("fishClass",fishClass);

        return"fish-info";
    }

    @RequestMapping("/deleteFish")
    public String deleteFish(@RequestParam("fishId") int id){
        fishService.deleteFish(id);
        return"redirect:/";
    }

}
