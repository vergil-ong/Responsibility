package com.github.ong.responsibility.chain;

import com.github.ong.responsibility.transmission.CommonResponse;

import java.util.Map;

/**
 * 数据处理接口
 *
 * @author Wangshuo
 * @Email wangshuo@lenovocloud.com
 * @Date 2018-10-25
 */
public interface ChainNodeHandle {

    /**
     * 处理
     * @param data
     * @return
     */
    void deal(Map<String,Object> data,Chain chain);

    interface Chain{
        void process(Map<String,Object> data);
    }

}
