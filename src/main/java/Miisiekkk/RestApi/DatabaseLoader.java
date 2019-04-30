package Miisiekkk.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseLoader implements CommandLineRunner {

    private final EmployeeRepository repository;

    @Autowired
    public DatabaseLoader(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {

        this.repository.save(new Employee("Frodo", "Wagins", "tuman"));
        this.repository.save(new Employee("DilDo", "Swaggins", "cham"));
        this.repository.save(new Employee("Grzegorz", "Duszyk", "cymbał"));

    }
}
