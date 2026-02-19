package az.edu.ada.wm2.first_restful_app.controller;

import az.edu.ada.wm2.first_restful_app.model.Meal;
import az.edu.ada.wm2.first_restful_app.service.MealService;
import az.edu.ada.wm2.first_restful_app.service.MealServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {

//    @Autowired //field injection
    private final MealService mealService;

    @Value("${my.welcome.message}")
    private String welcomeMessage;

    @Autowired //constructor injection
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

//    @Autowired //setter injection
//    public void setMealService(MealService mealService) {
//        this.mealService=mealService;
//    }

    @GetMapping({"", "/"})
    public List<Meal> getAllMeals(){
        return mealService.getMeals();
    }


    @PostMapping
    public Meal createMeal(@RequestBody Meal meal){
        System.out.println(meal);
        return mealService.create(meal);
    }

    @GetMapping("/hi")
    public String sayHello(){
        return welcomeMessage;
    }

}
