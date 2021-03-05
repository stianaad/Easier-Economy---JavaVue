package com.springboot.demo.recipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200", "http://localhost:8081"})
@RestController
public class RecipeController {
    @Autowired
    RecipeService recipeService;
    private FirebaseStorageUploadImage firebaseStorageUploadImage;

    @GetMapping("/recipe/{id}")
    public Recipe getRecipe(@PathVariable String id) throws InterruptedException, ExecutionException{
        return recipeService.getRecipe(id);
    }

    @GetMapping("/allRecipe")
    public List<Recipe> getAllRecipes() throws InterruptedException, ExecutionException{
        return recipeService.getAllRecipes();
    }

    @PostMapping("/recipe")
    public String addRecipe(@RequestBody Recipe recipe) throws InterruptedException, ExecutionException{
        return recipeService.addRecipe(recipe);
    }

    @PutMapping("/recipe")
    public String updateRecipe(@RequestBody Recipe recipe) throws  InterruptedException, ExecutionException{
        return recipeService.updateRecipe(recipe);
    }
}
