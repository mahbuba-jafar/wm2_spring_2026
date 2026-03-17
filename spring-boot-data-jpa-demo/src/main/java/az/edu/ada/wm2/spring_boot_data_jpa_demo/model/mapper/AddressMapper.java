package az.edu.ada.wm2.spring_boot_data_jpa_demo.model.mapper;

import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto.AddressRequestDto;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.AddressEntity;

public enum AddressMapper {
    INSTANCE;

    public AddressEntity addressRequestDtoToAddressEntity(AddressRequestDto addressRequestDto) {
        return AddressEntity.builder()
                .street(addressRequestDto.getStreet())
                .city(addressRequestDto.getCity())
                .country(addressRequestDto.getCountry())
                .build();
    }
}
