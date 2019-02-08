package sk.strakaLukas.zadanie.kodimeprezdravie.kodimePrezdravie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.strakaLukas.zadanie.kodimeprezdravie.kodimePrezdravie.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
