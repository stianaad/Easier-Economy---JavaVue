package com.springboot.demo.recipe;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200", "http://localhost:8081"})
@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/getPatientDetails/{name}")
    public Patient getPatient(@PathVariable String name) throws InterruptedException, ExecutionException{//@RequestParam String name
        return patientService.getPatientDetails(name);
    }

    @GetMapping("/getAllPatients")
    public Patient getAllPatients() throws InterruptedException, ExecutionException {
        return patientService.getAllPatients();
    }

    @PostMapping("/createPatient")
    public String createPatient(@RequestBody Patient patient ) throws InterruptedException, ExecutionException {
        return patientService.savePatientDetails(patient);
    }

    @PutMapping("/updatePatient")
    public String updatePatient(@RequestBody Patient patient  ) throws InterruptedException, ExecutionException {
        return patientService.updatePatientDetails(patient);
    }

    @DeleteMapping("/deletePatient")
    public String deletePatient(@RequestParam String name){
        return patientService.deletePatient(name);
    }
}
