package sk.strakaLukas.zadanie.kodimeprezdravie.kodimePrezdravie.entity;

import javax.persistence.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String firstName;
    private String lastName;
    private String address;
    private String identificationNumber;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Patient() {

    }

    public Patient(String firstName, String lastName, String title, String address, String identificationNumber, Status status, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.address = address;
        this.identificationNumber = identificationNumber;
        this.status = status;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public String getTitle() {
        return title;
    }

    public Status getStatus() {
        return status;
    }

    public Gender getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }
}
