package az.edu.ada.wm2.first_restful_app.service;

import az.edu.ada.wm2.first_restful_app.model.Meal;
import az.edu.ada.wm2.first_restful_app.repository.MealRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealServiceImpl implements MealService{

    private final MealRepository mealRepo;

    public MealServiceImpl(MealRepository mealRepo) {
        this.mealRepo = mealRepo;
    }

    @Override
    public List<Meal> getMeals() {
        return mealRepo.findAll();
    }

    @Override
    public Meal create(Meal meal) {
        return mealRepo.save(meal);
    }
}
