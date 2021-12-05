package lokn.spring.factory;

import lokn.spring.pojo.InstanceBean;

/**
 * @description:
 * @author: lokn
 * @date: 2021/12/04 16:45
 */
public class MyInstance {

    public InstanceBean getInstanceBean() {
        return new InstanceBean();
    }

}
