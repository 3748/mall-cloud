package com.gp6.cloud.common.utils;

import com.gp6.cloud.common.enums.ResponseCodeEnum;
import com.gp6.cloud.common.exceptions.MallException;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * 参数校验工具
 *
 * @author gp6
 * @date 2019-09-24
 */
public class ValidateUtil {

    private static Validator validator;

    static {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * 直接抛出异常的校验
     *
     * @param t   需校验的实体类
     * @param <T> 泛型
     */
    public static <T> void validate(T t) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t);
        if (constraintViolations.size() > 0) {
            StringBuilder validateError = new StringBuilder();
            for (ConstraintViolation<T> constraintViolation : constraintViolations) {
                validateError.append(constraintViolation.getMessage()).append("|");
            }
            if (StringUtils.isNotEmpty(validateError.toString())) {
                ResponseCodeEnum.REQUEST_PARAM_ERROR.setMsg(validateError.toString());
                throw new MallException(ResponseCodeEnum.REQUEST_PARAM_ERROR);
            }
        }
    }
}
