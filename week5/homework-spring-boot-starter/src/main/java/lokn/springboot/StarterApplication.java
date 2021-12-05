package lokn.springboot;

import lokn.springboot.starter.bean.Klass;
import lokn.springboot.starter.bean.School;
import lokn.springboot.starter.bean.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.awt.image.Kernel;

@SpringBootApplication
public class StarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }

    @Resource
    Student student;

    @Resource
    School school;

    @Resource
    Klass klass;

    @Bean
    public void print() {
        student.print();
        System.out.println("-----------------");
        school.ding();
        System.out.println("-----------------");
        klass.dong();
        System.out.println("----------------");
    }

}
