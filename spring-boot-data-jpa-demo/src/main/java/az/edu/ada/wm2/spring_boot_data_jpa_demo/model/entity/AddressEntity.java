package az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tbl_address")
@Getter
@Setter
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String city;

    private String country;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private EmployeeEntity employee;
}
