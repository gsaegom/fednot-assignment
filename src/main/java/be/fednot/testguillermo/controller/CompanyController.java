package be.fednot.testguillermo.controller;

import be.fednot.testguillermo.model.Address;
import be.fednot.testguillermo.model.Company;
import be.fednot.testguillermo.model.Contact;
import be.fednot.testguillermo.repository.CompanyRepository;
import be.fednot.testguillermo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;


    @GetMapping
    public List<Company> getCompanies(@RequestParam(value = "isDeleted", required = false, defaultValue = "false") boolean isDeleted) {
        return companyService.findAll(isDeleted);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Company getCompany(@PathVariable Long id) {
        return companyService.findCompany(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company createCompany(@RequestBody Company contact) {
        return companyService.createCompany(contact);
    }

    @PutMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Company updateCompany(@PathVariable Long id, @RequestBody Company company) {
        return companyService.updateCompany(id, company);
    }

    @DeleteMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
    }

    @PutMapping
    @RequestMapping(value = "/{id}/address/{addressId}", method = RequestMethod.PUT)
    public Company addAddress(@PathVariable Long id, @PathVariable Long addressId) {
        return companyService.addAddress(id, addressId);
    }

    @PutMapping
    @RequestMapping(value = "/{id}/address/{addressId}", method = RequestMethod.DELETE)
    public Company deleteAddress(@PathVariable Long id, @PathVariable Long addressId) {
        return companyService.deleteAddress(id, addressId);
    }

    @PutMapping
    @RequestMapping(value = "/{id}/main-address/{addressId}", method = RequestMethod.PUT)
    public Company setAsMainAddress(@PathVariable Long id, @PathVariable Long addressId) {
        return companyService.setAsMainAddress(id, addressId);
    }

    @GetMapping
    @RequestMapping(value = "/{id}/contacts")
    public List<Contact> getContacts(@PathVariable Long id) {
        return companyService.getContacts(id);
    }
}
