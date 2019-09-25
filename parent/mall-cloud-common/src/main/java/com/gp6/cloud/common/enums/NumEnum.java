package com.gp6.cloud.common.enums;

/**
 * 所用数字
 *
 * @author gp6
 * @date 2019-09-25
 */
public enum NumEnum {

    ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), ELEVEN(11), TWELVE(12), THIRTEEN(13), FOURTEEN(14), FIFTEEN(15),

    THOUSAND(1000),FILE_MAX_SIZE(1024*1024),IMG_MAX_SIZE(2*1024*1024)
    ;

    private Integer num;

    NumEnum(Integer num) {
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
