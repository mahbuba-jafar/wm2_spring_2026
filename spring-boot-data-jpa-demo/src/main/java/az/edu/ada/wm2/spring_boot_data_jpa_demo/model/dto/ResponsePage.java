package az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto;

import java.util.List;

//TODO: complete the class and convert Page of dtos before returning from Controllers
public class ResponsePage<T> {
    private List<T> content;
    private long totalElements;
    private long totalPages;
    private long numberOfElements;
    private long pageNo;
}
