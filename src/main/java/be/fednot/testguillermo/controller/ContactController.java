package be.fednot.testguillermo.controller;


import be.fednot.testguillermo.model.Company;
import be.fednot.testguillermo.model.Contact;
import be.fednot.testguillermo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;


    //TODO: Consider renaming methods
    @GetMapping
    public List<Contact> getContacts() {
        return contactService.getContacts();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Contact getContact(@PathVariable Long id) {
        //TODO:Think about the orElse
        return contactService.getContact(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.createContact(contact);
    }

    //TODO:Put some thought about how to do this.
//    @PutMapping
//    @RequestMapping("/{id}")
//    public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact) {
//
//    }

    @DeleteMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }

    @GetMapping
    @RequestMapping("/{id}/companies")
    public List<Company> getCompanies(@PathVariable Long id) {
        return contactService.getCompanies(id);
    }
}
