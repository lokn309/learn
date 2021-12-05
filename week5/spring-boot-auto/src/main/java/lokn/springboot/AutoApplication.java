package lokn.springboot;

import lokn.springboot.auto.Klass;
import lokn.springboot.auto.School;
import lokn.springboot.auto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 *  自动配置
 */
@SpringBootApplication
public class AutoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoApplication.class, args);
    }

    @Autowired
    private Student student;

    @Autowired
    private School school;

    @Autowired
    private Klass klass;

    @Bean
    public void print() {
        student.init();
        school.ding();
    }

}
