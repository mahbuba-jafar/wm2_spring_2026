package az.edu.ada.wm2.first_spring_mvc.controller;

import az.edu.ada.wm2.first_spring_mvc.model.Customer;
import az.edu.ada.wm2.first_spring_mvc.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customers/form";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute Customer customer,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "customers/form";
        }
        service.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("customer", service.findById(id));
        return "customers/form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @Valid @ModelAttribute Customer customer,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "customers/form";
        }
        customer.setId(id);
        service.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/customers";
    }

//    Default list controller
//    @GetMapping
//    public String list(Model model) {
//        model.addAttribute("customers", service.findAll());
//        return "customers/list";
//    }

    @GetMapping
    public String list(@RequestParam(required = false) String keyword, Model model) {
        List<Customer> customers;

        if (keyword != null && !keyword.isEmpty()) {
            customers = service.searchByName(keyword);
            model.addAttribute("keyword", keyword);
        } else {
            customers = service.findAll();
        }

        model.addAttribute("customers", customers);
        return "customers/list";
    }
}
