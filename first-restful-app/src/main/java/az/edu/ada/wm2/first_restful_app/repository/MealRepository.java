package az.edu.ada.wm2.first_restful_app.repository;

import az.edu.ada.wm2.first_restful_app.model.Meal;

import java.util.List;

public interface MealRepository {

    List<Meal> findAll();

    Meal save(Meal meal);
}
