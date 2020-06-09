package pers.masteryourself.diseases.spring.cloud.feign.component;

import org.springframework.stereotype.Component;

/**
 * <p>description : SomeBean
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/6/9 10:57
 */
@Component
public class SomeBean {

    public SomeBean() {
        System.out.println("执行了构造方法");
    }

}
