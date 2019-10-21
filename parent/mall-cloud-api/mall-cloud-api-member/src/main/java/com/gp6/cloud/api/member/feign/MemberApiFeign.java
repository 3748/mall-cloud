package com.gp6.cloud.api.member.feign;

import com.gp6.cloud.api.member.MemberApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import com.gp6.cloud.api.member.hystrix.fallback.MemberApiFallbackFactory;

/**
 * 会员Api Feign
 *
 * @author gp6
 * @date 2019/09/27
 */
@Component
@FeignClient(value = "member", fallbackFactory = MemberApiFallbackFactory.class)
public interface MemberApiFeign extends MemberApi {

}
