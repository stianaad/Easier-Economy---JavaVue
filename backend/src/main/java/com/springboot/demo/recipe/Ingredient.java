package com.springboot.demo.recipe;

public class Ingredient {
    private String ingredientName;
    private double ingredientValue;

    public Ingredient(){}

    public Ingredient(String ingredientName, double ingredientValue){
        this.ingredientName = ingredientName;
        this.ingredientValue = ingredientValue;
    }

    public double getIngredientValue() {
        return ingredientValue;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public void setIngredientValue(double ingredientValue) {
        this.ingredientValue = ingredientValue;
    }
}

