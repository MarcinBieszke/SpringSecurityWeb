package crm.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidImp.class)
public @interface PasswordValid {
	
	 String message() default "Password should contain uppercase letters and at least one digits";
	 Class<?>[] groups() default { };
	 Class<? extends Payload>[] payload() default { };
}
