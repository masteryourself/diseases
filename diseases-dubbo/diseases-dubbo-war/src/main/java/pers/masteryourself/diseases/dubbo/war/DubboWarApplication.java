package pers.masteryourself.diseases.dubbo.war;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <p>description : DubboWarApplication
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/4/20 13:11
 */
@SpringBootApplication
@EnableDubbo(scanBasePackages = "pers.masteryourself.diseases.dubbo.war")
public class DubboWarApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboWarApplication.class, args);
    }

}
