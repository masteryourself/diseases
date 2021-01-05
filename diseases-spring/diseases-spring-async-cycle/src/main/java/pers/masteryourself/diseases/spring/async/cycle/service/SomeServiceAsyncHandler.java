package pers.masteryourself.diseases.spring.async.cycle.service;

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

    public void sendMsg() {
        System.out.println(Thread.currentThread().getName() + "：do sendMsg() method");
    }

}
