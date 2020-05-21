package ch.demowebflux.repository;

import ch.demowebflux.model.entities.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

//Hard coded :)
@Repository
    public class EmployeeRepository {

        static Map<String,Employee> employeeData;

        static
        {
            employeeData = new HashMap<>();
            employeeData.put("1",new Employee(1L,"Gosho"));
            employeeData.put("2",new Employee(2L,"Pesho"));
            employeeData.put("3",new Employee(3L,"Nasko"));

        }

        public Mono<Employee> findEmployeeById(String id)
        {
            return Mono.just(employeeData.get(id));
        }

        public Flux<Employee> findAllEmployees()
        {
            return Flux.fromIterable(employeeData.values());
        }
}

