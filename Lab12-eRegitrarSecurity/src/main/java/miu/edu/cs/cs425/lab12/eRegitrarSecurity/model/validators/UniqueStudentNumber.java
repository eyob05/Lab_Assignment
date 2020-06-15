package miu.edu.cs.cs425.lab12.eRegitrarSecurity.model.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueStudentNumberValidator.class)
public @interface UniqueStudentNumber {
    String message() default "{edu.mum.cs.cs425.lab12.customvalidators.uniqueisbn.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
