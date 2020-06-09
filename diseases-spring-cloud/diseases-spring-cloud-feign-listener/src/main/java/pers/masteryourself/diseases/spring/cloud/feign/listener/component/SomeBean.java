package pers.masteryourself.diseases.spring.cloud.feign.listener.component;

import org.springframework.stereotype.Component;

/**
 * <p>description : SomeBean
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/6/9 16:16
 */
@Component
public class SomeBean {

    public void init() {
        System.out.println("初始化操作，只能做一次");
    }

}
