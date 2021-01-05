package pers.masteryourself.diseases.spring.async.cycle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <p>description : SomeService
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/6/10 17:54
 */
@Service
public class SomeService {

    /***********************************    场景一   ***********************************/
    /*public void doSomething() {
        System.out.println(Thread.currentThread().getName() + "：do doSomething finish");
        // 直接同步调用发短信方法
        this.sendMsg();
    }

    public void sendMsg() {
        System.out.println(Thread.currentThread().getName() + "：do sendMsg() method");
    }*/


    /***********************************    场景二   ***********************************/
    /**
     * 考虑到这里如果直接使用 this.sendMsg() 就不会有代理功能, 因为 Spring 增强的是代理类, 而非方法, this 是指对象本身
     * 所以自作聪明地使用了 {@link Autowired} 注入了代理对象, 然后使用这个对象去调用 sendMsg() 方法, 结果抛出了异常
     * 当此类中添加 {@link Async} 这种基于 {@link BeanPostProcessor} 去生成 aop 动态代理的组件时, 就会抛出循环引用异常
     */
    /*@Autowired
    private SomeService someService;

    public void doSomething() {
        System.out.println(Thread.currentThread().getName() + "：do doSomething finish");
        // 使用 someService 调用, 发现代理生效
        someService.sendMsg();
    }

    @Async
    public void sendMsg() {
        System.out.println(Thread.currentThread().getName() + "：do sendMsg() method");
    }*/


    /***********************************    场景三   ***********************************/
    /**
     * 使用 {@link Lazy} 避免
     * @Lazy 可以理解为在需要 bean 的时候才会去获取真正的 bean 对象, 而不是启动时候就解决其依赖问题, 这样自然就避免了循环依赖
     */
    /*@Lazy
    @Autowired
    private SomeService someServiceProxy;

    public void doSomething() {
        System.out.println(Thread.currentThread().getName() + "：do doSomething finish");
        // 使用 someService 调用, 发现代理生效
        someServiceProxy.sendMsg();
    }

    @Async
    public void sendMsg() {
        System.out.println(Thread.currentThread().getName() + "：do sendMsg() method");
    }*/

    /***********************************    场景四   ***********************************/
    /**
     * 重新定义一个组件, 把代理对象和本身分开, 勿要自作聪明, 在自己的类中注入自己
     */
    @Autowired
    private SomeServiceAsyncHandler someServiceAsyncHandler;

    @Async
    public void doSomething() {
        System.out.println(Thread.currentThread().getName() + "：do doSomething finish");
        someServiceAsyncHandler.sendMsg();
    }

}
