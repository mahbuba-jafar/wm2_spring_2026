package az.edu.ada.wm2.first_restful_app.model;

import java.time.LocalDateTime;
import java.util.List;

public class Meal {
    private int id;
    private String name;
    private List<String> ingredients;
    private Double price;
    private LocalDateTime createdAt;

    public Meal() {}

    public Meal(int id, String name, List<String> ingredients, Double price) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                ", price=" + price +
                ", createdAt=" + createdAt +
                '}';
    }
}
