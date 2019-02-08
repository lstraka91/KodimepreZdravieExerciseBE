package sk.strakaLukas.zadanie.kodimeprezdravie.kodimePrezdravie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.strakaLukas.zadanie.kodimeprezdravie.kodimePrezdravie.entity.Patient;
import sk.strakaLukas.zadanie.kodimeprezdravie.kodimePrezdravie.exceptions.PatientNotFoundException;
import sk.strakaLukas.zadanie.kodimeprezdravie.kodimePrezdravie.services.PatientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class PatientController {

    @Autowired
    private PatientService service;


    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return service.getAllPatients();
    }

    @GetMapping("/patient/{id}")
    public Patient getPatientByID(@PathVariable(name = "id") Integer id) {
        Optional<Patient> patient = service.getPatientByID(id);
        if (!patient.isPresent()) throw new PatientNotFoundException(id);
        return patient.get();
    }

    @PostMapping("/patient")
    public Patient savePatient(@RequestBody Patient patient) {
        return service.createPatient(patient);
    }

    @PostMapping("/patientsAdd")
    public void savePatient(@RequestBody Patient[] patients) {
        for (Patient patient : patients) {
            service.createPatient(patient);
        }
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<Object> updatePatient(@RequestBody Patient patient, @PathVariable int id) {
        Optional<Patient> optionalPatient = service.getPatientByID(id);
        if (!optionalPatient.isPresent())
            return ResponseEntity.notFound().build();
        patient.setId(id);
        service.updatePatient(patient);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable int id) {
        Optional<Patient> optionalPatient = service.getPatientByID(id);
        if (!optionalPatient.isPresent())
            return ResponseEntity.notFound().build();

        service.deletePatientByID(id);
        return ResponseEntity.ok().build();
    }
}
