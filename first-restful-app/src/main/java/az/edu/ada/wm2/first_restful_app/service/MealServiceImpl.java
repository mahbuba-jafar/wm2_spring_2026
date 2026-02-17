package az.edu.ada.wm2.first_restful_app.service;

import az.edu.ada.wm2.first_restful_app.model.Meal;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealServiceImpl implements MealService{

    List<Meal> meals = new ArrayList<>(
            List.of(
                    new Meal(1,"TomYam", List.of("Shrimp", "Mushroom"), 10.0),
                    new Meal(2,"UchBaci", List.of("Tomato", "Pepper", "Meat"), 18.50),
                    new Meal(3,"Plov", List.of("Rice", "Butter", "Chicken"), 14.50)
            )
    );

    @Override
    public List<Meal> getMeals() {
        return meals;
    }
}
