package thashort.gamer.candidateapp.model.entity;

import lombok.Data;

@Data
public class Candidate {
    private String userId;
    private String mobileNumber;
    private String firstName;
    private String lastName;
    private String dob;
    private String jobTitle;
    private String country;
    private String city;
    private String zipCode;
    private String twitter;
    private String linkedIn;
    private String email;
    private String skills;
    private String expectedSalary;
    private int yearsOfExperience;
    private String status;
    private String dateCreated;
    private String dateModified;
    private String description;
}
