package com.gp6.cloud.common.responses;

import com.gp6.cloud.common.enums.ResponseCodeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * 智慧仓自定义响应结构
 *
 * @author gp6
 * @date 2018-12-25
 */
@Getter
@Setter
@ToString
public class MallResponse {

    /**
     * 返回状态
     */
    private Integer status;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private Object data;

    private MallResponse(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private MallResponse(Object data) {
        this.status = HttpStatus.OK.value();
        this.msg = "OK";
        this.data = data;
    }

    public static MallResponse ok() {
        return new MallResponse(null);
    }

    public static MallResponse ok(Object data) {
        return new MallResponse(data);
    }

    public static MallResponse build(ResponseCodeEnum responseCodeEnum, String msg) {
        return new MallResponse(responseCodeEnum.getStatus(), msg, null);
    }

    public static MallResponse build(ResponseCodeEnum responseCodeEnum) {
        return new MallResponse(responseCodeEnum.getStatus(), responseCodeEnum.getMsg(), null);
    }

    public static MallResponse build(ResponseCodeEnum responseCodeEnum, Object data) {
        return new MallResponse(responseCodeEnum.getStatus(), responseCodeEnum.getMsg(), data);
    }

    public static MallResponse build(ResponseCodeEnum responseCodeEnum, String msg, Object data) {
        return new MallResponse(responseCodeEnum.getStatus(), msg, data);
    }
}
