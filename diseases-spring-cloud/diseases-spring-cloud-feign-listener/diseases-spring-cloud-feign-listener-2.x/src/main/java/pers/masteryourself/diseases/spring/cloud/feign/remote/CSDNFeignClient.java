package pers.masteryourself.diseases.spring.cloud.feign.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>description : CSDNFeignClient
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/6/9 10:50
 */
@FeignClient(value = "csdn",url = "https://blog.csdn.net/")
public interface CSDNFeignClient {

    @GetMapping("/")
    String index();

}
