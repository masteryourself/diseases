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
        // 使用 this 调用, aop 将不会生效, Spring 做增强的是代理类, 而不是代理方法
        this.logWithAop();
    }

    public void logWithAop() {
        System.out.println(Thread.currentThread().getName() + "：do logWithAop() method");
    }*/


    /***********************************    场景二   ***********************************/
    /**
     * 考虑到这里直接使用 this.logWithAop(); 不会用代理对象去完成, 就会导致代理失效，所以自作聪明地使用了 {@link Autowired} 注入了代理对象
     */
    /*@Autowired
    private SomeService someService;

    public void doSomething() {
        System.out.println(Thread.currentThread().getName() + "：do doSomething finish");
        // 使用 someService 调用, 发现代理生效
        someService.logWithAop();
    }

    public void logWithAop() {
        System.out.println(Thread.currentThread().getName() + "：do logWithAop() method");
    }*/


    /***********************************    场景三   ***********************************/
    /**
     * 考虑到这里直接使用 this.logWithAop(); 不会用代理对象去完成, 就会导致代理失效，所以自作聪明地使用了 {@link Autowired} 注入了代理对象
     * 当此类中添加 {@link Async} 这种基于 {@link BeanPostProcessor} 去生成 aop 动态代理的组件时, 就会抛出循环引用异常
     */
    /*@Autowired
    private SomeService someService;

    @Async
    public void doSomething() {
        System.out.println(Thread.currentThread().getName() + "：do doSomething finish");
        // 使用 someService 调用, 发现代理生效
        someService.logWithAop();
    }

    public void logWithAop() {
        System.out.println(Thread.currentThread().getName() + "：do logWithAop() method");
    }*/


    /***********************************    场景四   ***********************************/
    /**
     * 使用 {@link Lazy} 避免
     */
    /*@Autowired
    @Lazy
    private SomeService someServiceProxy;

    @Async
    public void doSomething() {
        System.out.println(Thread.currentThread().getName() + "：do doSomething finish");
        // 使用 someService 调用, 发现代理生效
        someServiceProxy.logWithAop();
    }

    public void logWithAop() {
        System.out.println(Thread.currentThread().getName() + "：do logWithAop() method");
    }*/

    /***********************************    场景五   ***********************************/
    /**
     * 重新定义一个组件, 把代理对象和本身分开, 勿要自作聪明, 在自己的类中注入自己
     */
    @Autowired
    private SomeServiceAsyncHandler someServiceAsyncHandler;

    @Async
    public void doSomething() {
        System.out.println(Thread.currentThread().getName() + "：do doSomething finish");
        someServiceAsyncHandler.logWithAop();
    }

}
