package com.gp6.cloud.member.base;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 基础Mapper(集成此类可以使用通用Mapper)
 *
 * @author gp6
 * @date 2019-09-24
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
