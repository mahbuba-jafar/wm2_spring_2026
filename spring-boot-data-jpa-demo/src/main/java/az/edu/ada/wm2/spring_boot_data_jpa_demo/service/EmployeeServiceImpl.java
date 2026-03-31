package az.edu.ada.wm2.spring_boot_data_jpa_demo.service;

import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto.EmployeeDepartmentRequestDto;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto.EmployeeRequestDto;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto.EmployeeResponseDto;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.DepartmentEntity;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.EmployeeEntity;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.SkillEntity;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.mapper.AddressMapper;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.mapper.DepartmentMapper;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.mapper.EmployeeMapperV1;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.mapper.EmployeeMapperV2;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.repository.AddressRepository;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.repository.DepartmentRepository;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.repository.EmployeeRepository;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.repository.SkillRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final SkillRepository skillRepository;
    private final AddressRepository addressRepository;

    @Override
    public Page<@NonNull EmployeeResponseDto> getAllEmps(Pageable pageable) {
        var employeeEntitiesPage = employeeRepository.findAll(pageable);

//        var employeeResponseDtos = employeeEntities.stream().map(
////                empEnt -> EmployeeMapperV1.employeeToEmployeeResponseDto(empEnt)
////                EmployeeMapperV1::employeeToEmployeeResponseDto
//                EmployeeMapperV2.INSTANCE::employeeToEmployeeResponseDto
//        ).toList();
        return employeeEntitiesPage.map(
                EmployeeMapperV2.INSTANCE::employeeToEmployeeResponseDto
        );
    }

    @Override
    public EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto) {
        //Map and save the address request dto
        var addressEntity = AddressMapper.INSTANCE.addressRequestDtoToAddressEntity(
                employeeRequestDto.getAddressRequestDto()
        );
        var savedAddress = addressRepository.save(addressEntity);

        //Map and save the dept request dto
        DepartmentEntity departmentEntity = null;
        EmployeeDepartmentRequestDto departmentRequestDto = employeeRequestDto.getDepartmentRequestDto();
        if (departmentRequestDto.getId() != null) {
            // If ID provided, check if exists
            if (departmentRepository.existsById(departmentRequestDto.getId())) {
                // Fetch existing department
                departmentEntity = departmentRepository.findById(departmentRequestDto.getId())
                        .orElse(null);
            } else {
                // Create new department with the provided ID
                departmentEntity = departmentRepository.save(
                        DepartmentMapper.INSTANCE.employeeDepartmentDtoToDepartent(departmentRequestDto)
                );
            }
        } else {
            // No ID provided, create new department
            departmentEntity = departmentRepository.save(
                    DepartmentMapper.INSTANCE.employeeDepartmentDtoToDepartent(departmentRequestDto)
            );
        }

        // TODO: Handle Skills - Save skills FIRST, then set on employee

        // 3. Map Employee DTO to Entity and set the saved Address and Department
        var employeeEntity = EmployeeMapperV2.INSTANCE.employeeRequestDtoToEmployeeEntity(employeeRequestDto);

        // Override the mapped address and department with the saved ones
        employeeEntity.setAddress(savedAddress);
        employeeEntity.setDepartment(departmentEntity);

        var savedEmployee = employeeRepository.save(employeeEntity);

        return EmployeeMapperV2.INSTANCE.employeeToEmployeeResponseDto(savedEmployee);
    }

    @Override
    public EmployeeEntity getById(Long empId) {

        // Force initialization of lazy-loaded proxy
        // Hibernate.initialize(employee.getAddress());

        return employeeRepository.findById(empId).orElseThrow(
                () -> new IllegalArgumentException("Employee with id " + empId + " does not exist"));
    }

    public void deleteById(Long id) {
        if (!employeeRepository.existsById(id))
            throw new IllegalArgumentException("Employee with id " + id + " does not exist");

        employeeRepository.deleteById(id);
    }

    @Override
    @SneakyThrows
    public EmployeeEntity updateById(Long id, EmployeeEntity employeeUpdateRequestDto) throws Exception {
        var employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee with id " + id + " does not exist"));

        return employeeRepository.save(employee);
    }
}
