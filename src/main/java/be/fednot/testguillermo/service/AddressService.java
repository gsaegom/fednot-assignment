package be.fednot.testguillermo.service;

import be.fednot.testguillermo.model.Address;
import be.fednot.testguillermo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address findAddress(Long id) {
        return addressRepository.findById(id).orElse(null);
    }
}
