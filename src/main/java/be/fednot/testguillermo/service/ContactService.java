package be.fednot.testguillermo.service;

import be.fednot.testguillermo.model.Company;
import be.fednot.testguillermo.model.Contact;
import be.fednot.testguillermo.repository.ContactRepository;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private EntityManager entityManager;


    //TODO: Consider renaming methods
    public List<Contact> findAll(boolean isDeleted) {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedContactFilter");
        filter.setParameter("isDeleted", isDeleted);
        List<Contact> contacts = contactRepository.findAll();
        session.disableFilter("deletedContactFilter");
        return contacts;
    }


    public Contact getContact(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public Contact createContact(Contact contact) {
        return contactRepository.saveAndFlush(contact);
    }

    public Contact updateContact(Long id, Contact newContact) {
        contactRepository.findById(id).ifPresent(contact -> {
            contact.setFullName(newContact.getFullName());
            contact.setPhoneNumber(newContact.getPhoneNumber());
            contact.setEmail(newContact.getEmail());
            contact.setAddress(newContact.getAddress());
            contact.setCompanies(newContact.getCompanies());
        });
        return contactRepository.saveAndFlush(contactRepository.findById(id).get());
    }
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

    public List<Company> getCompanies(Long id) {
        return getContact(id).getCompanies();
    }
}
