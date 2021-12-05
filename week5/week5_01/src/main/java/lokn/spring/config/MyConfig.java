package lokn.spring.config;

import lokn.spring.pojo.MyBean;
import lokn.spring.pojo.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: lokn
 * @date: 2021/12/04 16:23
 */
@Configuration
public class MyConfig {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

}
