package az.edu.ada.wm2.spring_boot_data_jpa_demo.repository;

import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.AddressEntity;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<@NonNull AddressEntity, @NonNull Long> {
}
