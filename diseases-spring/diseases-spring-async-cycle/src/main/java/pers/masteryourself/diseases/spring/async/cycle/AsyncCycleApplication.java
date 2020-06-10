package pers.masteryourself.diseases.spring.async.cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.AsyncAnnotationBeanPostProcessor;
import org.springframework.scheduling.annotation.AsyncConfigurationSelector;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.ProxyAsyncConfiguration;
import pers.masteryourself.diseases.spring.async.cycle.service.SomeService;

/**
 * <p>description : AsyncCycleApplication
 * <p>{@link EnableAsync} -> {@link AsyncConfigurationSelector} -> {@link ProxyAsyncConfiguration} -> {@link AsyncAnnotationBeanPostProcessor}
 * 这个 {@link BeanPostProcessor} 会导致 {@link AbstractAutowireCapableBeanFactory#doCreateBean} 中的 initializeBean() 方法返回一个代理对象,
 * 导致在 608 行的判断中进入 else 流程，从而抛出循环引用异常
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/6/10 17:53
 */
@SpringBootApplication
@EnableAsync
public class AsyncCycleApplication implements CommandLineRunner {

    @Autowired
    private SomeService someService;

    public static void main(String[] args) {
        SpringApplication.run(AsyncCycleApplication.class);
    }

    @Override
    public void run(String... args) throws Exception {
        someService.doSomething();
    }

}
