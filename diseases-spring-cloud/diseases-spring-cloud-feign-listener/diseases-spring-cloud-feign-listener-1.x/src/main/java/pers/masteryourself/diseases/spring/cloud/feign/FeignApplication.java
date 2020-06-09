package pers.masteryourself.diseases.spring.cloud.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import pers.masteryourself.diseases.spring.cloud.feign.remote.BaiduFeignClient;
import pers.masteryourself.diseases.spring.cloud.feign.remote.CSDNFeignClient;

import java.util.Map;

/**
 * <p>description : FeignApplication
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/6/8 21:32
 */
@SpringBootApplication
@EnableFeignClients
public class FeignApplication implements ApplicationRunner {

    @Autowired
    private BaiduFeignClient baiduFeignClient;

    @Autowired
    private CSDNFeignClient csdnFeignClient;

    @Autowired
    private Map<String, ApplicationContext> contexts;

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("*******************************请求百度首页开始*******************************");
        System.out.println(baiduFeignClient.index());
        System.out.println("*******************************请求百度首页结束*******************************");
        System.out.println();
        System.out.println();
        System.out.println("*******************************请求 CSDN 首页开始*******************************");
        System.out.println(csdnFeignClient.index());
        System.out.println("*******************************请求 CSDN 首页结束*******************************");
        System.out.println();
        System.out.println();
        System.out.println(contexts);
    }

}
