package az.edu.ada.wm2.first_restful_app.service;

import az.edu.ada.wm2.first_restful_app.model.Meal;

import java.util.List;

public interface MealService {
    List<Meal> getMeals();

    Meal create(Meal meal);
}
