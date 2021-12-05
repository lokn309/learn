package lokn.spring;

import lokn.spring.pojo.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: lokn
 * @date: 2021/12/05 11:43
 */
public class SpringBean {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        // 1、采用@Component注解
        Student student = (Student) context.getBean("student");
        student.setAge(12);
        student.setName("zhangsan");
        System.out.println(student.toString());

        // 2、采用xml bean配置方式
        School school = (School) context.getBean("school");
        System.out.println(school.toString());

        // 3、采用 @Configuration获取
        MyBean myBean = (MyBean) context.getBean("myBean");
        System.out.println(myBean.toString());

        // 4、采用静态工厂+xml配置获取bean
        FactoryBean factoryBean = (FactoryBean) context.getBean("factoryBean");
        System.out.println(factoryBean.toString());

        // 5、采用实例工厂+xml配置获取bean
        InstanceBean instanceBean = (InstanceBean) context.getBean("instanceBean");
        System.out.println(instanceBean.toString());

    }

}
