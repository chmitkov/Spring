package ch.demowebflux.web;

import ch.demowebflux.model.entities.Employee;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeWebClient {

    WebClient webClient = WebClient.create("http://localhost:8080");

    public void consume(){
        Mono<Employee> employeeMono = webClient
                .get()
                .uri("/employees/{id}", "1")
                .retrieve()
                .bodyToMono(Employee.class);

        employeeMono.subscribe(System.out::println);

        Flux<Employee> employeeFlux = webClient
                .get()
                .uri("/employees/all")
                .retrieve()
                .bodyToFlux(Employee.class);

        employeeFlux.subscribe(System.out::println);
    }
}
