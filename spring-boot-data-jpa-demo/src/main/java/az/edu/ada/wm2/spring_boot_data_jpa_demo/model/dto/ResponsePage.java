package az.edu.ada.wm2.spring_boot_data_jpa_demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

//TODO: complete the class and convert Page of dtos before returning from Controllers
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePage<T> {
    private List<T> content;
    private long totalElements;
    private long totalPages;
    private long numberOfElements;
    private long pageNo;

    public ResponsePage(Page<T> page) {
        this.content = page.getContent();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
        this.numberOfElements = page.getNumberOfElements();
        this.pageNo = page.getNumber();
    }

    public static <T> ResponsePage<T> from(Page<T> page) {
        return new ResponsePage<>(page);
    }

}
