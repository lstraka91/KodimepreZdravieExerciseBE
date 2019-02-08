package sk.strakaLukas.zadanie.kodimeprezdravie.kodimePrezdravie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends RuntimeException{

    private int id;

    public PatientNotFoundException(int id){
        super("Patient with id "+id + " not found");
    }
}
