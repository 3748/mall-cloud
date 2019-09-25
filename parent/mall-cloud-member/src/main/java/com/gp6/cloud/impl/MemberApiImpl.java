package com.gp6.cloud.impl;

import com.gp6.cloud.api.MemberApi;
import com.gp6.cloud.common.entity.Member;
import com.gp6.cloud.common.responses.MallResponse;
import com.gp6.cloud.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 会员实现类
 *
 * @author gp6
 * @date 2019/09/22
 */
@RestController
public class MemberApiImpl implements MemberApi {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public MallResponse selectList() {
        List<Member> memberList = memberMapper.selectAll();
        return MallResponse.ok(memberList);
    }
}
