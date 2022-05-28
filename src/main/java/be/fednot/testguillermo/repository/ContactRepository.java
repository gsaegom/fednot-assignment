package be.fednot.testguillermo.repository;

import be.fednot.testguillermo.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long> {
}
