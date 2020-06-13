package pers.masteryourself.diseases.spring.async.cycle.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * <p>description : SomeServiceAsyncHandler
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/6/12 10:17
 */
@Service
public class SomeServiceAsyncHandler {

    @Async
    public void doAnotherThing() {
        System.out.println(Thread.currentThread().getName() + "：doAnotherThing() method");
    }

}
