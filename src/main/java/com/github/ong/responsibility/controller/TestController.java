package com.github.ong.responsibility.controller;

import com.github.ong.responsibility.chain.support.Chain;
import com.github.ong.responsibility.user.chain.UserChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 接口测试
 *
 * @author Wangshuo
 * @Email wangshuo@lenovocloud.com
 * @Date 2018-10-25
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    Chain chain;

    @Autowired
    UserChain userChain;

    @RequestMapping("/ping")
    public String ping(){
        logger.info("this is ping");
        return "pong";
    }

    @RequestMapping("/test1")
    public String test1(){
        chain.process(new HashMap<>());
        return "test1";
    }

    @RequestMapping("/test2")
    public String test2(){
        userChain.process(new HashMap<>());
        return "test2";
    }
}
