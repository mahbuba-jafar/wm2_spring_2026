package az.edu.ada.wm2.spring_boot_data_jpa_demo.service;


import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto.EmployeeRequestDto;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto.EmployeeResponseDto;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.EmployeeEntity;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.repository.EmployeeRepository;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDto> getAllEmps();

    EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto);

    EmployeeEntity getById(Long empId);

    void deleteById(Long id);

    EmployeeEntity updateById(Long id, EmployeeEntity employeeEntity) throws Exception;

}
