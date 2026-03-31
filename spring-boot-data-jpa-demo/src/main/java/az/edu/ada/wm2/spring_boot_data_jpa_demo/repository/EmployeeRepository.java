package az.edu.ada.wm2.spring_boot_data_jpa_demo.repository;

import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.EmployeeEntity;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<@NonNull EmployeeEntity, @NonNull Long> {

    @Query("SELECT e FROM EmployeeEntity e WHERE e.lastName = :lastName")
    List<EmployeeEntity> findByLastName(@Param("lastName") String lastName);

    List<EmployeeEntity> findByLastNameContainingIgnoreCase(String lastName);

    @Query(value = """
            select * from employee1 where last_name like  concat('%', :lastName, '%')
            """,
            nativeQuery = true)
    List<EmployeeEntity> getEmployeeByLastName(String lastName);

    @Query("SELECT e FROM EmployeeEntity e WHERE e.address.city = :cityName")
    Page<EmployeeEntity> findByCity(@Param("cityName") String city, Pageable pageable);


    List<EmployeeEntity> findByFirstNameAndLastName(String firstName, String lastName);

}
