package com.springapp.mvc.validation;

import com.springapp.mvc.domain.Car;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by dn070290gsn on 30.06.2015.
 */
@Component
public class CarValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Car.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object model, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"mark","required.mark","Mark is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"model","required.model","Model is required");
    }
}
