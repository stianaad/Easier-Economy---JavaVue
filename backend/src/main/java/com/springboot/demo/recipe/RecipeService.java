package com.springboot.demo.recipe;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class RecipeService {
    public static final String COL_NAME="recipes";

    public Recipe getRecipe(String id) throws InterruptedException, ExecutionException{
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference docref = dbFirestore.collection(COL_NAME).document(id);
        ApiFuture<DocumentSnapshot> future = docref.get();
        DocumentSnapshot document = future.get();

        Recipe recipe = null;
        if(document.exists()){
            recipe = document.toObject(Recipe.class);
            return recipe;
        } else {
            return null;
        }
    }

    public List<Recipe> getAllRecipes() throws InterruptedException, ExecutionException{
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> query = dbFirestore.collection(COL_NAME).get();
        QuerySnapshot querySnapshot = query.get();

        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        List<Recipe> recipies = new ArrayList<>();

        for(QueryDocumentSnapshot document : documents){
            recipies.add(document.toObject(Recipe.class));
        }
        return recipies;
    }

    public String addRecipe(Recipe recipe) throws InterruptedException, ExecutionException{
        UUID uuid = UUID.randomUUID();
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(uuid.toString()).set(recipe);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String updateRecipe(Recipe recipe) throws InterruptedException, ExecutionException{
        Firestore dbFirestore = FirestoreClient.getFirestore();                //Må fiksa dinna t uniq id seinare
        ApiFuture<WriteResult> wrriteResult = dbFirestore.collection(COL_NAME).document(recipe.getName()).set(recipe);
        return wrriteResult.get().getUpdateTime().toString();
    }
}
