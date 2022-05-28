package be.fednot.testguillermo.model;

import javax.persistence.*;
import java.util.List;

//TODO: Use Lombok?
@Entity(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private FullName fullName;
    @Embedded
    private Email email;
    @Embedded
    private PhoneNumber phoneNumber;
    @OneToMany
    private List<Company> companies;

    public Contact() {
    }

    public Long getId() {
        return id;
    }


    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
    public List<Company> getCompanies() {
        return companies;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
