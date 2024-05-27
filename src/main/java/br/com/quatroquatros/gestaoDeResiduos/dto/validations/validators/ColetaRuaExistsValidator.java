package br.com.quatroquatros.gestaoDeResiduos.dto.validations.validators;

import br.com.quatroquatros.gestaoDeResiduos.dto.validations.ColetaRuaExiste;
import br.com.quatroquatros.gestaoDeResiduos.repository.ColetaRuaRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ColetaRuaExistsValidator implements ConstraintValidator<ColetaRuaExiste, Long> {

    @Autowired
    ColetaRuaRepository coletaRuaRepository;

    @Override
    public void initialize(ColetaRuaExiste constraintAnnotation){

    }

    @Override
    public boolean isValid(Long coletaRuaId, ConstraintValidatorContext context){
        if(coletaRuaId == null){
            return false;
        }
        return coletaRuaRepository.existsById(coletaRuaId);
    }
}
