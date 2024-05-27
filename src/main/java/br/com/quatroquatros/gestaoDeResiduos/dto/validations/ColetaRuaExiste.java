package br.com.quatroquatros.gestaoDeResiduos.dto.validations;

import br.com.quatroquatros.gestaoDeResiduos.dto.validations.validators.ColetaRuaExistsValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = ColetaRuaExistsValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ColetaRuaExiste {
    String message() default "ColetaRuaId não existe";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
