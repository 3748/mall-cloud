package com.gp6.cloud.api;

import com.gp6.cloud.common.responses.MallResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 会员Api
 *
 * @author gp6
 * @date 2019/09/23
 */
@RequestMapping("member")
public interface MemberApi {

    /**
     * 查询会员列表
     *
     * @return 会员列表
     */
    @GetMapping
    MallResponse selectList();
}
