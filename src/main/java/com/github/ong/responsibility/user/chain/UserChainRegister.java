package com.github.ong.responsibility.user.chain;

import com.github.ong.responsibility.chain.ChainNodeHandle;
import com.github.ong.responsibility.chain.support.Chain;
import com.mysql.fabric.xmlrpc.base.Array;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * 用户链注册器
 *
 * @author wangshuo
 * @Email wangshuo@lenovocloud.com
 * @Date 2018-10-25
 */
@Component
public class UserChainRegister {

    public static final String prefix = "User";

    private static Logger logger = LoggerFactory.getLogger(UserChainRegister.class);

    private int current = 0;

    @Autowired
    private List<ChainNodeHandle> chainList;

    public ChainNodeHandle getNext(){
        if(chainList == null){
            return null;
        }

        List<ChainNodeHandle> userChinaNodeHandles = chainList.stream().filter(chainNodeHandle -> {
            String simpleName = chainNodeHandle.getClass().getSimpleName();
            if (simpleName.startsWith(prefix)) {
                return true;
            } else {
                return false;
            }
        }).collect(Collectors.toList());

        if(userChinaNodeHandles.size()>current){
            ChainNodeHandle chainNodeHandle = userChinaNodeHandles.get(current);
            current++;

            String simpleName = chainNodeHandle.getClass().getSimpleName();
//            logger.info("simpleName is {}" , simpleName);
            return chainNodeHandle;
        }
        return null;
    }
}
