package az.edu.ada.wm2.dependency_injection_example.config;

import az.edu.ada.wm2.dependency_injection_example.beans.Person;
import az.edu.ada.wm2.dependency_injection_example.beans.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public Person personBean() {
        Person person = new Person();
        person.setId("PER001");
        person.setFirstName("John");
        person.setLastName("Doe");
        return person;
    }

    @Bean
    public Product productBean() {
        return new Product("P001","Laptop", 1200.0);
    }
}
