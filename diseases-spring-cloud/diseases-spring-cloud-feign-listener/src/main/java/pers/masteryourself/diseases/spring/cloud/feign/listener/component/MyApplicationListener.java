package pers.masteryourself.diseases.spring.cloud.feign.listener.component;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>description : MyApplicationListener, 监听容器刷新事件
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/6/9 10:56
 */
@Component
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private final AtomicInteger count = new AtomicInteger(0);


    /***********************************    场景一   ***********************************/
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // 初始化操作，只能做一次，但实际它会被调用多次
        System.out.println("做了一件非常重要的事情，且只能初始化一次");
    }


    /***********************************    场景二   ***********************************/
    /*@Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        String displayName = event.getApplicationContext().getDisplayName();
        // 第[1]次调用，context 上下文是：FeignContext-baidu
        // 第[2]次调用，context 上下文是：FeignContext-csdn
        // 第[3]次调用，context 上下文是：org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@7d3e8655
        System.out.println("第[" + count.incrementAndGet() + "]次调用，context 上下文是：" + displayName);
        // 仅仅适用于 spring cloud F 版本之后，F 版本之前可使用 AtomicBoolean 来判断（因为没有设置 displayName）
        if (displayName.startsWith(FeignContext.class.getSimpleName())) {
            return;
        }
        // 初始化操作，只能做一次
        System.out.println("做了一件非常重要的事情，且只能初始化一次");
    }*/

}
