package az.edu.ada.wm2.spring_boot_data_jpa_demo.controller;

import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto.EmployeeRequestDto;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto.EmployeeResponseDto;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.model.entity.EmployeeEntity;
import az.edu.ada.wm2.spring_boot_data_jpa_demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {

    final EmployeeService employeeService;

    @PostMapping
    public EmployeeResponseDto saveEmployee(
            @RequestBody EmployeeRequestDto employeeSaveRequestDto) {
        return employeeService.save(employeeSaveRequestDto);
    }

    //    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @GetMapping
    public List<EmployeeResponseDto> listAll() {
        return employeeService.getAllEmps();
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
}
