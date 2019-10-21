package com.gp6.cloud.api.member.hystrix.fallback;

import com.gp6.cloud.common.entity.Member;
import com.gp6.cloud.common.enums.ResponseCodeEnum;
import com.gp6.cloud.common.responses.MallResponse;
import com.gp6.cloud.api.member.feign.MemberApiFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * MemberApi 熔断器 回调
 *
 * @author gp6
 * @date 2019/10/18
 */
@Component
public class MemberApiFallbackFactory implements FallbackFactory<MemberApiFeign> {
    @Override
    public MemberApiFeign create(Throwable throwable) {
        return new MemberApiFeign() {

            @Override
            public MallResponse selectList() {
                return MallResponse.build(ResponseCodeEnum.MEMBER_HYSTRIX);
            }

            @Override
            public MallResponse register(Member member) {
                return MallResponse.build(ResponseCodeEnum.MEMBER_HYSTRIX);
            }
        };
    }
}
