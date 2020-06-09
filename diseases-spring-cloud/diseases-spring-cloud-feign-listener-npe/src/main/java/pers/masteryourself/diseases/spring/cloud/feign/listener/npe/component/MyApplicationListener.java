package pers.masteryourself.diseases.spring.cloud.feign.listener.npe.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pers.masteryourself.diseases.spring.cloud.feign.listener.npe.FeignListenerNpeApplication;
import pers.masteryourself.diseases.spring.cloud.feign.listener.npe.remote.BaiduFeignClient;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>description : MyApplicationListener, 监听容器刷新事件
 * 1. 如果先注入了 {@link BaiduFeignClient}, 再注入 {@link SomeBean}, spring 调用 onApplicationEvent() 方法的过程如下（第一次 someBean 无值）：
 * {@link FeignListenerNpeApplication} -> refresh(4) -> baiduFeignClient -> refresh(2) -> client -> refresh(1) + {@link SomeBean}
 *                                     -> csdnFeignClient -> refresh(3)
 *
 * 2. 如果先注入了 {@link SomeBean}, 再注入 {@link BaiduFeignClient}, spring 调用 onApplicationEvent() 方法的过程如下（第一次 someBean 有值）：
 * {@link FeignListenerNpeApplication} -> refresh(4) -> baiduFeignClient -> refresh(2) -> {@link SomeBean} + client -> refresh(1)
 *                                     -> csdnFeignClient -> refresh(3)
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

    @Autowired
    private BaiduFeignClient client;

    @Autowired
    private SomeBean someBean;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        String displayName = event.getApplicationContext().getDisplayName();
        // 第[1]次调用，context 上下文是：FeignContext-baidu
        // 第[2]次调用，context 上下文是：FeignContext-baidu
        // 第[3]次调用，context 上下文是：FeignContext-csdn
        // 第[4]次调用，context 上下文是：org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@7dc19a70
        System.out.println("第[" + count.incrementAndGet() + "]次调用，context 上下文是：" + displayName);
        // someBean 是否被初始化完成：null
        // someBean 是否被初始化完成：pers.masteryourself.diseases.spring.cloud.feign.listener.npe.component.SomeBean@312afbc7
        // someBean 是否被初始化完成：pers.masteryourself.diseases.spring.cloud.feign.listener.npe.component.SomeBean@312afbc7
        // someBean 是否被初始化完成：pers.masteryourself.diseases.spring.cloud.feign.listener.npe.component.SomeBean@312afbc7
        System.out.println("someBean 是否被初始化完成：" + someBean);
        // 仅仅适用于 spring cloud F 版本之后，F 版本之前可使用 someBean 是否被初始化来判断
        if (displayName.startsWith(FeignContext.class.getSimpleName())) {
            return;
        }
        // 初始化操作，只能做一次
        someBean.init();
    }

}
