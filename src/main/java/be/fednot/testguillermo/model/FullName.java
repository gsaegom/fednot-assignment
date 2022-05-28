package be.fednot.testguillermo.model;

import javax.persistence.Embeddable;

@Embeddable
public class FullName {

    private String firstName;
    private String lastName;

    public FullName(String firstName, String lastName) {
        Validation.checkThat(firstName != null && !firstName.isBlank(), "first name must not be null or blank");
        Validation.checkThat(lastName != null && !lastName.isBlank(), "last name must not be null or blank");
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
