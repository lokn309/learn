package lokn.springboot.starter;

import lokn.springboot.starter.bean.Klass;
import lokn.springboot.starter.bean.School;
import lokn.springboot.starter.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: lokn
 * @date: 2021/12/05 11:53
 */
@Configuration
public class StarterAutoConfiguration {

    @Bean
    public Student student()  {
        return new Student();
    }

    @Bean
    public School school() {
        return new School();
    }

    @Bean
    public Klass klass() {
        return new Klass();
    }

}
