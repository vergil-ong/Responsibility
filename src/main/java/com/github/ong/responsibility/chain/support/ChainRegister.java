package com.github.ong.responsibility.chain.support;

import com.github.ong.responsibility.chain.ChainNodeHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 链注册器
 *
 * @author wangshuo
 * @Email wangshuo@lenovocloud.com
 * @Date 2018-10-25
 */
@Component
public class ChainRegister {

    private static Logger logger = LoggerFactory.getLogger(Chain.class);

    private int current = 0;

    @Autowired
    private List<ChainNodeHandle> chainList;

    public boolean regist(ChainNodeHandle chainNodeHandle){
        if(chainList == null){
            chainList = new ArrayList<>();
        }
        chainList.add(chainNodeHandle);
        return true;
    }

    public ChainNodeHandle getNext(){
        if(chainList == null){
            return null;
        }
        if(chainList.size()>current){
            ChainNodeHandle chainNodeHandle = chainList.get(current);
            current++;
            return chainNodeHandle;
        }
        return null;
    }
}
