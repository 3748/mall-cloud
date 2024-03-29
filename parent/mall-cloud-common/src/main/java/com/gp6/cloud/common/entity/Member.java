package com.gp6.cloud.common.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * 会员类
 *
 * @author gp6
 * @date 2019/09/24
 */
@Getter
@Setter
@ToString
public class Member {
    /**
     * id
     */
    private Integer id;

    /**
     * 登录账号
     */
    @NotNull(message = "账号不能为空!")
    private String account;

    /**
     * 加密后密码
     */
    @NotNull(message = "密码不能为空!")
    private String password;

    /**
     * 性别 1:男 2:女 3:未知
     */
    private Integer sex;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private Integer mobile;

    /**
     * 邮箱
     */
    @NotNull(message = "邮箱不能为空!")
    private String email;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long updateTime;
}