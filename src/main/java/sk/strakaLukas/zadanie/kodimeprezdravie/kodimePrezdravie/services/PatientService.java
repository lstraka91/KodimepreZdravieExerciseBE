package sk.strakaLukas.zadanie.kodimeprezdravie.kodimePrezdravie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.strakaLukas.zadanie.kodimeprezdravie.kodimePrezdravie.entity.Patient;
import sk.strakaLukas.zadanie.kodimeprezdravie.kodimePrezdravie.repository.PatientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
       return patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientByID(int id){
        return patientRepository.findById(id);
    }

    public Patient updatePatient(Patient patient){
        return patientRepository.save(patient);
    }

    public void deletePatientByID(int id){
        patientRepository.deleteById(id);
    }

}
