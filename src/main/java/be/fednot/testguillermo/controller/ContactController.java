package be.fednot.testguillermo.controller;


import be.fednot.testguillermo.model.Contact;
import be.fednot.testguillermo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/contacts")
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;


    //TODO: Consider renaming methods
    @GetMapping
    public List<Contact> getContacts() {
        return contactRepository.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Contact getContact(@PathVariable Long id) {
        return contactRepository.getReferenceById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contact createContact(@RequestBody Contact contact) {
        return contactRepository.saveAndFlush(contact);
    }

//    @PutMapping
//    @RequestMapping("/{id}")
//    public Contact updateContact(@PathVariable Long id, @RequestBody Contact contact) {
//        return contactRepository.f
//    }

    @DeleteMapping
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void deleteContact(@PathVariable Long id) {
        contactRepository.deleteById(id);
    }
}
