package Miisiekkk.RestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


@Component
public class DatabaseLoader implements CommandLineRunner {

    private final EmployeeRepository employees;
    private final ManagerRepository managers;

    @Autowired
    public DatabaseLoader(EmployeeRepository employeeRepository,
                          ManagerRepository managerRepository) {

        this.employees = employeeRepository;
        this.managers = managerRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        Manager tomek = this.managers.save(new Manager("tom", "tom"));


        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken("tom", "tom"));

        this.employees.save(new Employee("Mateusz", "Woźniak", "Pracownik"));
        this.employees.save(new Employee("Tomasz", "Jabłoński", "Pracownik"));
        this.employees.save(new Employee("Janusz", "Brzyszczyk", "Pracownik"));
        this.employees.save(new Employee("Andrzej", "Duszyk", "Pracownik"));
        this.employees.save(new Employee("Marcin", "Jastrzębski", "Recepcjonista"));
        this.employees.save(new Employee("Grzegorz", "Musiał", "Recepcjonista"));
        this.employees.save(new Employee("Maciej", "Oliwa", "Ogrodnik"));

        SecurityContextHolder.clearContext();
    }
}
