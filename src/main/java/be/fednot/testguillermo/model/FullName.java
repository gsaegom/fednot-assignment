package be.fednot.testguillermo.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FullName {

    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;

    public FullName() {
    }

    public FullName(String firstName, String lastName) {
        Validation.checkThat(firstName != null && !firstName.isBlank(), "first name must not be null or blank");
        Validation.checkThat(lastName != null && !lastName.isBlank(), "last name must not be null or blank");
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
