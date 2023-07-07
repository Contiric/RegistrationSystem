package com.pawandfeet.registration.service;

import com.pawandfeet.registration.dto.AddressDTO;
import com.pawandfeet.registration.entity.Address;
import com.pawandfeet.registration.repository.AddressRepository;
import com.pawandfeet.registration.service.impl.AddressServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    @Spy
    @InjectMocks
    private AddressServiceImpl addressService;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private Address address;
    @Mock
    private AddressDTO addressDTO;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        address = Address.builder().id(1L).street("Actor Vale").city("Lisboa").state("LIS").country("Portugal").personId(1L).build();
        addressDTO = AddressDTO.builder().street("Avenida Lúcio Costa").city("Rio de Janeiro").state("RJ").country("Brasil").personId(1L).build();
    }
    @Test
    public void createAddress() {
        when(addressRepository.save(Mockito.any(Address.class))).thenReturn(address);

        Long address1 = addressService.createAddress(addressDTO);

        Assertions.assertNotNull(address1);
    }
    @Test
    public void findAddressById() {
        when(addressRepository.findById(1L)).thenReturn(Optional.ofNullable(address));

        AddressDTO addressById = addressService.findAddressById(1L);

        verify(addressRepository, times(1)).findById(1L);

        Assertions.assertNotNull(addressById);
    }
    @Test
    public void updateAddress() {
        when(addressRepository.findById(1L)).thenReturn(Optional.ofNullable(address));
        when(addressRepository.save(Mockito.any(Address.class))).thenReturn(address);

        AddressDTO addressUpdated = addressService.updateAddress(1L, addressDTO);

        Assertions.assertNotNull(addressUpdated);
    }
    @Test
    public void deleteDog() {
        when(addressRepository.findById(1L)).thenReturn(Optional.ofNullable(address));
        doNothing().when(addressRepository).delete(address);

        Assertions.assertAll(() -> addressService.deleteAddress(1L));
    }
}


