package az.edu.ada.wm2.spring_boot_data_jpa_demo.repository;

import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.SkillEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<@NonNull SkillEntity, @NonNull Long> {

    Optional<SkillEntity> findByNameIgnoreCase(String skillName);

}
