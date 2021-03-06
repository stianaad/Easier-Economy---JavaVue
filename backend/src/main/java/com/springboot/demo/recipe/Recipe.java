package com.springboot.demo.recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Recipe {
    private String name;
    private String description;
    private int minutes;
    private double rating;
    private String url;
    private String category;
    private int difficulty;
    private List<Ingredient> ingredients;
    private int portion;

    public Recipe(){}

    public Recipe(String name, String description, int minutes, String url, String category, int difficulty, List<Ingredient> ingredients, int portion){
        this.name = name;
        this.description = description;
        this.minutes = minutes;
        this.url = url;
        this.category = category;
        this.difficulty = difficulty;
        this.ingredients = ingredients;
        this.portion = portion;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description){this.description = description;}

    public double getRating() {
        return rating;
    }

    public void setRating(double rating){this.rating = rating;}

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes){this.minutes = minutes;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

