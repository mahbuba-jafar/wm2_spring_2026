package az.edu.ada.wm2.first_spring_mvc.repository;

import az.edu.ada.wm2.first_spring_mvc.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    Customer save(Customer customer);

    Optional<Customer> findById(Long id);

    List<Customer> findAll();

    void deleteById(Long id);

    List<Customer> searchByName(String keyword);

}
