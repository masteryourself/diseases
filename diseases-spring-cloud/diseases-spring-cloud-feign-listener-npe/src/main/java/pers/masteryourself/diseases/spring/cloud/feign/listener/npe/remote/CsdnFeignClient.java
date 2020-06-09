package pers.masteryourself.diseases.spring.cloud.feign.listener.npe.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>description : CsdnFeignClient
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/6/9 10:50
 */
@FeignClient(value = "csdn",url = "https://blog.csdn.net/")
public interface CsdnFeignClient {

    @GetMapping("/")
    String index();

}
