package pers.masteryourself.diseases.spring.cloud.feign.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import pers.masteryourself.diseases.spring.cloud.feign.listener.remote.BaiduFeignClient;
import pers.masteryourself.diseases.spring.cloud.feign.listener.remote.CsdnFeignClient;

/**
 * <p>description : FeignListenerApplication
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/6/8 21:32
 */
@SpringBootApplication
@EnableFeignClients
public class FeignListenerApplication implements ApplicationRunner {

    @Autowired
    private BaiduFeignClient baiduFeignClient;

    @Autowired
    private CsdnFeignClient csdnFeignClient;

    public static void main(String[] args) {
        SpringApplication.run(FeignListenerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("*******************************请求百度首页开始*******************************");
        baiduFeignClient.index();
        System.out.println("*******************************请求百度首页结束*******************************");
        System.out.println();
        System.out.println();
        System.out.println("*******************************请求 CSDN 首页开始*******************************");
        csdnFeignClient.index();
        System.out.println("*******************************请求 CSDN 首页结束*******************************");
    }

}
