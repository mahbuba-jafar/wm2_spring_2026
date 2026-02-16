package az.edu.ada.wm2.first_spring_app_ever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirstSpringAppEverApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringAppEverApplication.class, args);
	}

//    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    @GetMapping("/sayHello")
    public String sayHelloToMyLittleFriend() {
        return "Hello World!";
    }

}
