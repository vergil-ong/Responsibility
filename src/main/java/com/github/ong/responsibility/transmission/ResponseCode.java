package com.github.ong.responsibility.transmission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.Arrays;

import javax.persistence.EntityNotFoundException;

/**
 *
 * 业务返回码
 *
 * @author wangshuo
 * @Email wangshuo@lenovocloud.com
 * @Date 2018-10-25
 */
@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS(25200,"成功"),
    INVALID_TOKEN(25401,"身份校验失败"),
    PROCESS_ERROR(25404,"服务处理异常"),
    NO_AVAILABLE(25500,"服务不可预知错误"),
    NONE(0,""),
    ;
    public static Logger logger = LoggerFactory.getLogger(ResponseCode.class);

    public static final String errTemplate = "{0}未找到对应的消息，使用默认消息 {1}";

    private int code;

    private String message;

    public static String parseCodeMessage(int code , String defaultMessage){
        String message = defaultMessage;
        try{
            message = Arrays.asList(values())
                    .parallelStream()
                    .filter(responseCode -> {
                        return responseCode.getCode() == code;
                    })
                    .findFirst()
                    .map(responseCode -> {
                        return responseCode.getMessage();
                    })
                    .orElseThrow(() -> new EntityNotFoundException(MessageFormat.format(errTemplate,code,defaultMessage)));

        }catch (EntityNotFoundException e){
            logger.error("EntityNotFoundException {}",e.getMessage(),e);
        }
        return message;
    }
}
