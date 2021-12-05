package lokn.springboot.starter.bean;

import lombok.Data;

import javax.annotation.Resource;

@Data
public class School implements ISchool {

    @Resource
    Klass class1;

    @Resource
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
