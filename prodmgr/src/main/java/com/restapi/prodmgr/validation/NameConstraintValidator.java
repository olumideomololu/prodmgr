package com.restapi.prodmgr.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

@Component
public class NameConstraintValidator implements ConstraintValidator<NamePrefix, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        // method stub
        return value.startsWith("PRD");
    }
}
