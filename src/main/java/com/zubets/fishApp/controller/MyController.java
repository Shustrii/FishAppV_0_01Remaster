package com.zubets.fishApp.controller;

import com.zubets.fishApp.Logs.Logger;
import com.zubets.fishApp.entity.FishClass;
import com.zubets.fishApp.service.FishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
    @RequestMapping("/saveFish")
    public String saveFish(@ModelAttribute("fishClass") FishClass fishClass
            ,@RequestParam("imageFile") MultipartFile imageFile){
        LogOut("!----"+getClass().getName()+"--- intro");
        LogOut("!----saveFish--- ");
        fishService.saveFish(fishClass);
        String returnValue = "";
        try {
            fishService.saveImage(imageFile);
            return "redirect:/";
        } catch (Exception e) {
            e.printStackTrace();

        }
        return returnValue;


    }

    @RequestMapping("/updateInfo")
    public  String updateFish(@RequestParam("fishId") int id, Model model) {
        FishClass fishClass = fishService.getFish(id);
        model.addAttribute("fishClass", fishClass);

//        if (!file.isEmpty()) {
//            try {
//                byte[] bytes = file.getBytes();
//                BufferedOutputStream stream =
//                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
//                stream.write(bytes);
//                stream.close();
//                System.out.println("Вы удачно загрузили " + name + " в " + name + "-uploaded !");
//            } catch (Exception e) {
//                System.out.println("Вам не удалось загрузить " + name + " => " + e.getMessage());
//            }
//        } else {
//            System.out.println("Вам не удалось загрузить " + name + " потому что файл пустой.");
//
//        }

        return"fish-info";

    }

    @RequestMapping("/deleteFish")
    public String deleteFish(@RequestParam("fishId") int id){
        fishService.deleteFish(id);
        return"redirect:/";
    }
    @RequestMapping("/description")
    public String description(@RequestParam("fishId") int id, Model model){
        FishClass fishClass = fishService.getFish(id);
        model.addAttribute("fishClass", fishClass);

        return "description-fish";
    }

    @RequestMapping("/uploadImage")
    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile){
        Logger.LogOut("==== uploadImage ===");
        String returnValue = "";
        try {
            fishService.saveImage(imageFile);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return returnValue;
    }
}
