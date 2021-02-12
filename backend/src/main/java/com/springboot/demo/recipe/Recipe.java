package com.springboot.demo.recipe;

public class Recipe {

    private String name;
    private String description;
    private int minutes;
    private int price;
    private double rating;

    public Recipe(String name, String description, int minutes, int price){
        this.name = name;
        this.description = description;
        this.minutes = minutes;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price){this.price = price;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

