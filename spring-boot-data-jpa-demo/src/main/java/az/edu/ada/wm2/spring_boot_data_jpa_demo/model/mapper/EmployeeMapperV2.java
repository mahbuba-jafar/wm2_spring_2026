package az.edu.ada.wm2.spring_boot_data_jpa_demo.model.mapper;

import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto.EmployeeRequestDto;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto.EmployeeResponseDto;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.EmployeeEntity;

public enum EmployeeMapperV2 {
    INSTANCE;

    public EmployeeResponseDto employeeToEmployeeResponseDto(EmployeeEntity empEnt) {
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

    public EmployeeEntity employeeRequestDtoToEmployeeEntity(EmployeeRequestDto employeeRequestDto) {
        return EmployeeEntity.builder()
                .firstName(employeeRequestDto.getFirstName())
                .lastName(employeeRequestDto.getLastName())
                .email(employeeRequestDto.getEmail())
                .hireDate(employeeRequestDto.getHireDate())
                .salary(employeeRequestDto.getSalary())
                .address(AddressMapper.INSTANCE.addressRequestDtoToAddressEntity(employeeRequestDto.getAddressRequestDto()))
                .department(DepartmentMapper.INSTANCE.employeeDepartmentDtoToDepartent(employeeRequestDto.getDepartmentRequestDto()))
                .build();
    }
}
