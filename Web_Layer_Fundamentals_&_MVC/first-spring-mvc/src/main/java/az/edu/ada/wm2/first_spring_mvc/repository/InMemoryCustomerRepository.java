package az.edu.ada.wm2.first_spring_mvc.repository;

import az.edu.ada.wm2.first_spring_mvc.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {
    private final Map<Long, Customer> customers = new HashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(customers.get(id));
    }

    public Customer save(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(idGenerator.getAndIncrement());
        }
        customers.put(customer.getId(), customer);
        return customer;
    }

    public void deleteById(Long id) {
        customers.remove(id);
    }

    @Override
    public List<Customer> searchByName(String keyword) {
        return customers.values().stream()
                .filter(
                        customer -> customer.getName().toLowerCase()
                                .contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}