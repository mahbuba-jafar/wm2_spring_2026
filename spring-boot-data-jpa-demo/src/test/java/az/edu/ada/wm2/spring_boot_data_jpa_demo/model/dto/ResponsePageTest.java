package az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto;

import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResponsePageTest {

    @Test
    void shouldCreateResponsePageFromSpringDataPage() {
        var employees = List.of(
                EmployeeResponseDto.builder().id(1L).firstName("Ada").lastName("Lovelace").build(),
                EmployeeResponseDto.builder().id(2L).firstName("Grace").lastName("Hopper").build()
        );
        var page = new PageImpl<>(employees, PageRequest.of(1, 2), 5);

        var responsePage = ResponsePage.from(page);

        assertEquals(employees, responsePage.getContent());
        assertEquals(5, responsePage.getTotalElements());
        assertEquals(3, responsePage.getTotalPages());
        assertEquals(2, responsePage.getNumberOfElements());
        assertEquals(1, responsePage.getPageNo());
    }
}

