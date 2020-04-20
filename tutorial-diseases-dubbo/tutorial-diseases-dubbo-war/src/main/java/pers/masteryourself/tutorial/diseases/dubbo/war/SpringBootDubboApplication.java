package pers.masteryourself.tutorial.diseases.dubbo.war;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>description : SpringBootDubboApplication
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/4/20 13:11
 */
@SpringBootApplication
@EnableDubbo(scanBasePackages = "pers.masteryourself.tutorial.diseases.spring.boot.dubbo")
public class SpringBootDubboApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDubboApplication.class, args);
    }

}
