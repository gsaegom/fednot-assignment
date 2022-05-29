package be.fednot.testguillermo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.List;

//TODO: Use Lombok?
@Entity(name = "CONTACTS")
@SQLDelete(sql = "UPDATE CONTACTS SET deleted = true WHERE id=?")
@FilterDef(name = "deletedContactFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))
@Filter(name = "deletedContactFilter", condition = "deleted = :isDeleted")
public class Contact {
    //TODO: Figure out @GeneratedValue
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private FullName fullName;
    @Embedded
    private Email email;
    @Embedded
    private PhoneNumber phoneNumber;
    @ManyToMany
    @JoinTable(
            name = "CONTACTS_COMPANIES",
            joinColumns = @JoinColumn(name = "CONTACTS_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "COMPANIES_ID", referencedColumnName = "ID"))
    private List<Company> companies;
    //TODO: Multiple people could have the same address. Many to one?
    @OneToOne
    private Address address;

    @JsonIgnore
    private boolean deleted = Boolean.FALSE;

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

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
