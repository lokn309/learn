package lokn.spring;

import lokn.spring.pojo.School;
import lokn.spring.pojo.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 2.（必做）写代码实现 Spring Bean 的装配，方式越多越好（XML、Annotation 都可以）
 * @author: lokn
 * @date: 2021/11/28 16:46
 */
public class SpringBean {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Student student = (Student) context.getBean("student");
        student.setAge(12);
        student.setName("zhangsan");
        System.out.println(student.toString());

        School school = (School) context.getBean("school");
        System.out.println(school.toString());

    }

}
