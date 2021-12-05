package lokn.springboot.auto;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@Data
public class School implements ISchool {

    // Resource
    @Autowired(required = true) //primary
            Klass class1;

    @Resource(name = "student")
    Student student;

    @Override
    public void ding() {
        if (class1.students == null) {
            System.out.println("===== class students is null");
        } else {
            System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is ");
        }

    }

}
