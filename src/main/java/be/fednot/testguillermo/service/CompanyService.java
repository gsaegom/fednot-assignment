package be.fednot.testguillermo.service;

import be.fednot.testguillermo.model.Address;
import be.fednot.testguillermo.model.Company;
import be.fednot.testguillermo.model.Contact;
import be.fednot.testguillermo.repository.CompanyRepository;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private AddressService addressService;
    @Autowired
    private EntityManager entityManager;


    public List<Company> findAll(boolean isDeleted) {
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedCompanyFilter");
        filter.setParameter("isDeleted", isDeleted);
        List<Company> companies = companyRepository.findAll();
        session.disableFilter("deletedCompanyFilter");
        return companies;
    }

    public Company findCompany(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public Company createCompany(Company contact) {
        return companyRepository.saveAndFlush(contact);
    }

    public Company updateCompany(Long id, Company newCompany) {
        companyRepository.findById(id).ifPresent(company -> {
            company.setName(newCompany.getName());
            company.setContacts(newCompany.getContacts());
            company.setVatNumber(newCompany.getVatNumber());
            company.setAddress(newCompany.getAddress());
            company.setAddresses(newCompany.getAddresses());
        });
        return companyRepository.saveAndFlush(companyRepository.findById(id).get());
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public Company addAddress(Long id, Long addressId) {
        companyRepository.findById(id).ifPresent(company -> company.getAddresses().add(addressService.findAddress(addressId)));
        return companyRepository.saveAndFlush(companyRepository.findById(id).get());
    }

    public Company deleteAddress(Long id, Long addressId) {
        companyRepository.findById(id).ifPresent(company -> company.getAddresses().remove(addressService.findAddress(addressId)));
        return companyRepository.saveAndFlush(companyRepository.findById(id).get());
    }

    public Company setAsMainAddress(Long id, Long addressId) {
        Address mainAddress = addressService.findAddress(addressId);
        companyRepository.findById(id).ifPresent(company -> {
            company.getAddresses().remove(mainAddress);
            company.setAddress(mainAddress);
        });

        return companyRepository.saveAndFlush(companyRepository.findById(id).get());
    }

    public List<Contact> getContacts(Long id) {
        return findCompany(id).getContacts();
    }

}
