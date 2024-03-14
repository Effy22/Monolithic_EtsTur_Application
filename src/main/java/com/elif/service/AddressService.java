package com.elif.service;

import com.elif.domain.Address;
import com.elif.dto.request.AddressSaveRequestDto;
import com.elif.exception.ErrorType;
import com.elif.exception.OtelException;
import com.elif.repository.AddressRepository;
import com.elif.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService extends ServiceManager<Address,String> {
    private final AddressRepository addressRepository;
    public AddressService(AddressRepository addressRepository) {
        super(addressRepository);
        this.addressRepository = addressRepository;

    }

    public Address save(AddressSaveRequestDto dto) {
        Optional<Address> addressOptional = addressRepository.findByStreetNumberAndDistrict(dto.getStreetNumber(),dto.getDistrict());
        if(addressOptional.isPresent()){
            throw new OtelException(ErrorType.ADDRESS_ALREADY_EXIST);
        }

        Address address = Address.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .district(dto.getDistrict())
                .streetNumber(dto.getStreetNumber())
                .zipCode(dto.getZipCode())
                .build();

        return addressRepository.save(address);
    }


    public List<Address> findByNameContainingIgnoreCase(String search) {
        return addressRepository.findByNameContainingIgnoreCase(search);
    }


    public List<Address> findByNameContainingIgnoreCaseOrStreetNumberContainingIgnoreCase(String search) {
        return addressRepository.findByNameContainingIgnoreCaseOrStreetNumberContainingIgnoreCase(search,search);
    }
}
