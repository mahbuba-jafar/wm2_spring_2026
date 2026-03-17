package az.edu.ada.wm2.spring_boot_data_jpa_demo.repository;

import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.DepartmentEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<@NonNull DepartmentEntity, @NonNull Long> {

    Optional<DepartmentEntity> findByNameIgnoreCase(String departmentName);

}
