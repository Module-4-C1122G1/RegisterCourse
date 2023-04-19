package com.codegym.register_course.utils;

import com.codegym.register_course.model.Curriculum;
import com.codegym.register_course.repository.ICurriculumRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueTitle.UniqueTitleValidator.class)
public @interface UniqueTitle {

    String message() default "Tên chương trình đã tồn tại. Vui lòng kiểm tra lại";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Defines several {@code @UniqueEmail} constraints on the same element.
     *
     * @see UniqueTitle
     */

    class UniqueTitleValidator implements ConstraintValidator<UniqueTitle, String> {
        @Autowired
        private ICurriculumRepository curriculumRepository;

        @Override
        public boolean isValid(String name, ConstraintValidatorContext context) {
            Curriculum curriculum = curriculumRepository.findAllByCurriculumName(name);
            return curriculum == null;
        }
    }
}
