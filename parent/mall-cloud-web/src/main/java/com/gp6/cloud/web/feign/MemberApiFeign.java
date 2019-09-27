package com.gp6.cloud.web.feign;

import com.gp6.cloud.api.member.MemberApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
* 会员Api Feign
*
* @author gp6
* @date 2019/09/27
*/
@Component
@FeignClient("member")
public interface MemberApiFeign extends MemberApi {

}
