package com.gp6.cloud.member.impl;

import com.gp6.cloud.api.member.MemberApi;
import com.gp6.cloud.common.entity.Member;
import com.gp6.cloud.common.enums.ResponseCodeEnum;
import com.gp6.cloud.common.responses.MallResponse;
import com.gp6.cloud.common.utils.DateTimeUtil;
import com.gp6.cloud.common.utils.ValidateUtil;
import com.gp6.cloud.member.mapper.MemberMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 会员实现类
 *
 * @author gp6
 * @date 2019/09/22
 */
@Slf4j
@RestController
public class MemberApiImpl implements MemberApi {

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public MallResponse selectList() {
        List<Member> memberList = memberMapper.selectAll();
        return MallResponse.ok(memberList);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public MallResponse register(@RequestBody Member member) {
        // 参数校验
        ValidateUtil.validate(member);
        member.setCreateTime(DateTimeUtil.getCurrentTime());
        if (memberMapper.insert(member) <= 0) {
            return MallResponse.build(ResponseCodeEnum.MEMBER_REGISTER_FAIL);
        }
        return MallResponse.build(ResponseCodeEnum.MEMBER_REGISTER_SUCCESS);
    }
}
