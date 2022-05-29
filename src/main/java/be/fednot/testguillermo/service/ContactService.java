package be.fednot.testguillermo.service;

import be.fednot.testguillermo.model.Company;
import be.fednot.testguillermo.model.Contact;
import be.fednot.testguillermo.repository.ContactRepository;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.lang.invoke.MethodType;
import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private EntityManager entityManager;


    //TODO: Consider renaming methods
    public List<Contact> getContacts(boolean isDeleted) {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedContactFilter");
        filter.setParameter("isDeleted", isDeleted);
        List<Contact> contacts = contactRepository.findAll();
        session.disableFilter("deletedContactFilter");
        return contacts;
    }


    public Contact getContact(Long id) {
        //TODO:Think about the orElse
        return contactRepository.findById(id).orElse(null);
    }

    public Contact createContact(Contact contact) {
        return contactRepository.saveAndFlush(contact);
    }

    //TODO:Put some thought about how to do this.
//    @PutMapping
//    @RequestMapping("/{id}")
//    public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact) {
//
//    }
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    public List<Company> getCompanies(Long id) {
        return getContact(id).getCompanies();
    }
}
