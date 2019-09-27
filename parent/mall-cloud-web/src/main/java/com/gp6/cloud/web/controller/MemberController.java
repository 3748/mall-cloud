package com.gp6.cloud.web.controller;

import com.gp6.cloud.common.responses.MallResponse;
import com.gp6.cloud.web.feign.MemberApiFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 查询会员列表
     *
     * @return 会员列表
     */
    @GetMapping("1")
    public MallResponse selectList() {
        return memberApiFeign.selectList();
    }
}
