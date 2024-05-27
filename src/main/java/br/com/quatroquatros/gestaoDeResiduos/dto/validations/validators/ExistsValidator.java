package br.com.quatroquatros.gestaoDeResiduos.dto.validations.validators;

import br.com.quatroquatros.gestaoDeResiduos.dto.validations.Exists;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ExistsValidator implements ConstraintValidator<Exists, Long> {

    @PersistenceContext
    private EntityManager entityManager;


    private Class<?> entityType;

    @Override
    public void initialize(Exists constraintAnnotation){
        this.entityType = constraintAnnotation.entity();
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context){
        if(id == null){
            return false;
        }
        Object entity = entityManager.find(entityType, id);
        return entity != null;
    }

}
