package lokn.springboot.starter.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Klass {

    List<Student> students = new ArrayList<>();

    public void dong() {
        System.out.println(this.getStudents());
    }

}
