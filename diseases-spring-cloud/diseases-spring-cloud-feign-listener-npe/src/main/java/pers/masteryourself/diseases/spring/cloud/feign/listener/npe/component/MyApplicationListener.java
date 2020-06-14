package pers.masteryourself.diseases.spring.cloud.feign.listener.npe.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pers.masteryourself.diseases.spring.cloud.feign.listener.npe.FeignListenerNpeApplication;
import pers.masteryourself.diseases.spring.cloud.feign.listener.npe.remote.BaiduFeignClient;

/**
 * <p>description : MyApplicationListener, 监听容器刷新事件
 * 1. 如果先注入了 {@link BaiduFeignClient}, 再注入 {@link SomeBean}, spring 调用 onApplicationEvent() 方法的过程如下（第一次 someBean 无值）：
 * {@link FeignListenerNpeApplication} -> refresh(4) -> baiduFeignClient -> refresh(2) -> client -> refresh(1) + {@link SomeBean}
 *                                                   -> csdnFeignClient -> refresh(3)
 *
 * 2. 如果先注入了 {@link SomeBean}, 再注入 {@link BaiduFeignClient}, spring 调用 onApplicationEvent() 方法的过程如下（第一次 someBean 有值）：
 * {@link FeignListenerNpeApplication} -> refresh(4) -> baiduFeignClient -> refresh(2) -> {@link SomeBean} + client -> refresh(1)
 *                                                   -> csdnFeignClient -> refresh(3)
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/6/9 10:56
 */
@Component
public class MyApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    /***********************************    场景一   ***********************************/
    @Autowired
    private BaiduFeignClient client;

    @Autowired
    private SomeBean someBean;


    /***********************************    场景二   ***********************************/
    /*@Autowired
    private SomeBean someBean;

    @Autowired
    private BaiduFeignClient client;*/

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("context 上下文是：" + event.getApplicationContext().getDisplayName());
        someBean.doSomething();
    }

}
