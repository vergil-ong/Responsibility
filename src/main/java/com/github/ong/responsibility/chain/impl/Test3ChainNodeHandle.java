package com.github.ong.responsibility.chain.impl;

import com.github.ong.responsibility.chain.ChainNodeHandle;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Order(3)
public class Test3ChainNodeHandle implements ChainNodeHandle {

    @Override
    public void deal(Map<String, Object> data, Chain chain) {
        System.out.println("this is test3");
        chain.process(data);
    }
}
