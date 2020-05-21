package ch.demowebflux.web.controllers;

import ch.demowebflux.model.entities.Employee;
import ch.demowebflux.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{id}")
    public Mono<Employee> getEmployeeById(@PathVariable(name = "id")String id){
        return employeeRepository
                .findEmployeeById(id);
    }

    @GetMapping("/all")
    public Flux<Employee> getAllEmployees(){
        return employeeRepository.findAllEmployees();
    }
}
