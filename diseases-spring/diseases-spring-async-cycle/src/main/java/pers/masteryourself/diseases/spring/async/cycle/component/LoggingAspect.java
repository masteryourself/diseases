package pers.masteryourself.diseases.spring.async.cycle.component;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p>description : LoggingAspect
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/6/10 17:57
 */
@Aspect
@Component
@Order(1)
public class LoggingAspect {

    @Pointcut("execution(* pers.masteryourself.diseases.spring.async.cycle.service.*.logWithAop(..))")
    public void declareJointPointExpression() {
    }

    @Before("declareJointPointExpression()")
    public void before() {
        System.out.println("aop 生效");
    }

}
