package az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate hireDate;
    private Double salary;
    private EmployeeDepartmentRequestDto departmentRequestDto;
    private AddressRequestDto addressRequestDto;
}
