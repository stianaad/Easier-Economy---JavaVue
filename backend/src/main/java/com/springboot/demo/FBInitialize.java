package com.springboot.demo;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

@Service
@Component
public class FBInitialize {
    @Value("${service.account.path}")
    private String serviceAccountPath;

    @PostConstruct
    public void initialize() {
        try {

            /*FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(new ClassPathResource("./serviceaccount.json").getInputStream()))
                    .setDatabaseUrl("https://easiereconomy-default-rtdb.europe-west1.firebasedatabase.app")
                    .build();*/

            GoogleCredentials credentials = GoogleCredentials.fromStream(new ClassPathResource("./serviceaccount.json").getInputStream());
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .build();
            FirebaseApp.initializeApp(options);

            Firestore db = FirestoreClient.getFirestore();

            /*DocumentReference docRef = db.collection("users").document("alovelace");
// Add document data  with id "alovelace" using a hashmap
            Map<String, Object> data = new HashMap<>();
            data.put("first", "Ada");
            data.put("last", "Lovelace");
            data.put("born", 1815);
//asynchronously write data
            ApiFuture<WriteResult> result = docRef.set(data);
// ...
// result.get() blocks on response
            System.out.println("Update time : " + result.get().getUpdateTime());*/
            /*ApiFuture<QuerySnapshot> query = db.collection("users").get();
// ...
// query.get() blocks on response
            QuerySnapshot querySnapshot = query.get();
            List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                System.out.println("User: " + document.getId());
                System.out.println("First: " + document.getString("first"));
                if (document.contains("middle")) {
                    System.out.println("Middle: " + document.getString("middle"));
                }
                System.out.println("Last: " + document.getString("last"));
                System.out.println("Born: " + document.getLong("born"));
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}