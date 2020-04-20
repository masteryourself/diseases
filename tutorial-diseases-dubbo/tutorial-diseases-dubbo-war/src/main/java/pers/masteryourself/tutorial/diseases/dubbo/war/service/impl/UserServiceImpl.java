package pers.masteryourself.tutorial.diseases.dubbo.war.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import pers.masteryourself.tutorial.diseases.dubbo.war.service.UserService;

/**
 * <p>description : UserServiceImpl
 *
 * <p>blog : https://blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2020/4/20 13:13
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public String getName() {
        return "Tom";
    }

}
