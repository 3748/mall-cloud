package com.gp6.cloud.api.member;

import com.gp6.cloud.common.entity.Member;
import com.gp6.cloud.common.responses.MallResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 会员Api
 *
 * @author gp6
 * @date 2019/09/23
 */
@RequestMapping("api/member")
public interface MemberApi {

    /**
     * 查询会员列表
     *
     * @return 会员列表
     */
    @GetMapping("1")
    MallResponse selectList();

    /**
     * 注册会员
     *
     * @param member 会员信息
     * @return 注册结果
     */
    @PostMapping
    MallResponse register(@RequestBody Member member);
}
