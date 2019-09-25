package com.gp6.cloud.api.member;

import com.gp6.cloud.common.responses.MallResponse;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试Api
 *
 * @author gp6
 * @date 2019/09/22
 */
@RequestMapping("test")
public interface TestApi {

    /**
     * 测试api
     *
     * @return 返回结果
     */
    @RequestMapping()
    MallResponse test();
}
