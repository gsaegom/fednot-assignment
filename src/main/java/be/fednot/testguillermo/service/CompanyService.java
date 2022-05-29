package be.fednot.testguillermo.service;

import be.fednot.testguillermo.model.Address;
import be.fednot.testguillermo.model.Company;
import be.fednot.testguillermo.model.Contact;
import be.fednot.testguillermo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private AddressService addressService;


    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    public Company findCompany(Long id) {
        //TODO:Think about the orElse
        return companyRepository.findById(id).orElse(null);
    }

    public Company createCompany(Company contact) {
        return companyRepository.saveAndFlush(contact);
    }

    //TODO:Put some thought about how to do this.
//    public Company updateCompany(@PathVariable Long id, @RequestBody Company contact) {
//
//    }
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    //TODO:Refactor these two methods
    //TODO:Consider use address id instead of object
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
    //TODO: Remove companies from contact. DTO?
    public List<Contact> getContacts(Long id){
        return findCompany(id).getContacts();
    }
}
