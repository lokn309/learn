package lokn.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: lokn
 * @date: 2021/12/04 16:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FactoryBean {

    private String name;
    private Integer age;

}
