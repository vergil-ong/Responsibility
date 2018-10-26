package com.github.ong.responsibility.user.chain;

import com.github.ong.responsibility.chain.ChainNodeHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *
 * 用户处理类
 *
 * @author wangshuo
 * @Email wangshuo@lenovocloud.com
 * @Date 2018-10-25
 */
@Component
public class UserChain implements ChainNodeHandle.Chain {

    @Autowired
    UserChainRegister userChainRegister;

    @Override
    public void process(Map<String, Object> data) {
        if(userChainRegister != null){
            ChainNodeHandle next = userChainRegister.getNext();
            if(next!=null){
                next.deal(data,this);
            }
        }
    }
}
