package com.github.ong.responsibility.chain.impl;

import com.github.ong.responsibility.chain.ChainNodeHandle;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Order(2)
public class Test2ChainNodeHandle implements ChainNodeHandle {

    @Override
    public void deal(Map<String, Object> data, Chain chain) {
        System.out.println("this is test2");
        chain.process(data);
    }
}
