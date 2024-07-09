package com.miraknowledge.api.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.miraknowledge.api.annotation.valid.KnowledgeIsExistsConstraintValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * ナレッジID存在チェック アノテーション
 */
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(com.miraknowledge.api.annotation.KnowledgeIsExists.List.class)
@Documented
@Constraint(validatedBy = { KnowledgeIsExistsConstraintValidator.class })
public @interface KnowledgeIsExists {
    String message() default "{validation.KnowledgeIsExists.message}}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        KnowledgeIsExists[] value();
    }
}
