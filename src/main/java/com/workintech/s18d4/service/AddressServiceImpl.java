package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.repository.AddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;


    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findById(Long id) {
        Optional<Address> foundAddress = addressRepository.findById(id);
        // simplify to single expression functional style
        if(foundAddress.isPresent()) {
            return foundAddress.get();
        }
        return null;
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address delete(Long id) {
        Optional<Address> foundAddress = addressRepository.findById(id);
        if(foundAddress.isEmpty()) {
            return null;
        }
        addressRepository.delete(foundAddress.get());
        return foundAddress.get();
    }
}
