package lokn.spring.factory;

import lokn.spring.pojo.FactoryBean;

/**
 * @description:
 * @author: lokn
 * @date: 2021/12/04 16:37
 */
public class MyFactory {

    public static FactoryBean getFactoryBean() {
        return new FactoryBean();
    }

}
