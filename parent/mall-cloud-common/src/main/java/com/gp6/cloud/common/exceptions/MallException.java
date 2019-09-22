package com.gp6.cloud.common.exceptions;

import com.gp6.cloud.common.enums.ResponseCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 *
 * @author gp6
 * @date 2019/09/20
 */
@Getter
@Setter
public class MallException extends RuntimeException {

    private static final long serialVersionUID = -2953239955266893152L;

    /**
     * 自定义返回信息类
     */
    private ResponseCodeEnum responseCodeEnum;

    public MallException(ResponseCodeEnum responseCodeEnum) {
        this.responseCodeEnum = responseCodeEnum;
    }

    public MallException(String msg) {
        super(msg);
    }

    public MallException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String toString() {
        return this.responseCodeEnum.getMsg();
    }

    @Override
    public String getMessage() {
        return this.responseCodeEnum.getMsg();
    }
}