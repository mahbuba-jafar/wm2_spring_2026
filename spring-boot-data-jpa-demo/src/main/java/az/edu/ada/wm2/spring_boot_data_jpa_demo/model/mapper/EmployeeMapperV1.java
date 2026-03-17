package az.edu.ada.wm2.spring_boot_data_jpa_demo.model.mapper;

import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto.EmployeeResponseDto;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.EmployeeEntity;

public class EmployeeMapperV1 {

    public static EmployeeResponseDto employeeToEmployeeResponseDto(EmployeeEntity empEnt) {
        return EmployeeResponseDto.builder()
                .id(empEnt.getId())
                .email(empEnt.getEmail())
                .firstName(empEnt.getFirstName())
                .lastName(empEnt.getLastName())
                .hireDate(empEnt.getHireDate())
                .departmentName(empEnt.getDepartment() == null
                        ? null
                        : empEnt.getDepartment().getName())
                .build();
    }

}
