package az.edu.ada.wm2.first_restful_app.repository;

import az.edu.ada.wm2.first_restful_app.model.Meal;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MealRepositoryImp2 implements MealRepository {
    private final List<Meal> meals = new ArrayList<>(
            List.of(
                    new Meal(3, "Plov", List.of("Rice", "Butter", "Chicken"), 14.50)
            )
    );

    @Override
    public List<Meal> findAll() {
        return meals;
    }

    @Override
    public Meal save(Meal meal) {
        if(meal == null) return null;

        meal.setCreatedAt(LocalDateTime.now());
        meals.add(meal);

        return meal;
    }
}
