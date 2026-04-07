package az.edu.ada.wm2.spring_boot_data_jpa_demo.controller;

import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto.EmployeeRequestDto;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto.EmployeeResponseDto;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto.ResponsePage;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.EmployeeEntity;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.mapper.EmployeeMapperV2;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.repository.EmployeeRepository;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.service.EmployeeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    @PostMapping
    public EmployeeResponseDto saveEmployee(
            @RequestBody EmployeeRequestDto employeeSaveRequestDto) {
        return employeeService.save(employeeSaveRequestDto);
    }

    //    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @GetMapping
    public ResponsePage<EmployeeResponseDto> listAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "5") int limit,
            @RequestParam(defaultValue = "firstName") String sortBy
    ) {
        Pageable pageable = PageRequest.of(pageNo, limit,
                Sort.by(Sort.Direction.ASC, sortBy)
        );

        return ResponsePage.from(employeeService.getAllEmps(pageable));
    }

    @GetMapping("/{id}")
    public EmployeeEntity getEmployee(@PathVariable("id") Long empId) {
        return employeeService.getById(empId);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@RequestBody EmployeeEntity employeeEntity,
                               @PathVariable Long id) throws Exception {
        employeeService.updateById(id, employeeEntity);
    }

    //NOTE: This is the incomplete version, for demo purposes
    @GetMapping("/byCity")
    public ResponsePage<EmployeeResponseDto> findByCity(
            @RequestParam("city") String cityName,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "2") int limit,
            @RequestParam(defaultValue = "firstName") String sortBy) {

        Pageable pageable = PageRequest.of(pageNo, limit,
                Sort.by(Sort.Direction.ASC, sortBy)
        );

        var employeePage = employeeRepository.findByCity(cityName, pageable)
                .map(EmployeeMapperV2.INSTANCE::employeeToEmployeeResponseDto);

        return ResponsePage.from(employeePage);
    }
}
