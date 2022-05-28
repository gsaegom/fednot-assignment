package be.fednot.testguillermo.repository;

import be.fednot.testguillermo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Integer> {
}
