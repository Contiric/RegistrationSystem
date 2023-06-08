package com.pawandfeet.registration.service;

import com.pawandfeet.registration.dto.AddressDTO;
import com.pawandfeet.registration.exception.AddressNotFoundException;

public interface AddressService {

    Long createAddress(AddressDTO addressDTO);

    AddressDTO updateAddress(Long addressId, AddressDTO addressDTO) throws AddressNotFoundException;

    void removeAddress(Long addressId);

    AddressDTO findAddressById(Long addressId);
}
