package az.edu.ada.wm2.spring_boot_data_jpa_demo.service;

import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.DepartmentEntity;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.EmployeeEntity;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.SkillEntity;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.repository.DepartmentRepository;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.repository.EmployeeRepository;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.Hibernate;
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

    @Override
    public List<EmployeeEntity> getAllEmps() {
        return employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity save(EmployeeEntity employeeEntity) {
        // Handle Department - save if new, or fetch existing
        if (employeeEntity.getDepartment() != null) {
            DepartmentEntity dept = employeeEntity.getDepartment();
            final DepartmentEntity departmentToSave = dept;

            if (dept.getId() == null) {
                // Check if department with same name exists
                Optional<DepartmentEntity> existingDept = departmentRepository
                        .findByNameIgnoreCase(dept.getName());
                dept = existingDept.orElseGet(() -> departmentRepository.save(departmentToSave));
            } else {
                dept = departmentRepository.findById(dept.getId())
                        .orElseThrow(() -> new RuntimeException("Department not found"));
            }
            employeeEntity.setDepartment(dept);
        }

        // Handle Address (cascade saves automatically with CascadeType.ALL)
        if (employeeEntity.getAddress() != null) {
            employeeEntity.getAddress().setEmployee(employeeEntity);
        }

        // TODO: Handle Skills - Save skills FIRST, then set on employee
//        employeeEntity.getSkills().stream()
//                .map(SkillEntity::getName)
//                .forEach(System.out::println);

        return employeeRepository.save(employeeEntity);

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
