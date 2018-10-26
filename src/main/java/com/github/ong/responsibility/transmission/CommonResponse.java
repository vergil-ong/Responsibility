package com.github.ong.responsibility.transmission;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.stream.IntStream;

/**
 * 响应构建类
 *
 * @author Wangshuo
 * @Email wangshuo@lenovocloud.com
 * @Date 2018-10-25
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class CommonResponse {
    public static Logger logger = LoggerFactory.getLogger(CommonResponse.class);

    public static final int[] SUCCESS_CODE = {200};

    public static final String DEFAULT_SUCCESS_MESSAGE = "成功";

    /**
     * 业务码
     */
    @ApiModelProperty(value = "code", dataType = "int")
    private int code;

    /**
     *  业务消息
     */
    @ApiModelProperty(value = "message", dataType = "String")
    private String message;

    /**
     *  业务成功标识
     */
    @ApiModelProperty(value = "isSuccess", dataType = "boolean")
    private boolean isSuccess;

    /**
     * 业务数据
     */
    @ApiModelProperty(value = "datas", dataType = "Object")
    private Object datas;

    /**
     * 业务数据
     */
    @ApiModelProperty(value = "totalNum", dataType = "Long")
    private Long totalNum = 0L;

    public CommonResponse(int code, String message, boolean isSuccess, Object datas) {
        this.code = code;
        this.message = message;
        this.isSuccess = isSuccess;
        this.datas = datas;
    }

    @Override
    public String toString() {
        if(Objects.isNull(this.datas)){
            this.setDatas(new Object());
        }
        return JSON.toJSONString(this);
    }

    public static boolean parseCodeBoolean(int code){
        boolean isExist = IntStream.of(CommonResponse.SUCCESS_CODE)
                .anyMatch(sub_c -> {
                    return sub_c == code;
                });
        return isExist;
    }

    public static boolean parseCodeBoolean(ResponseCode responseCode){
        return parseCodeBoolean(responseCode.getCode());
    }

    public static String parseCodeMessage(int code){
        return ResponseCode.parseCodeMessage(code,DEFAULT_SUCCESS_MESSAGE);
    }

    public static CommonResponse buildResponse(boolean isSuccess, int code, String message, Object datas){
        CommonResponse commonResponse = new CommonResponse(code,message,isSuccess,datas);
        return commonResponse;
    }
    public static CommonResponse buildResponse(int code, String message, Object datas){
        CommonResponse commonResponse = new CommonResponse(code,message,parseCodeBoolean(code),datas);
        return commonResponse;
    }
    public static CommonResponse buildResponse(int code, Object datas){
        CommonResponse commonResponse = new CommonResponse(code,parseCodeMessage(code),parseCodeBoolean(code),datas);
        return commonResponse;
    }
    public static CommonResponse buildResponse(ResponseCode responseCode, Object datas){
        CommonResponse commonResponse = new CommonResponse(responseCode.getCode(),responseCode.getMessage(),parseCodeBoolean(responseCode),datas);
        return commonResponse;
    }
    public static CommonResponse buildResponse(ResponseCode responseCode, String message, Object datas){
        CommonResponse commonResponse = new CommonResponse(responseCode.getCode(),message,parseCodeBoolean(responseCode),datas);
        return commonResponse;
    }

    public static CommonResponse buildResponseSuccess(Object datas){
        int successCode = ResponseCode.SUCCESS.getCode();
        CommonResponse commonResponse = new CommonResponse(successCode,parseCodeMessage(successCode),parseCodeBoolean(successCode),datas);
        return commonResponse;
    }
    public static CommonResponse buildResponseSuccess(Object datas, Long totalNum){
        CommonResponse commonResponse = buildResponseSuccess(datas);
        commonResponse.setTotalNum(totalNum);
        return commonResponse;
    }
}
