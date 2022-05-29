package be.fednot.testguillermo.repository;

import be.fednot.testguillermo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
