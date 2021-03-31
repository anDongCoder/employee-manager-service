package cn.employee.manager;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableSwagger2Doc
@SpringBootApplication
@ComponentScan("cn.employee")
public class EmployeeManagerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagerServiceApplication.class, args);
    }

}
