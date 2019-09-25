package com.gp6.cloud.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期时间工具类
 *
 * @author gp6
 * @date 2019-09-24
 */
public class DateTimeUtil {

    /**
     * 获取当前时间
     *
     * @return 当前时间
     */
    public static Long getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return Long.valueOf(formatter.format(new Date()));
    }

}
