package az.edu.ada.wm2.spring_boot_data_jpa_demo.config;

import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.AddressEntity;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.DepartmentEntity;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.EmployeeEntity;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.repository.DepartmentRepository;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataBootstrapper {

    @Bean
    public CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        return args -> {
            System.out.println("Hello from command line runner");

            var employeeToBeSaved = EmployeeEntity.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .email("john.doe@gmail.com")
                    .salary(1245.0)
                    .hireDate(LocalDate.of(2015, 1, 1))
                    .department(
                            DepartmentEntity.builder()
                                    .name("BAPA")
                                    .build()
                    )
                    .address(
                            AddressEntity.builder()
                                    .street("123 Main St")
                                    .city("Berlin")
                                    .country("Germany")
                                    .build()
                    )
                    .build();

            System.out.println(employeeRepository.save(employeeToBeSaved));
        };
    }

}
