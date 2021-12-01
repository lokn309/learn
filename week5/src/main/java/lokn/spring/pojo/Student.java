package lokn.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: lokn
 * @date: 2021/12/02 00:15
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String name;
    private Integer age;

}
