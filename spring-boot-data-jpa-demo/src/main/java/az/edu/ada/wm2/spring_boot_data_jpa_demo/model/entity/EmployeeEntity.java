package az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

@Entity
@Table(name = "tbl_employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @Column(name = "maas")
    private Double salary;
    private LocalDate hireDate;

    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    // remove the property from the resulting JSON due to lazy loading
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private AddressEntity address;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    // remove the property from the resulting JSON due to lazy loading
//    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private DepartmentEntity department;

    @ManyToMany
    @JsonIgnore
    @Builder.Default
    @JoinTable(name = "skills_employees",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<SkillEntity> skills = new HashSet<>();
}
