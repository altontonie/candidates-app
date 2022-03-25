package thashort.gamer.cantidateapp.model.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class User {
    private long id;
    private String userId;
    private String mobileNumber;
    private String firstName;
    private String lastName;
    private String dob;
    private String description;
    private String country;
    private String city;
    private String zipCode;
    private String twitter;
    private String linkedIn;
    private String email;
    private String expectedSalary;
    private int yearsOfExperience;
    private Status status;
    private String dateCreated;
    private String dateModified;
}
