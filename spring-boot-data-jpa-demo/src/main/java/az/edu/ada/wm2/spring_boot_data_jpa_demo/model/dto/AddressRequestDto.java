package az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AddressRequestDto {
    private String street;
    private String city;
    private String country;
}
