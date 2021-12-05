package lokn.springboot.auto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Data
@NoArgsConstructor
public class Klass {

    List<Student> students;

    public void dong() {
        System.out.println(this.getStudents());
    }

}
