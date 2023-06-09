package com.pawandfeet.registration.service;

import com.pawandfeet.registration.dto.AddressDTO;
import com.pawandfeet.registration.exception.AddressNotFoundException;

import java.util.logging.Logger;

public interface AddressService {

    Logger logger = Logger.getLogger(String.valueOf(AddressService.class));

    Long createAddress(AddressDTO addressDTO);

    AddressDTO updateAddress(Long addressId, AddressDTO addressDTO) throws AddressNotFoundException;

    void deleteAddress(Long addressId);

    AddressDTO findAddressById(Long addressId);
}
