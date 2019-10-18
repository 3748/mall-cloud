package com.gp6.cloud.impl;

import com.gp6.cloud.api.member.TestApi;
import com.gp6.cloud.common.enums.ResponseCodeEnum;
import com.gp6.cloud.common.exceptions.MallException;
import com.gp6.cloud.common.responses.MallResponse;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试工具
 *
 * @author gp6
 * @date 2019/09/22
 */
@RestController
public class TestApiImpl implements TestApi {

    @Override
    public MallResponse test() {
        throw new MallException(ResponseCodeEnum.REQUEST_PARAM_ERROR);
    }

}
