package ua.vehicle.registrations.annotations;

import ua.vehicle.registrations.enums.RegistrationFields;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldName {

    RegistrationFields value();
}
