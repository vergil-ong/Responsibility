package com.github.ong.responsibility.user.chain;

import com.github.ong.responsibility.chain.ChainNodeHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class User2ChainNodeHandle implements ChainNodeHandle {

    private static Logger logger = LoggerFactory.getLogger(User2ChainNodeHandle.class);

    @Override
    public void deal(Map<String, Object> data, Chain chain) {
        logger.info("this is user2");
        chain.process(data);
    }
}
