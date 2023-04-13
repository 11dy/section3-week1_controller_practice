package com.codestates.member;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {NotSpaceValidator.class})
public @interface NotSpace {
    String message() default "공백이 아니어야 합니다"; // 디폴트 메세지
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
