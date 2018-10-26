package com.github.ong.responsibility.chain.support;

import com.github.ong.responsibility.chain.ChainNodeHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 * 链处理类
 *
 * @author wangshuo
 * @Email wangshuo@lenovocloud.com
 * @Date 2018-10-25
 */
@Component
public class Chain implements ChainNodeHandle.Chain {

    private static Logger logger = LoggerFactory.getLogger(Chain.class);

    @Autowired
    private ChainRegister chainRegister;

    @Override
    public void process(Map<String, Object> data) {
        if(chainRegister != null){
            ChainNodeHandle next = chainRegister.getNext();
            if(next!=null){
                next.deal(data,this);
            }
        }
    }
}
