package pers.masteryourself.diseases.spring.cloud.feign.listener.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>description : RemoteFeignClient
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/6/9 10:42
 */
@FeignClient(value = "baidu",url = "http://wwww.baidu.com")
public interface BaiduFeignClient {

    @GetMapping("/")
    String index();

}
