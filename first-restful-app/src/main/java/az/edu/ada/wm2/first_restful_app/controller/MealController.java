package az.edu.ada.wm2.first_restful_app.controller;

import az.edu.ada.wm2.first_restful_app.model.Meal;
import az.edu.ada.wm2.first_restful_app.service.MealService;
import az.edu.ada.wm2.first_restful_app.service.MealServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping({"", "/"})
    public List<Meal> getAllMeals(){
        return mealService.getMeals();
    }

}
