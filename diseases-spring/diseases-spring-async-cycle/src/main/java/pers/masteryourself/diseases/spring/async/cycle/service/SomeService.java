package pers.masteryourself.diseases.spring.async.cycle.service;

import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println(Thread.currentThread().getName() + "：doSomething finish");
        // 使用 this 调用, aop 将不会生效, Spring 做增强的是代理类, 而不是代理方法
        this.doAnotherThing();
    }

    public void doAnotherThing() {
        System.out.println(Thread.currentThread().getName() + "：doAnotherThing() method");
    }*/


    /***********************************    场景二   ***********************************/
    /**
     * 考虑到这里直接使用 this.doAnotherThing(); 不会用代理对象去完成, 就会导致代理失效，所以自作聪明地使用了 {@link Autowired} 注入了当前对象
     * 结果很悲催的发现抛出循环引用异常
     */
    @Autowired
    private SomeService someService;

    public void doSomething() {
        System.out.println(Thread.currentThread().getName() + "：doSomething finish");
        // 使用 someService 调用, 发现代理生效
        someService.doAnotherThing();
    }

    @Async
    public void doAnotherThing() {
        System.out.println(Thread.currentThread().getName() + "：doAnotherThing() method");
    }


    /***********************************    场景三   ***********************************/
    /*@Autowired
    @Lazy
    private SomeService someService;

    public void doSomething() {
        System.out.println(Thread.currentThread().getName() + "：doSomething finish");
        // 使用 someService 调用, 发现代理生效
        someService.doAnotherThing();
    }

    @Async
    public void doAnotherThing() {
        System.out.println(Thread.currentThread().getName() + "：doAnotherThing() method");
    }*/


    /***********************************    场景四   ***********************************/
    /**
     * 重新定义一个组件, 把代理对象和本身分开, 勿要自作聪明, 在自己的类中注入自己
     */
    /*@Autowired
    private SomeServiceAsyncHandler someServiceAsyncHandler;

    public void doSomething() {
        System.out.println(Thread.currentThread().getName() + "：doSomething finish");
        someServiceAsyncHandler.doAnotherThing();
    }*/

}
