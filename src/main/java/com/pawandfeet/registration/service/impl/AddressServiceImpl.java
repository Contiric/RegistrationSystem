package com.pawandfeet.registration.service.impl;

import com.pawandfeet.registration.dto.AddressDTO;
import com.pawandfeet.registration.exception.AddressNotFoundException;
import com.pawandfeet.registration.repository.AddressRepository;
import com.pawandfeet.registration.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public Long createAddress(AddressDTO addressDTO) {
        Long addressId = addressRepository.save(addressDTO.toAddress()).getId();
        logger.info("Address created");
        return addressId;
    }

    @Override
    public AddressDTO updateAddress(Long addressId, AddressDTO addressDTO) throws AddressNotFoundException {
        addressRepository.findById(addressId).orElseThrow(AddressNotFoundException::new);
        return null;
    }

    @Override
    public void deleteAddress(Long addressId) {

    }

    @Override
    public AddressDTO findAddressById(Long addressId) {
        return null;
    }
}
