package az.edu.ada.wm2.dependency_injection_example;

import az.edu.ada.wm2.dependency_injection_example.beans.Order;
import az.edu.ada.wm2.dependency_injection_example.beans.Person;
import az.edu.ada.wm2.dependency_injection_example.beans.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class DependencyInjectionExampleApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DependencyInjectionExampleApplication.class, args);

        System.out.println(context.getBean(Person.class));
        System.out.println(context.getBean(Product.class));

        System.out.println(context.getBean(Order.class));
    }

}
