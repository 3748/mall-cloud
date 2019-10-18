package com.gp6.cloud.web.controller;

import com.gp6.cloud.common.entity.Member;
import com.gp6.cloud.common.responses.MallResponse;
import com.gp6.cloud.web.feign.MemberApiFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 会员Controller
 *
 * @author gp6
 * @date 2019/09/27
 */
@Slf4j
@RestController
@RequestMapping({"member"})
public class MemberController {

    @Autowired
    private MemberApiFeign memberApiFeign;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查询会员列表(Feign)
     *
     * @return 会员列表
     */
    @GetMapping({"feign"})
    public MallResponse selectListByFeign() {
        return memberApiFeign.selectList();
    }

    /**
     * 查询会员列表(Ribbon)
     *
     * @return 会员列表
     */
    @GetMapping({"ribbon"})
    public ResponseEntity<MallResponse> selectListByRibbon() {
        return restTemplate.getForEntity("http://MEMBER/api/member", MallResponse.class);
    }

    /**
     * 查询会员列表(hystrix)
     *
     * @return 会员列表
     */
    @PostMapping({"hystrix"})
    public MallResponse selectListByHystrix(@RequestBody Member member) {
        return memberApiFeign.register(member);
    }

}
